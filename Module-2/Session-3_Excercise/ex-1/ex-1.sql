#1
CREATE DATABASE IF NOT EXISTS QLKhoaHoc ;
CREATE TABLE class(
    idClass TEXT PRIMARY KEY,
    ClassName TEXT NOT NULL,
    nienKhoa TEXT NOT NULL
);
--
CREATE TABLE students(
    idStudent INTEGER PRIMARY KEY,
    StudentName TEXT NOT NULL,
    birthday Time NOT NULL,
    gender TEXT NOT NULL,
    CHECK(gender = 'MALE' OR gender = 'FEMALE'),
	CONSTRAINT FK_LopHoc FOREIGN KEY (idClass) 
    REFERENCES class(idClass)
)

