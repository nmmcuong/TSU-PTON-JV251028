-- Tạo Database
CREATE DATABASE IF NOT EXISTS sales_management;
USE sales_management;

-- Tạo Table
CREATE TABLE IF NOT EXISTS customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    address VARCHAR(255) NOT NULL
);

-- Tạo Index
CREATE UNIQUE INDEX idx_email ON customers(email);
CREATE INDEX idx_phone ON customers(phone);

-- Kiểm tra kết quả
EXPLAIN SELECT * FROM customers WHERE email = 'test@example.com';