CREATE TABLE students(
    id INTEGER PRIMARY KEY, 
    name VARCHAR(255) NOT NULL, 
    email VARCHAR(255) UNIQUE, 
    age INTEGER,
    CHECK(age > 18)
);