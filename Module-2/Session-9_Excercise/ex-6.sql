DELIMITER //

CREATE PROCEDURE add_order(
    IN _customer_id INT,
    IN _product_id INT,
    IN _quantity INT,
    OUT _message VARCHAR(255)
)
BEGIN
    DECLARE current_stock INT;
    
    -- 1. Lấy số lượng tồn kho hiện tại
    SELECT stock INTO current_stock FROM products WHERE product_id = _product_id;
    
    -- 2. Kiểm tra nếu không đủ hàng
    IF current_stock < _quantity THEN
        SET _message = 'Không đủ số lượng sản phẩm để đặt hàng.';
    ELSE
        -- 3. Nếu đủ, tiến hành đặt hàng và cập nhật tồn kho
        INSERT INTO orders (customer_id, product_id, quantity, total_amount, status)
        VALUES (_customer_id, _product_id, _quantity, (SELECT price * _quantity FROM products WHERE product_id = _product_id), 'Pending');
        
        UPDATE products 
        SET stock = stock - _quantity 
        WHERE product_id = _product_id;
        
        SET _message = 'Thêm đơn hàng thành công!';
    END IF;
END //

DELIMITER ;