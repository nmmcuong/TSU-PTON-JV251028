-- 1. Tạo bảng orders
CREATE TABLE IF NOT EXISTS orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    quantity INT NOT NULL CHECK (quantity > 0),
    total_amount DECIMAL(15, 2) NOT NULL CHECK (total_amount > 0),
    status ENUM('Pending', 'Success', 'Cancel') DEFAULT 'Pending',
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 2. Tạo View view_customer_spending
-- Kết hợp (JOIN) bảng customers và orders, tính tổng đơn hàng và tổng tiền
CREATE OR REPLACE VIEW view_customer_spending AS
SELECT 
    c.customer_id, 
    c.customer_name, 
    COUNT(o.order_id) AS total_orders, 
    SUM(o.total_amount) AS total_spent
FROM customers c
LEFT JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, c.customer_name;

-- 3. Kiểm tra kết quả
SELECT * FROM view_customer_spending;