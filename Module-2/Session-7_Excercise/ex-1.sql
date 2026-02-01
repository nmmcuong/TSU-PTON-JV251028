
CREATE DATABASE school_db;
USE school_db;

-- 2. Tạo bảng students
CREATE TABLE students (
    ma_sinh_vien VARCHAR(20) PRIMARY KEY, 
    ho_ten VARCHAR(255) NOT NULL,         
    nam_sinh INT,                          
    lop_hoc VARCHAR(50),                   
    dia_chi VARCHAR(255)                   
);

-- 3. Tạo VIEW v_student_basic theo yêu cầu
-- Chỉ hiển thị mã sinh viên, họ tên và lớp học
CREATE VIEW v_student_basic AS
SELECT 
    ma_sinh_vien, 
    ho_ten, 
    lop_hoc
FROM 
    students;

INSERT INTO students (ma_sinh_vien, ho_ten, nam_sinh, lop_hoc, dia_chi)
VALUES 
('SV001', 'Nguyen Van Anh', 2003, 'K65-CNTT', 'Ha Noi'),
('SV002', 'Tran Thi Binh', 2004, 'K66-Ketoan', 'Da Nang');