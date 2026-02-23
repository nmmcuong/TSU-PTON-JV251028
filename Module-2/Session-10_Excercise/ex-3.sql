DELIMITER //

CREATE TRIGGER BeforeInsertProduct
BEFORE INSERT ON products
FOR EACH ROW
BEGIN
    -- Kiểm tra nếu số lượng thêm mới nhỏ hơn 0
    IF NEW.quantity < 0 THEN
        -- Tạo lỗi và dừng thao tác chèn dữ liệu
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Lỗi: Số lượng sản phẩm không được nhỏ hơn 0!';
    END IF;
END //

DELIMITER ;