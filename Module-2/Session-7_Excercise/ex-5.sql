CREATE DATABASE company_db;
USE company_db;

CREATE TABLE employees (
    ma_nhan_vien VARCHAR(20) PRIMARY KEY,
    ho_ten VARCHAR(255) NOT NULL,          
    phong_ban VARCHAR(100),                
    luong DOUBLE,                          
    so_CMND VARCHAR(20)                    
);

-- 2. Tạo VIEW v_employee_public theo yêu cầu
CREATE VIEW v_employee_public AS
SELECT 
    ma_nhan_vien, 
    ho_ten,       
    phong_ban    
FROM 
    employees;