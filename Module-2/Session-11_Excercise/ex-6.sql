ALTER TABLE orders ADD COLUMN status VARCHAR(20) DEFAULT 'Pending';
DELIMITER //

CREATE PROCEDURE cancel_order(IN p_order_id INT)
BEGIN
    DECLARE v_product_id INT;
    DECLARE v_quantity INT;
    DECLARE v_status VARCHAR(20);

    -- Xử lý lỗi tự động Rollback
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Lỗi: Hủy đơn hàng thất bại!' AS message;
    END;

    -- Kiểm tra thông tin đơn hàng
    SELECT product_id, quantity, status INTO v_product_id, v_quantity, v_status 
    FROM orders WHERE id = p_order_id;

    -- Chỉ hủy nếu đơn hàng tồn tại và chưa bị hủy
    IF v_status IS NOT NULL AND v_status <> 'Cancelled' THEN
        START TRANSACTION;

        -- Bước 1: Cập nhật trạng thái đơn hàng
        UPDATE orders SET status = 'Cancelled' WHERE id = p_order_id;

        -- Bước 2: Hoàn trả số lượng vào kho
        UPDATE products SET stock = stock + v_quantity WHERE id = v_product_id;

        COMMIT;
        SELECT 'Hủy đơn hàng thành công! Đã hoàn tồn kho.' AS message;
    ELSE
        SELECT 'Lỗi: Đơn hàng không tồn tại hoặc đã bị hủy trước đó.' AS message;
    END IF;
END //

DELIMITER ;