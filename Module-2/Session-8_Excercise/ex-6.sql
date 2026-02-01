CREATE DATABASE school_db;
USE school_db;

CREATE TABLE students (
    ma_sinh_vien VARCHAR(20) PRIMARY KEY, 
    ho_ten VARCHAR(255) NOT NULL,          
    diem_trung_binh DOUBLE                 
);

DELIMITER //

CREATE PROCEDURE sp_classify_student(
    IN p_diem_trung_binh DOUBLE,      
    OUT p_xep_loai VARCHAR(20)       
)
BEGIN
    DECLARE v_ket_qua VARCHAR(20);

    CASE 
        WHEN p_diem_trung_binh >= 8.0 THEN 
            SET v_ket_qua = 'Giỏi';
        WHEN p_diem_trung_binh >= 6.5 THEN 
            SET v_ket_qua = 'Khá';
        WHEN p_diem_trung_binh >= 5.0 THEN 
            SET v_ket_qua = 'Trung bình';
        ELSE 
            SET v_ket_qua = 'Yếu';
    END CASE;

    SET p_xep_loai = v_ket_qua;
END //

DELIMITER ;

CALL sp_classify_student(7.5, @ket_qua);
SELECT @ket_qua AS xep_loai_hoc_luc;