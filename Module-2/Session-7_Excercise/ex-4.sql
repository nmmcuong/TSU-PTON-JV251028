CREATE DATABASE product_management;
USE product_management;

-- Tạo bảng sản phẩm (products)
CREATE TABLE products (
    ma_san_pham VARCHAR(20) PRIMARY KEY, 
    ten_san_pham VARCHAR(255) NOT NULL,   
    loai_san_pham VARCHAR(100),           
    gia_ban DOUBLE                       
);

-- Tạo INDEX kết hợp cho hai cột loai_san_pham và gia_ban
CREATE INDEX composite_idx_category_price 
ON products(loai_san_pham, gia_ban);