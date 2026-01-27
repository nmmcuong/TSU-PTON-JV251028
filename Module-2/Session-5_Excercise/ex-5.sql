
CREATE DATABASE IF NOT EXISTS TrainingManagement;
USE TrainingManagement;

-- 1. TẠO BẢNG SCORES 
CREATE TABLE IF NOT EXISTS scores (
    student_id VARCHAR(10),
    subject VARCHAR(100),
    score DECIMAL(4, 2)
);

-- 2. THÊM DỮ LIỆU MẪU (Mỗi sinh viên học nhiều môn)
INSERT INTO scores (student_id, subject, score) VALUES 
('SV001', 'Toan cao cap', 8.5),
('SV001', 'Lap trinh C', 9.0),
('SV002', 'Toan cao cap', 6.0),
('SV002', 'Lap trinh C', 7.5),
('SV003', 'Toan cao cap', 9.5),
('SV003', 'Lap trinh C', 10.0),
('SV004', 'Toan cao cap', 5.0),
('SV004', 'Lap trinh C', 6.0);

-- 3. Tính điểm trung bình của mỗi sinh viên
SELECT student_id, AVG(score) AS average_score
FROM scores
GROUP BY student_id;

-- 4. Chỉ hiển thị các sinh viên có điểm trung bình >= 7.0
SELECT student_id, AVG(score) AS average_score
FROM scores
GROUP BY student_id
HAVING average_score >= 7.0;

-- 5. Hiển thị sinh viên có điểm trung bình cao nhất trong toàn bộ danh sách
SELECT student_id, AVG(score) AS average_score
FROM scores
GROUP BY student_id
ORDER BY average_score DESC
LIMIT 1;

-- 6. Hiển thị các sinh viên có điểm trung bình cao hơn điểm trung bình chung của tất cả sinh viên
SELECT student_id, AVG(score) AS average_score
FROM scores
GROUP BY student_id
HAVING average_score > (SELECT AVG(score) FROM scores);