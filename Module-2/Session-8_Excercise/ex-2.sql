CREATE DATABASE product_db;
USE product_db;

CREATE TABLE products (
    ma_san_pham VARCHAR(20) PRIMARY KEY, 
    ten_san_pham VARCHAR(255) NOT NULL,   
    gia_ban DOUBLE,                       
    loai_san_pham VARCHAR(100)     
    
DELIMITER //

CREATE PROCEDURE sp_get_products_by_category(IN p_loai_san_pham VARCHAR(100))
BEGIN
    SELECT ma_san_pham, ten_san_pham, gia_ban, loai_san_pham
    FROM products
    WHERE loai_san_pham = p_loai_san_pham;
END //

DELIMITER ;

CALL sp_get_products_by_category('Điện tử');