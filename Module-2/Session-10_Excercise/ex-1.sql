-- 1. Tạo bảng Products
CREATE TABLE IF NOT EXISTS products (
    productID INT AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(100),
    quantity INT
);

-- 2. Tạo bảng InventoryChanges để ghi log
CREATE TABLE IF NOT EXISTS inventoryChanges (
    changeID INT AUTO_INCREMENT PRIMARY KEY,
    productID INT NOT NULL,
    oldQuantity INT,
    newQuantity INT,
    changeDate DATETIME,
    FOREIGN KEY (productID) REFERENCES products(productID)
);

-- 3. Tạo Trigger AfterProductUpdate
DELIMITER //

CREATE TRIGGER AfterProductUpdate
AFTER UPDATE ON products
FOR EACH ROW
BEGIN
    -- Chỉ ghi log nếu số lượng có thay đổi
    IF OLD.quantity <> NEW.quantity THEN
        INSERT INTO inventoryChanges (productID, oldQuantity, newQuantity, changeDate)
        VALUES (OLD.productID, OLD.quantity, NEW.quantity, NOW());
    END IF;
END //

DELIMITER ;