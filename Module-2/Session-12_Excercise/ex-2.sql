DELIMITER //
CREATE PROCEDURE sp_create_order(
    IN p_customer_id INT,
    IN p_product_id INT,
    IN p_quantity INT,
    IN p_price DECIMAL(10,2)
)
BEGIN
    DECLARE v_stock INT;
    DECLARE v_order_id INT;

    -- Bắt đầu Transaction
    START TRANSACTION;

    -- Kiểm tra số lượng tồn kho
    SELECT stock_quantity INTO v_stock FROM inventory WHERE product_id = p_product_id;

    IF v_stock >= p_quantity THEN
        -- 1. Thêm vào bảng orders
        INSERT INTO orders (customer_id, order_date, total_amount, status) 
        VALUES (p_customer_id, NOW(), 0, 'Pending');
        
        -- 2. Lấy ID đơn hàng vừa tạo
        SET v_order_id = LAST_INSERT_ID();

        -- 3. Thêm vào bảng order_items
        INSERT INTO order_items (order_id, product_id, quantity, price) 
        VALUES (v_order_id, p_product_id, p_quantity, p_price);

        -- 4. Cập nhật giảm tồn kho trong bảng inventory
        UPDATE inventory SET stock_quantity = stock_quantity - p_quantity WHERE product_id = p_product_id;

        COMMIT;
        SELECT 'Tạo đơn hàng thành công!' AS message;
    ELSE
        -- Không đủ hàng thì hoàn tác
        ROLLBACK;
        SELECT 'Lỗi: Không đủ hàng trong kho!' AS message;
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_pay_order(IN p_order_id INT, IN p_payment_method VARCHAR(50))
BEGIN
    DECLARE v_status VARCHAR(20);
    DECLARE v_total DECIMAL(10,2);

    START TRANSACTION;

    -- Kiểm tra trạng thái và lấy tổng tiền
    SELECT status, total_amount INTO v_status, v_total FROM orders WHERE order_id = p_order_id;

    IF v_status = 'Pending' THEN
        -- 1. Ghi nhận thanh toán
        INSERT INTO payments (order_id, payment_date, amount, payment_method) 
        VALUES (p_order_id, NOW(), v_total, p_payment_method);

        -- 2. Cập nhật đơn hàng thành hoàn tất
        UPDATE orders SET status = 'Completed' WHERE order_id = p_order_id;

        COMMIT;
        SELECT 'Thanh toán thành công!' AS message;
    ELSE
        ROLLBACK;
        SELECT 'Lỗi: Đơn hàng không ở trạng thái chờ thanh toán!' AS message;
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_cancel_order(IN p_order_id INT)
BEGIN
    DECLARE v_status VARCHAR(20);

    START TRANSACTION;

    SELECT status INTO v_status FROM orders WHERE order_id = p_order_id;

    IF v_status = 'Pending' THEN
        -- 1. Hoàn trả số lượng hàng vào kho cho tất cả sản phẩm trong đơn
        UPDATE inventory i
        JOIN order_items oi ON i.product_id = oi.product_id
        SET i.stock_quantity = i.stock_quantity + oi.quantity
        WHERE oi.order_id = p_order_id;

        -- 2. Xóa các sản phẩm liên quan khỏi order_items
        DELETE FROM order_items WHERE order_id = p_order_id;

        -- 3. Cập nhật trạng thái đơn hàng thành 'Cancelled'
        UPDATE orders SET status = 'Cancelled' WHERE order_id = p_order_id;

        COMMIT;
        SELECT 'Hủy đơn hàng thành công!' AS message;
    ELSE
        ROLLBACK;
        SELECT 'Lỗi: Không thể hủy đơn hàng đã hoàn tất hoặc đã hủy!' AS message;
    END IF;
END //
DELIMITER ;