-- 1. Tạo bảng cart_items (Chi tiết giỏ hàng)
CREATE TABLE IF NOT EXISTS cart_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 2. Tạo Trigger before_cart_add
DELIMITER //

CREATE TRIGGER before_cart_add
BEFORE INSERT ON cart_items
FOR EACH ROW
BEGIN
    DECLARE current_stock INT;
    
    -- Lấy số lượng tồn kho của sản phẩm đang định thêm vào giỏ
    SELECT quantity INTO current_stock 
    FROM products 
    WHERE product_id = NEW.product_id;
    
    -- So sánh số lượng khách muốn mua với số lượng tồn kho
    IF NEW.quantity > current_stock THEN
        -- Chặn thao tác và báo lỗi nếu không đủ hàng
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Số lượng hàng trong kho không đủ để thêm vào giỏ!';
    END IF;
END //

DELIMITER ;