-- 1. Tạo bảng orders
CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    total_amount DECIMAL(10, 2),
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50)
);

-- 2. Tạo bảng nhật ký order_logs
CREATE TABLE IF NOT EXISTS order_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    old_status VARCHAR(50),
    new_status VARCHAR(50),
    log_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

-- 3. Tạo Trigger after_order_status_update
DELIMITER //

CREATE TRIGGER after_order_status_update
AFTER UPDATE ON orders
FOR EACH ROW
BEGIN
    -- Chỉ ghi log nếu trạng thái (status) có sự thay đổi
    IF OLD.status <> NEW.status THEN
        INSERT INTO order_logs (order_id, old_status, new_status)
        VALUES (OLD.id, OLD.status, NEW.status);
    END IF;
END //

DELIMITER ;