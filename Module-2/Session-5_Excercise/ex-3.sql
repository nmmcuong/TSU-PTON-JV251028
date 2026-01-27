
CREATE DATABASE IF NOT EXISTS ProductManagement;
USE ProductManagement;

CREATE TABLE IF NOT EXISTS products (
    product_id VARCHAR(10) PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    price DECIMAL(15, 2)
);

-- 2. THÊM DỮ LIỆU MẪU ĐỂ THỰC HÀNH
INSERT INTO products (product_id, product_name, category, price) VALUES 
('P001', 'MacBook Air M2', 'Laptop', 28000000),
('P002', 'Dell XPS 13', 'Laptop', 35000000),
('P003', 'iPhone 15 Pro', 'Phone', 25000000),
('P004', 'Samsung Galaxy S23', 'Phone', 12000000),
('P005', 'iPad Pro M2', 'Tablet', 18000000),
('P006', 'Logitech Mouse', 'Accessory', 500000),
('P007', 'Mechanical Keyboard', 'Accessory', 1500000);



-- 3. Hiển thị các sản phẩm có giá cao hơn giá trung bình của tất cả sản phẩm
SELECT * FROM products 
WHERE price > (SELECT AVG(price) FROM products);

-- 4. Hiển thị sản phẩm có giá cao nhất trong từng loại sản phẩm
SELECT * FROM products p1
WHERE price = (
    SELECT MAX(price) 
    FROM products p2 
    WHERE p2.category = p1.category
);

-- 5. Hiển thị các sản phẩm thuộc loại có ít nhất một sản phẩm giá trên 20.000.000
SELECT * FROM products 
WHERE category IN (
    SELECT category 
    FROM products 
    WHERE price > 20000000
);