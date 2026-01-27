CREATE DATABASE IF NOT EXISTS DBEmployees ;
use DBEmployees ;

CREATE TABLE IF NOT EXISTS employees (
    emp_id INT PRIMARY KEY,              
    full_name VARCHAR(255) NOT NULL,     
    birth_year INT,                      
    department VARCHAR(100),             
    salary DECIMAL(15, 2),               
    phone VARCHAR(20) DEFAULT NULL       
);

-- 1. THÊM TỐI THIỂU 10 DỮ LIỆU MẪU VÀO BẢNG
INSERT INTO employees (emp_id, full_name, birth_year, department, salary, phone) VALUES 
(1, 'Nguyen Lan Anh', 1995, 'IT', 15000000, '0912345678'),
(2, 'Tran Tuan Tu', 1990, 'HR', 12000000, NULL), 
(3, 'Le Thi Van Anh', 1998, 'IT', 18000000, '0987654321'),
(4, 'Pham Duc Minh', 1992, 'Marketing', 22000000, '0901122334'),
(5, 'Hoang Anh Quan', 1996, 'IT', 4500000, '0933445566'), 
(6, 'Do Thuy Chi', 1994, 'HR', 11000000, '0944556677'),
(7, 'Vu Minh Anh', 1997, 'Sales', 9000000, NULL),
(8, 'Bui Quang Huy', 1991, 'IT', 25000000, '0966778899'),
(9, 'Ngo Tuong Vi', 1993, 'Accountant', 13000000, '0977889900'),
(10, 'Dang Hoang Anh', 1999, 'IT', 10500000, '0988990011');

-- 2. Hiển thị danh sách nhân viên có mức lương từ 10.000.000 đến 20.000.000
SELECT * FROM employees 
WHERE salary BETWEEN 10000000 AND 20000000;

-- 3. Hiển thị nhân viên thuộc phòng ban IT hoặc HR
SELECT * FROM employees 
WHERE department IN ('IT', 'HR');

-- 4. Hiển thị nhân viên có họ tên chứa chữ “Anh”
SELECT * FROM employees 
WHERE full_name LIKE '%Anh%';

-- 5. Hiển thị nhân viên chưa có số điện thoại
SELECT * FROM employees 
WHERE phone IS NULL;

-- 6. Cập nhật lương tăng thêm 10% cho nhân viên phòng IT
UPDATE employees 
SET salary = salary * 1.1 
WHERE department = 'IT';

-- 7. Cập nhật số điện thoại cho nhân viên chưa có số điện thoại
UPDATE employees 
SET phone = '0356550279' 
WHERE phone IS NULL;

-- 8. Xóa nhân viên có mức lương thấp hơn 5.000.000
DELETE FROM employees 
WHERE salary < 5000000;

-- Bật lại Safe Update Mode
SET SQL_SAFE_UPDATES = 1;

-- Kiểm tra lại bảng sau tất cả các thao tác
SELECT * FROM employees;