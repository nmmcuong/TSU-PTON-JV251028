-- Tạo view chỉ hiển thị các thông tin liên hệ cần thiết
CREATE OR REPLACE VIEW view_customer_contact AS
SELECT customer_id, customer_name, email, phone
FROM customers;

-- Kiểm tra kết quả
SELECT * FROM view_customer_contact;
DELIMITER //

CREATE PROCEDURE insert_customer(
    IN in_customer_name VARCHAR(50),
    IN in_email VARCHAR(100),
    IN in_phone VARCHAR(15),
    IN in_address VARCHAR(255)
)
BEGIN
    -- Thực hiện thêm dữ liệu
    INSERT INTO customers (customer_name, email, phone, address)
    VALUES (in_customer_name, in_email, in_phone, in_address);
    
    -- Hiển thị thông báo thành công
    SELECT 'Thêm mới khách hàng thành công !' AS message;
END //

DELIMITER ;

-- Gọi procedure để test
CALL insert_customer('Nguyễn Công Hưởng', 'huongcaoha@gmail.com', '0988888888', 'Hà Nội');