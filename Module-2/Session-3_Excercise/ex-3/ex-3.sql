CREATE DATABASE IF NOT EXISTS Orders ;
USE Orders;

-- 1. Tạo bảng Sản phẩm
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
) ;

-- 2. Tạo bảng Đơn hàng
CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    customer_name VARCHAR(100)
);

-- 3. Tạo bảng trung gian: Chi tiết đơn hàng
CREATE TABLE order_items (
    order_id INT,
    product_id INT,
    quantity INT NOT NULL DEFAULT 1,
    PRIMARY KEY (order_id, product_id),

    CONSTRAINT FK_Order_Item FOREIGN KEY (order_id) 
        REFERENCES orders(order_id) ON DELETE CASCADE,
        
    CONSTRAINT FK_Product_Item FOREIGN KEY (product_id) 
        REFERENCES products(product_id) ON DELETE CASCADE
);