CREATE DATABASE IF NOT EXISTS Course;
USE Course;

-- 1. Tạo bảng Giáo viên
CREATE TABLE teachers (
    idTeacher INT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL UNIQUE
);

-- 2. Tạo bảng Học viên
CREATE TABLE students (
    idstudents INT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL UNIQUE
);

-- 3. Tạo bảng Khóa học
CREATE TABLE courses (
    idcourses INT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    description VARCHAR(45),
    price FLOAT NOT NULL,
    teachers_idTeacher INT NOT NULL,
    
    CONSTRAINT FK_Teacher_Course FOREIGN KEY (teachers_idTeacher) 
        REFERENCES teachers(idTeacher)
);

-- 4. Tạo bảng Đăng ký (Enrollments)
CREATE TABLE enrollments (
	idEnroll int primary key
);