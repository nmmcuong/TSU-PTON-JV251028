CREATE DATABASE order_management;
USE order_management;

CREATE TABLE orders (
    ma_don_hang VARCHAR(20) PRIMARY KEY, 
    ngay_dat_hang DATE NOT NULL,          
    trang_thai_don_hang VARCHAR(50),      
    tong_tien DOUBLE                       
);

CREATE INDEX idx_search_status_date 
ON orders(trang_thai_don_hang, ngay_dat_hang);