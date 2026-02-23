-- 1. Thiết kế cơ sở dữ liệu
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100),
    price DECIMAL(10, 2),
    stock INT
);

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    quantity INT,
    total_price DECIMAL(10, 2),
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Thêm dữ liệu mẫu
INSERT INTO products (product_name, price, stock) VALUES ('Laptop Gaming', 20000000, 10);

-- 2. Tạo Stored Procedure place_order
DELIMITER //

CREATE PROCEDURE place_order(
    IN p_product_id INT,
    IN p_quantity INT
)
BEGIN
    DECLARE v_price DECIMAL(10, 2);
    DECLARE v_stock INT;
    
    -- Xử lý lỗi: Tự động Rollback nếu có lỗi SQL xảy ra
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Lỗi SQL: Đặt hàng thất bại!' AS message;
    END;

    -- Bắt đầu Transaction
    START TRANSACTION;

    -- Lấy thông tin sản phẩm (Sử dụng FOR UPDATE để khóa dòng, tránh tranh chấp dữ liệu)
    SELECT price, stock INTO v_price, v_stock 
    FROM products 
    WHERE id = p_product_id FOR UPDATE;

    -- Kiểm tra số lượng tồn kho
    IF v_stock >= p_quantity THEN
        -- Bước 1: Trừ tồn kho
        UPDATE products SET stock = stock - p_quantity WHERE id = p_product_id;
        
        -- Bước 2: Tạo đơn hàng
        INSERT INTO orders (product_id, quantity, total_price)
        VALUES (p_product_id, p_quantity, v_price * p_quantity);
        
        -- Xác nhận giao dịch
        COMMIT;
        SELECT 'Đặt hàng thành công!' AS message;
    ELSE
        -- Hủy giao dịch nếu không đủ hàng
        ROLLBACK;
        SELECT 'Đặt hàng thất bại: Kho không đủ hàng!' AS message;
    END IF;
END //

DELIMITER ;