-- Tạo Database và Bảng
CREATE DATABASE IF NOT EXISTS InventoryManagement;
USE InventoryManagement;

CREATE TABLE products (
    productID INT AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(100),
    quantity INT
);

CREATE TABLE inventoryChanges (
    changeID INT AUTO_INCREMENT PRIMARY KEY,
    productID INT NOT NULL,
    oldQuantity INT,
    newQuantity INT,
    changeDate DATETIME,
    FOREIGN KEY (productID) REFERENCES products(productID)
);

-- Tạo Trigger ghi log thay đổi
DELIMITER //
CREATE TRIGGER AfterProductUpdate
AFTER UPDATE ON products
FOR EACH ROW
BEGIN
    IF OLD.quantity <> NEW.quantity THEN
        INSERT INTO inventoryChanges (productID, oldQuantity, newQuantity, changeDate)
        VALUES (OLD.productID, OLD.quantity, NEW.quantity, NOW());
    END IF;
END //
DELIMITER ;