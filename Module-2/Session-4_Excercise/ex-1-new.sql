CREATE DATABASE IF NOT EXISTS DBStudents ;
use DBStudents ;
CREATE TABLE students (
    student_id INT PRIMARY KEY,           
    full_name VARCHAR(255) NOT NULL,     
    birth_date DATE,                      
    gender VARCHAR(10),                  
    email VARCHAR(255)                   
);

INSERT INTO students (student_id, full_name, birth_date, gender, email)
VALUES 
(1, 'Nguyen Van A', '2005-01-15', 'Nam', 'anv@gmail.com'),
(2, 'Tran Thi B', '2005-05-20', 'Nu', 'btt@gmail.com'),
(3, 'Le Van C', '2004-11-02', 'Nam', NULL), -- Sinh viên không có email
(4, 'Pham Minh D', '2005-03-10', 'Nam', 'dpm@gmail.com'),
(5, 'Hoang Thu E', '2006-07-25', 'Nu', 'eht@gmail.com');

#Hiển thị toàn bộ danh sách sinh viên:
SELECT * FROM students;
#Chỉ hiển thị các cột: mã sinh viên, họ tên, email:
SELECT student_id, full_name, email FROM students;