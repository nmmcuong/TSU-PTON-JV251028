
CREATE DATABASE IF NOT EXISTS SalesRevenueDB;
USE SalesRevenueDB;

-- 1. TẠO CẤU TRÚC CÁC BẢNG 
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

-- 2. THÊM DỮ LIỆU MẪU ĐỂ THỰC HIỆN TRUY VẤN
INSERT INTO Customers VALUES (1, 'Nguyen Van A'), (2, 'Tran Thi B'), (3, 'Le Van C');
INSERT INTO Orders VALUES (101, '2026-01-10', 1), (102, '2026-01-15', 2), (103, '2026-01-20', 1);
INSERT INTO Order_items VALUES 
(101, 'Laptop', 1, 25000000), 
(102, 'Phone', 1, 15000000), 
(103, 'Mouse', 2, 500000);

-- 3. Hiển thị: mã đơn hàng, tên khách hàng, tổng tiền của đơn hàng
SELECT o.order_id, c.customer_name, SUM(oi.quantity * oi.price) AS total_order_amount
FROM Orders o
JOIN Customers c ON o.customer_id = c.customer_id
JOIN Order_items oi ON o.order_id = oi.order_id
GROUP BY o.order_id, c.customer_name;

-- 4. Tính: tổng doanh thu của mỗi khách hàng
SELECT c.customer_name, SUM(oi.quantity * oi.price) AS total_revenue
FROM Customers c
JOIN Orders o ON c.customer_id = o.customer_id
JOIN Order_items oi ON o.order_id = oi.order_id
GROUP BY c.customer_id, c.customer_name;

-- 5. Chỉ hiển thị: các khách hàng có tổng doanh thu lớn hơn 20.000.000
SELECT c.customer_name, SUM(oi.quantity * oi.price) AS total_revenue
FROM Customers c
JOIN Orders o ON c.customer_id = o.customer_id
JOIN Order_items oi ON o.order_id = oi.order_id
GROUP BY c.customer_id, c.customer_name
HAVING total_revenue > 20000000;

-- 6. Hiển thị: khách hàng có doanh thu cao nhất
SELECT c.customer_name, SUM(oi.quantity * oi.price) AS max_revenue
FROM Customers c
JOIN Orders o ON c.customer_id = o.customer_id
JOIN Order_items oi ON o.order_id = oi.order_id
GROUP BY c.customer_id, c.customer_name
ORDER BY max_revenue DESC
LIMIT 1;