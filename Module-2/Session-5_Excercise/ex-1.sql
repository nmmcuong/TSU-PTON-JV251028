CREATE DATABASE IF NOT EXISTS DBStudents_5_1 ;
use DBStudents_5_1 ;

CREATE TABLE IF NOT EXISTS students (
    student_id VARCHAR(10) PRIMARY KEY, 
    full_name VARCHAR(255),
    birth_year INT,
    gender VARCHAR(10),
    score DECIMAL(4, 2)                 
);

-- 1. THÊM DỮ LIỆU MẪU ĐỂ THỰC HÀNH
INSERT INTO students (student_id, full_name, birth_year, gender, score) VALUES 
('SV001', 'nguyen van an', 2003, 'Nam', 8.567),
('SV002', 'tran thi binh', 2004, 'Nu', 7.234),
('SV003', 'le van cuong', 2005, 'Nam', 9.111),
('SV004', 'pham minh duc', 2003, 'Nam', 6.456),
('SV005', 'hoang thu em', 2005, 'Nu', 8.999);

-- 2. Hiển thị: mã sinh viên, họ tên (viết hoa toàn bộ)
SELECT student_id, UPPER(full_name) AS full_name_uppercase 
FROM students;

-- 3. Hiển thị: họ tên, số tuổi của sinh viên (dựa vào năm hiện tại)
SELECT full_name, (2026 - birth_year) AS age 
FROM students;

-- 4. Hiển thị: điểm trung bình được làm tròn 1 chữ số thập phân
SELECT full_name, ROUND(score, 1) AS rounded_score 
FROM students;

-- 5. Hiển thị các giá trị thống kê: tổng số sinh viên, điểm cao nhất, điểm thấp nhất
SELECT 
    COUNT(student_id) AS total_students, 
    MAX(score) AS highest_score, 
    MIN(score) AS lowest_score 
FROM students;