DELIMITER //
CREATE TRIGGER trg_check_stock_insert
BEFORE INSERT ON order_items
FOR EACH ROW
BEGIN
    DECLARE v_stock INT;
    SELECT stock_quantity INTO v_stock FROM inventory WHERE product_id = NEW.product_id;
    
    IF v_stock < NEW.quantity THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không đủ số lượng hàng trong kho!';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER trg_update_order_total
AFTER INSERT ON order_items
FOR EACH ROW
BEGIN
    UPDATE orders 
    SET total_amount = (SELECT SUM(quantity * price) FROM order_items WHERE order_id = NEW.order_id)
    WHERE order_id = NEW.order_id;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER trg_prevent_delete_completed
BEFORE DELETE ON orders
FOR EACH ROW
BEGIN
    IF OLD.status = 'Completed' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không thể xóa đơn hàng đã hoàn tất!';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER trg_restock_after_delete
AFTER DELETE ON order_items
FOR EACH ROW
BEGIN
    UPDATE inventory 
    SET stock_quantity = stock_quantity + OLD.quantity 
    WHERE product_id = OLD.product_id;
END //
DELIMITER ;
