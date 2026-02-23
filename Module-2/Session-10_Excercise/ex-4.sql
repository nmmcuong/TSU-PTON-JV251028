-- 1. Tạo bảng employees
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    salary DECIMAL(10, 2),
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15)
);

-- 2. Tạo bảng salary_log để lưu lịch sử
CREATE TABLE IF NOT EXISTS salary_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    old_salary DECIMAL(10, 2),
    new_salary DECIMAL(10, 2),
    change_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);

-- 3. Tạo Trigger trg_after_update_salary
DELIMITER //

CREATE TRIGGER trg_after_update_salary
AFTER UPDATE ON employees
FOR EACH ROW
BEGIN
    -- Chỉ ghi log nếu mức lương thực sự thay đổi
    IF OLD.salary <> NEW.salary THEN
        INSERT INTO salary_log (employee_id, old_salary, new_salary, change_date)
        VALUES (OLD.id, OLD.salary, NEW.salary, NOW());
    END IF;
END //

DELIMITER ;