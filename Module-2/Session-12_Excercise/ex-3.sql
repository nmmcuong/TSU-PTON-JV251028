CREATE TABLE order_logs (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    old_status ENUM('Pending', 'Completed', 'Cancelled'),
    new_status ENUM('Pending', 'Completed', 'Cancelled'),
    log_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE
);

DELIMITER //
CREATE TRIGGER before_insert_check_payment
BEFORE INSERT ON payments
FOR EACH ROW
BEGIN
    DECLARE v_total DECIMAL(10,2);
    -- Lấy tổng tiền của đơn hàng tương ứng
    SELECT total_amount INTO v_total FROM orders WHERE order_id = NEW.order_id;
    
    -- Nếu số tiền thanh toán không khớp, báo lỗi và chặn lại
    IF NEW.amount <> v_total THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Số tiền thanh toán không khớp với tổng đơn hàng!';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER after_update_order_status
AFTER UPDATE ON orders
FOR EACH ROW
BEGIN
    -- Chỉ ghi log nếu trạng thái thực sự thay đổi
    IF OLD.status <> NEW.status THEN
        INSERT INTO order_logs (order_id, old_status, new_status)
        VALUES (OLD.order_id, OLD.status, NEW.status);
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_update_order_status_with_payment(
    IN p_order_id INT,
    IN p_new_status VARCHAR(20),
    IN p_amount DECIMAL(10,2),
    IN p_method VARCHAR(50)
)
BEGIN
    DECLARE v_current_status VARCHAR(20);

    -- Khai báo trình xử lý lỗi để tự động Rollback
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Giao dịch thất bại: Dữ liệu không hợp lệ hoặc lỗi hệ thống!' AS message;
    END;

    START TRANSACTION;

    -- Kiểm tra trạng thái hiện tại
    SELECT status INTO v_current_status FROM orders WHERE order_id = p_order_id;

    -- Nếu trạng thái đã giống trạng thái mới thì không làm gì và Rollback
    IF v_current_status = p_new_status THEN
        ROLLBACK;
        SELECT 'Trạng thái mới không được trùng với trạng thái hiện tại!' AS message;
    ELSE
        -- Nếu chuyển sang 'Completed', thực hiện ghi nhận thanh toán
        -- (Tại đây Trigger check_payment sẽ tự động kiểm tra số tiền p_amount)
        IF p_new_status = 'Completed' THEN
            INSERT INTO payments (order_id, payment_date, amount, payment_method)
            VALUES (p_order_id, NOW(), p_amount, p_method);
        END IF;

        -- Cập nhật trạng thái đơn hàng
        UPDATE orders SET status = p_new_status WHERE order_id = p_order_id;

        COMMIT;
        SELECT 'Cập nhật trạng thái và thanh toán thành công!' AS message;
    END IF;
END //
DELIMITER ;