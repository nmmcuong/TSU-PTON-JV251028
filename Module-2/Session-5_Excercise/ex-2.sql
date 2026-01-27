
CREATE DATABASE IF NOT EXISTS EmployeeManagement;
USE EmployeeManagement;


CREATE TABLE IF NOT EXISTS employees (
    emp_id INT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    department VARCHAR(100),
    salary DECIMAL(15, 2)
);

-- 2. THÊM DỮ LIỆU MẪU (Để phục vụ việc thống kê)
INSERT INTO employees (emp_id, full_name, department, salary) VALUES 
(1, 'Nguyen Van A', 'IT', 15000000),
(2, 'Tran Thi B', 'IT', 16000000),
(3, 'Le Van C', 'IT', 14500000),
(4, 'Pham Minh D', 'IT', 17000000),   
(5, 'Hoang Thu E', 'HR', 12000000),
(6, 'Do Thuy Chi', 'HR', 11000000),
(7, 'Vu Minh Anh', 'HR', 13000000),   
(8, 'Bui Quang Huy', 'Sales', 9000000),
(9, 'Ngo Tuong Vi', 'Sales', 8500000), 
(10, 'Dang Hoang Anh', 'Accountant', 20000000);

-- Thống kê: mỗi phòng ban có bao nhiêu nhân viên
SELECT department, COUNT(emp_id) AS total_employees 
FROM employees 
GROUP BY department;

-- Tính: mức lương trung bình của từng phòng ban
SELECT department, AVG(salary) AS average_salary 
FROM employees 
GROUP BY department;

-- Chỉ hiển thị: các phòng ban có trên 3 nhân viên
SELECT department, COUNT(emp_id) AS total_employees 
FROM employees 
GROUP BY department 
HAVING COUNT(emp_id) > 3;

-- Chỉ hiển thị: các phòng ban có lương trung bình lớn hơn 12.000.000
SELECT department, AVG(salary) AS average_salary 
FROM employees 
GROUP BY department 
HAVING AVG(salary) > 12000000;