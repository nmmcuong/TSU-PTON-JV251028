DELIMITER //

CREATE PROCEDURE IncreaseSalary(
    IN p_emp_id INT,
    IN p_new_salary DECIMAL(10, 2),
    IN p_reason TEXT
)
BEGIN
    DECLARE v_old_salary DECIMAL(10, 2);
    DECLARE v_exists INT;

    -- Bắt đầu Transaction
    START TRANSACTION;

    -- Kiểm tra sự tồn tại của nhân viên
    SELECT COUNT(*) INTO v_exists FROM employees WHERE employee_id = p_emp_id;

    IF v_exists > 0 THEN
        -- Lấy lương cũ
        SELECT base_salary INTO v_old_salary FROM salaries WHERE employee_id = p_emp_id;

        -- 1. Cập nhật lương mới
        UPDATE salaries SET base_salary = p_new_salary, last_updated = NOW() 
        WHERE employee_id = p_emp_id;

        -- 2. Lưu vào lịch sử lương
        INSERT INTO salary_history (employee_id, old_salary, new_salary, change_date, reason)
        VALUES (p_emp_id, v_old_salary, p_new_salary, NOW(), p_reason);

        COMMIT;
        SELECT 'Tăng lương thành công và đã lưu lịch sử.' AS message;
    ELSE
        ROLLBACK;
        SELECT 'Lỗi: Nhân viên không tồn tại!' AS message;
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE DeleteEmployee(IN p_emp_id INT)
BEGIN
    DECLARE v_exists INT;

    -- Bắt đầu Transaction
    START TRANSACTION;

    -- Kiểm tra sự tồn tại
    SELECT COUNT(*) INTO v_exists FROM employees WHERE employee_id = p_emp_id;

    IF v_exists > 0 THEN
        -- Xóa dữ liệu lương trước để tránh lỗi khóa ngoại
        DELETE FROM salaries WHERE employee_id = p_emp_id;
        
        -- Xóa nhân viên
        DELETE FROM employees WHERE employee_id = p_emp_id;

        COMMIT;
        SELECT 'Đã xóa nhân viên thành công.' AS message;
    ELSE
        ROLLBACK;
        SELECT 'Lỗi: Không tìm thấy nhân viên!' AS message;
    END IF;
END //

DELIMITER ;