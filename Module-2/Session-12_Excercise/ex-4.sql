DELIMITER //
CREATE TRIGGER trg_before_insert_employee
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
    -- Nếu email không chứa chuỗi '@company.com'
    IF NEW.email NOT LIKE '%@company.com' THEN
        SET NEW.email = CONCAT(NEW.email, '@company.com');
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER trg_after_insert_employee
AFTER INSERT ON employees
FOR EACH ROW
BEGIN
    INSERT INTO salaries (employee_id, base_salary, bonus)
    VALUES (NEW.employee_id, 10000.00, 0);
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER trg_before_update_attendance
BEFORE UPDATE ON attendance
FOR EACH ROW
BEGIN
    -- Kiểm tra nếu thời gian check-out được cập nhật
    IF NEW.check_out_time IS NOT NULL THEN
        -- Tính toán số giờ làm việc (đơn vị: giờ)
        SET NEW.total_hours = TIMESTAMPDIFF(HOUR, NEW.check_in_time, NEW.check_out_time);
    END IF;
END //
DELIMITER ;

