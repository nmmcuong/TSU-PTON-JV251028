-- 1. Tạo bảng accounts
CREATE TABLE IF NOT EXISTS accounts (
    accountID INT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(10, 2)
);

-- Thêm 10 tài khoản mẫu
INSERT INTO accounts (balance) VALUES 
(500000), (1000000), (200000), (3000000), (1500000),
(100000), (400000), (2500000), (600000), (700000);

-- 2. Thực hiện giao dịch (Transaction)

-- Kiểm tra số dư trước khi giao dịch
SELECT * FROM accounts WHERE accountID = 1;

-- Bắt đầu transaction
START TRANSACTION;

-- Cộng thêm 1.000.000 VNĐ vào tài khoản có accountID = 1
UPDATE accounts 
SET balance = balance + 1000000 
WHERE accountID = 1;

-- Lưu thay đổi bằng COMMIT
COMMIT;

-- 3. Kiểm tra số dư sau khi giao dịch
SELECT * FROM accounts WHERE accountID = 1;