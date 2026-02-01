create database productsManager;
use productsManager;

-- 1. Tạo bảng Categories (Danh mục)
CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- 2. Tạo bảng Customers (Khách hàng)
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- 3. Tạo bảng Products (Sản phẩm)
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- 4. Tạo bảng Orders (Đơn hàng)
CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    order_date DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- 5. Tạo bảng Order_details (Chi tiết đơn hàng)
CREATE TABLE order_details (
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

#Thêm 2 khách hàng mới
INSERT INTO customers (name, email)
VALUES 
('Nguyen Van A', 'vana@example.com'),
('Le Thi B', 'thib@example.com');

#Liệt kê khách hàng đã có ít nhất một đơn hàng
SELECT DISTINCT c.id, c.name, c.email
FROM customers c
JOIN orders o ON c.id = o.customer_id;

#Tìm khách hàng chưa từng đặt đơn hàng nào
SELECT c.id, c.name, c.email
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id
WHERE o.id IS NULL;

#Tính tổng doanh thu mỗi khách hàng
SELECT c.id, c.name, SUM(od.quantity * od.price) AS total_revenue
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id
LEFT JOIN order_details od ON o.id = od.order_id
GROUP BY c.id, c.name;

#Xác định khách hàng đã mua sản phẩm có giá cao nhất
SELECT c.name, p.name AS product_name, od.price AS max_price
FROM customers c
JOIN orders o ON c.id = o.customer_id
JOIN order_details od ON o.id = od.order_id
JOIN products p ON od.product_id = p.id
ORDER BY od.price DESC
LIMIT 1;