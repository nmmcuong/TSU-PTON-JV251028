CREATE DATABASE IF NOT EXISTS employee_management;
USE employee_management;

CREATE TABLE employees (
    ma_nhan_vien VARCHAR(20) PRIMARY KEY, 
    ho_ten VARCHAR(255) NOT NULL,          
    luong DOUBLE,                          
    phong_ban VARCHAR(100)                 
);

DELIMITER //

CREATE PROCEDURE sp_check_employee_income(
    IN p_ten_nhan_vien VARCHAR(255), 
    IN p_muc_luong DOUBLE
)
BEGIN
    DECLARE v_thu_nhap_mo_ta VARCHAR(50);

    IF p_muc_luong >= 15000000 THEN
        SET v_thu_nhap_mo_ta = 'Thu nhập cao';
    ELSEIF p_muc_luong >= 8000000 THEN
        SET v_thu_nhap_mo_ta = 'Thu nhập trung bình';
    ELSE
        SET v_thu_nhap_mo_ta = 'Thu nhập thấp';
    END IF;

    SELECT p_ten_nhan_vien AS ten_nhan_vien, v_thu_nhap_mo_ta AS muc_thu_nhap;
END //

DELIMITER ;

CALL sp_check_employee_income('Nguyen Van A', 16000000);

CALL sp_check_employee_income('Tran Thi B', 10000000);

CALL sp_check_employee_income('Le Van C', 5000000);