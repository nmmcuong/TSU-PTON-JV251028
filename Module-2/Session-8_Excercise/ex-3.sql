CREATE DATABASE IF NOT EXISTS company_salary_db;
USE company_salary_db;

CREATE TABLE employees (
    ma_nhan_vien VARCHAR(20) PRIMARY KEY, 
    ho_ten VARCHAR(255) NOT NULL,          
    luong DOUBLE                           
);

DELIMITER //

CREATE PROCEDURE sp_get_avg_salary()
BEGIN
    DECLARE v_avg_salary DOUBLE;

    SELECT AVG(luong) INTO v_avg_salary FROM employees;

    SELECT v_avg_salary AS average_salary;
END //

DELIMITER ;

CALL sp_get_avg_salary();