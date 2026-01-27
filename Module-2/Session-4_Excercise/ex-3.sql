use DBStudents ;

#Hiển thị sinh viên có năm sinh từ 2003 đến 2005
SELECT * FROM students 
WHERE YEAR(birth_date) BETWEEN 2003 AND 2005;

#Hiển thị sinh viên có giới tính là Nam hoặc Nữ
SELECT * FROM students 
WHERE gender IN ('Nam', 'Nu');

#Hiển thị sinh viên có mã thuộc danh sách: SV001, SV004, SV005
SELECT * FROM students 
WHERE student_id IN ('SV001', 'SV004', 'SV005');

#Chỉ hiển thị: mã sinh viên, họ tên, ngày sinh
SELECT student_id, full_name, birth_date 
FROM students;