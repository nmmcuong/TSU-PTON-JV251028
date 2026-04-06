CREATE DATABASE IF NOT EXISTS todo_db;
USE todo_db;

CREATE TABLE IF NOT EXISTS tasks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    task_name VARCHAR(255) NOT NULL,
    status VARCHAR(50) DEFAULT 'chưa hoàn thành'
);

DELIMITER //

-- 1. Thêm công việc
CREATE PROCEDURE add_task(IN p_name VARCHAR(255), IN p_status VARCHAR(50))
BEGIN
    INSERT INTO tasks(task_name, status) VALUES (p_name, p_status);
END //

-- 2. Liệt kê công việc
CREATE PROCEDURE list_tasks()
BEGIN
    SELECT * FROM tasks;
END //

-- 3. Cập nhật trạng thái
CREATE PROCEDURE update_task_status(IN p_id INT, IN p_status VARCHAR(50))
BEGIN
    UPDATE tasks SET status = p_status WHERE id = p_id;
END //

-- 4. Xóa công việc
CREATE PROCEDURE delete_task(IN p_id INT)
BEGIN
    DELETE FROM tasks WHERE id = p_id;
END //

-- 5. Tìm kiếm theo tên
CREATE PROCEDURE search_task_by_name(IN p_name VARCHAR(255))
BEGIN
    SELECT * FROM tasks WHERE task_name LIKE CONCAT('%', p_name, '%');
END //

-- 6. Thống kê
CREATE PROCEDURE task_statistics()
BEGIN
    SELECT status, COUNT(*) as total FROM tasks GROUP BY status;
END //

DELIMITER ;
