CREATE DATABASE company_management;
USE company_management;

-- Tạo bảng nhân viên (employees)
CREATE TABLE employees (
    ma_nhan_vien VARCHAR(20) PRIMARY KEY, 
    ho_ten VARCHAR(255) NOT NULL,         
    department VARCHAR(100),               
    luong DOUBLE                          
);

-- Tạo INDEX cho cột department theo yêu cầu
CREATE INDEX idx_department ON employees(department);