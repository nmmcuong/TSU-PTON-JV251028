-- 1. Tạo View theo yêu cầu của bộ phận Marketing
-- View này chỉ bao gồm: id, tên, email và số điện thoại
CREATE OR REPLACE VIEW view_customer_contact AS
SELECT 
    customer_id, 
    customer_name, 
    email, 
    phone
FROM customers;

-- 2. Xem kết quả từ View vừa tạo
SELECT * FROM view_customer_contact;