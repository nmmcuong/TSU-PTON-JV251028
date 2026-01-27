use DBStudents ;
select * from students;
#Cập nhật email cho sinh viên chưa có email
UPDATE students 
SET email = 'lvc@gmail.com' 
WHERE student_id = 3;

#Cập nhật giới tính cho sinh viên có mã là SV005
UPDATE students 
SET gender = 'Nu' -- Hoặc 'Nam' tùy yêu cầu
WHERE student_id = 'SV005';

-- Kiểm tra lại dữ liệu
SELECT * FROM students WHERE student_id = 'SV005';

#Xóa sinh viên có mã là SV003
DELETE FROM students 
WHERE student_id = 'SV003';
select * from students;