CREATE DATABASE order_valuation_db;
USE order_valuation_db;

CREATE TABLE orders (
    ma_don_hang VARCHAR(20) PRIMARY KEY, 
    tong_tien DOUBLE                       
);

DELIMITER //

CREATE PROCEDURE sp_check_order_value(IN p_tong_tien DOUBLE)
BEGIN
    IF p_tong_tien >= 5000000 THEN
        SELECT 'Đơn hàng giá trị cao' AS thong_bao;
    ELSE
        SELECT 'Đơn hàng bình thường' AS thong_bao;
    END IF;
END //

DELIMITER ;

CALL sp_check_order_value(6000000);

CALL sp_check_order_value(2000000);