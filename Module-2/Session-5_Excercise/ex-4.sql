
CREATE DATABASE IF NOT EXISTS SalesManagement;
USE SalesManagement;

-- 1. TẠO CÁC BẢNG DỮ LIỆU
CREATE TABLE IF NOT EXISTS Customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Orders (
    order_id INT PRIMARY KEY,
    order_date DATE,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

CREATE TABLE IF NOT EXISTS Order_items (
    order_id INT,
    product_name VARCHAR(255),
    quantity INT,
    price DECIMAL(15, 2),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);

-- 2. THÊM DỮ LIỆU
INSERT INTO Customers VALUES (1, 'Nguyen Van A'), (2, 'Tran Thi B');
INSERT INTO Orders VALUES (101, '2026-01-20', 1), (102, '2026-01-25', 2);
INSERT INTO Order_items VALUES 
(101, 'Laptop Dell', 1, 15000000), 
(101, 'Mouse Wireless', 2, 500000),
(102, 'iPhone 15', 1, 25000000);

-- 3. Hiển thị: mã đơn hàng, ngày đặt hàng, tên khách hàng
SELECT o.order_id, o.order_date, c.customer_name
FROM Orders o
JOIN Customers c ON o.customer_id = c.customer_id;

-- 4. Hiển thị: danh sách sản phẩm trong mỗi đơn hàng
SELECT order_id, product_name, quantity, price
FROM Order_items;

-- 5. Tính: tổng tiền của mỗi đơn hàng
SELECT order_id, SUM(quantity * price) AS total_amount
FROM Order_items
GROUP BY order_id;

-- 6. Hiển thị: các đơn hàng có tổng tiền lớn hơn 10.000.000
SELECT order_id, SUM(quantity * price) AS total_amount
FROM Order_items
GROUP BY order_id
HAVING total_amount > 10000000;