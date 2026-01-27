CREATE DATABASE IF NOT EXISTS DBProducts ;
use DBProducts ;

CREATE TABLE IF NOT EXISTS products (
    product_id VARCHAR(10) PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    price DECIMAL(15, 2),
    quantity INT
);

-- 1. THÊM DỮ LIỆU (INSERT)
-- Thêm ít nhất 5 sản phẩm, trong đó có ít nhất 2 Laptop và 1 Phone
INSERT INTO products (product_id, product_name, category, price, quantity) VALUES 
('P001', 'MacBook Air M2', 'Laptop', 28000000, 10),
('P002', 'Dell XPS 13', 'Laptop', 14000000, 5),
('P003', 'iPhone 15 Pro', 'Phone', 25000000, 8),
('P004', 'Samsung Galaxy S23', 'Phone', 12000000, 15),
('P005', 'iPad Pro M2', 'Tablet', 18000000, 0), 
('P006', 'Samsung Galaxy Tab', 'Tablet', 7000000, 12),
('P007', 'Asus Vivobook', 'Laptop', 13500000, 20);

/* --- TRUY VẤN DỮ LIỆU (SELECT) --- */
-- 2. Hiển thị sản phẩm có giá từ 5.000.000 đến 15.000.000
SELECT * FROM products 
WHERE price BETWEEN 5000000 AND 15000000;

-- 3. Hiển thị sản phẩm thuộc loại Laptop hoặc Tablet
SELECT * FROM products 
WHERE category IN ('Laptop', 'Tablet');

-- 4. Hiển thị sản phẩm có tên bắt đầu bằng “Sam”
SELECT * FROM products 
WHERE product_name LIKE 'Sam%';

-- 5. Hiển thị sản phẩm không thuộc loại Phone
SELECT * FROM products 
WHERE category != 'Phone';

/* --- CẬP NHẬT & XÓA DỮ LIỆU (UPDATE – DELETE) --- */

-- 6. Giảm giá 5% cho các sản phẩm thuộc loại Laptop
-- Công thức: giá mới = giá cũ * 0.95
UPDATE products 
SET price = price * 0.95 
WHERE category = 'Laptop';

-- 7. Xóa các sản phẩm có số lượng tồn kho bằng 0
DELETE FROM products 
WHERE quantity = 0;

-- 8. Kiểm tra lại bảng sau mỗi thao tác bằng SELECT
SELECT * FROM products;