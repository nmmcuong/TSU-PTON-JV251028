CREATE DATABASE IF NOT EXISTS student_management;
USE student_management;

CREATE TABLE students (
    ma_sinh_vien VARCHAR(20) PRIMARY KEY, 
    ho_ten VARCHAR(255) NOT NULL,          
    lop_hoc VARCHAR(100)                   
);

DELIMITER //

CREATE PROCEDURE sp_get_all_students()
BEGIN
    SELECT ma_sinh_vien, ho_ten, lop_hoc 
    FROM students;
END //

DELIMITER ;

CALL sp_get_all_students();