create database session13 ;
use session13 ;
CREATE TABLE Students (
                          student_id INT AUTO_INCREMENT PRIMARY KEY,
                          full_name VARCHAR(100) NOT NULL,
                          date_of_birth DATE NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE
);

DELIMITER //

CREATE PROCEDURE get_all_students()
BEGIN
    SELECT * FROM Students;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE add_student(
    IN in_full_name VARCHAR(100),
    IN in_date_of_birth DATE,
    IN in_email VARCHAR(100)
)
BEGIN
    INSERT INTO Students (full_name, date_of_birth, email)
    VALUES (in_full_name, in_date_of_birth, in_email);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE update_student(
    IN in_id INT,
    IN in_full_name VARCHAR(100),
    IN in_date_of_birth DATE,
    IN in_email VARCHAR(100)
)
BEGIN
    UPDATE Students
    SET full_name = in_full_name,
        date_of_birth = in_date_of_birth,
        email = in_email
    WHERE student_id = in_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE find_student_by_id(
    IN in_id INT
)
BEGIN
    SELECT * FROM Students
    WHERE student_id = in_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE delete_student(
    IN in_id INT
)
BEGIN
    DELETE FROM Students
    WHERE student_id = in_id;
END //

DELIMITER ;

DELIMITER //
    create procedure search_student_by_name(search varchar(255))
    begin
        select * from students where full_name like concat('%',search,'%');
    end //
//
DELIMITER  ;