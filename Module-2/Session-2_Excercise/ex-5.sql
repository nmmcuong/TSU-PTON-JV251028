CREATE TABLE class(
    idClass VARCHAR(50) PRIMARY KEY,
    name TEXT NOT NULL,
    nienKhoa TEXT NOT NULL
);

CREATE TABLE students(
    idStudent INTEGER PRIMARY KEY,
    idClass VARCHAR(50), 
    StudentName VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL, 
    gender TEXT NOT NULL,
    CHECK(gender = 'MALE' OR gender = 'FEMALE'),
    FOREIGN KEY (idClass) REFERENCES class(idClass) 
);