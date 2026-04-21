CREATE DATABASE CompanyDB;
USE CompanyDB;

CREATE TABLE Employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    department VARCHAR(255) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Project (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    budget DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Assignment (
    employee_id INT,
    project_id INT,
    role VARCHAR(255) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(id),
    FOREIGN KEY (project_id) REFERENCES Project(id),
    PRIMARY KEY (employee_id, project_id)
);
