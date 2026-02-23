-- 1. Tạo bảng products
CREATE TABLE IF NOT EXISTS products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    price DECIMAL(15, 2) NOT NULL CHECK (price > 0),
    stock INT NOT NULL CHECK (stock > 0)
);

-- 2. Thêm 20 bản ghi mẫu
INSERT INTO products (product_name, price, stock) VALUES
('Product 1', 500000, 10), ('Product 2', 1500000, 5),
('Product 3', 2000000, 8), ('Product 4', 800000, 12),
('Product 5', 2500000, 15), ('Product 6', 300000, 20),
('Product 7', 1200000, 7), ('Product 8', 900000, 4),
('Product 9', 1750000, 6), ('Product 10', 450000, 10),
('Product 11', 600000, 9), ('Product 12', 1100000, 13),
('Product 13', 200000, 25), ('Product 14', 950000, 3),
('Product 15', 3500000, 6), ('Product 16', 750000, 11),
('Product 17', 5555555, 8), ('Product 18', 400000, 14),
('Product 19', 1050000, 5), ('Product 20', 300000, 18);

-- 3. Tạo Stored Procedure
DELIMITER //
CREATE PROCEDURE get_high_value_products()
BEGIN
    SELECT * FROM products WHERE price > 1000000;
END //
DELIMITER ;

-- 4. Gọi Procedure để kiểm tra kết quả
CALL get_high_value_products();