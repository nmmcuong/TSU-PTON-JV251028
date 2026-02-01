CREATE DATABASE sales_management;
USE sales_management;

-- Tạo bảng khách hàng (customers)
CREATE TABLE customers (
    ma_khach_hang VARCHAR(20) PRIMARY KEY, 
    ten_khach_hang VARCHAR(255) NOT NULL   
);

-- Tạo bảng đơn hàng (orders)
CREATE TABLE orders (
    ma_don_hang VARCHAR(20) PRIMARY KEY,   
    ngay_dat_hang DATE NOT NULL,          
    ma_khach_hang VARCHAR(20),             
    FOREIGN KEY (ma_khach_hang) REFERENCES customers(ma_khach_hang)
);

-- 2. Tạo VIEW v_order_info theo yêu cầu
CREATE VIEW v_order_info AS
SELECT 
    o.ma_don_hang,     
    o.ngay_dat_hang,   
    c.ten_khach_hang   
FROM 
    orders o
JOIN 
    customers c ON o.ma_khach_hang = c.ma_khach_hang; 

INSERT INTO customers VALUES ('KH001', 'Nguyen Van A'), ('KH002', 'Tran Thi B');
INSERT INTO orders VALUES ('DH101', '2024-03-20', 'KH001'), ('DH102', '2024-03-21', 'KH002');