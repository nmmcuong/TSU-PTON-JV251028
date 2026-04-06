CREATE DATABASE IF NOT EXISTS movie_db;
USE movie_db;

CREATE TABLE movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255),
    release_year INT
);

-- 1. Procedure Thêm phim
DELIMITER //
CREATE PROCEDURE add_movie(IN p_title VARCHAR(255), IN p_director VARCHAR(255), IN p_year INT)
BEGIN
    INSERT INTO movies(title, director, release_year) VALUES (p_title, p_director, p_year);
END //

-- 2. Procedure Liệt kê phim
CREATE PROCEDURE list_movies()
BEGIN
    SELECT * FROM movies;
END //

-- 3. Procedure Sửa phim
CREATE PROCEDURE update_movie(IN p_id INT, IN p_title VARCHAR(255), IN p_director VARCHAR(255), IN p_year INT)
BEGIN
    UPDATE movies SET title = p_title, director = p_director, release_year = p_year WHERE id = p_id;
END //

-- 4. Procedure Xóa phim
CREATE PROCEDURE delete_movie(IN p_id INT)
BEGIN
    DELETE FROM movies WHERE id = p_id;
END //
DELIMITER ;
