-- 1. Chuẩn bị bảng transactions
CREATE TABLE IF NOT EXISTS transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    amount DECIMAL(15, 2),
    log_message VARCHAR(255),
    transaction_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);

-- 2. Viết Stored Procedure deposit_with_logging
DELIMITER //

CREATE PROCEDURE deposit_with_logging(
    IN p_account_id INT,
    IN p_amount DECIMAL(15, 2)
)
BEGIN
    -- Biến xử lý lỗi
    DECLARE exit handler FOR SQLEXCEPTION
    BEGIN
        -- Nếu có bất kỳ lỗi nào, tự động hoàn tác (Rollback)
        ROLLBACK;
        SELECT 'Giao dịch thất bại, đã rollback!' AS message;
    END;

    -- Bắt đầu Transaction
    START TRANSACTION;

    -- Bước 1: Cập nhật số dư vào bảng accounts
    UPDATE accounts 
    SET balance = balance + p_amount 
    WHERE account_id = p_account_id;

    -- Bước 2: Thêm dòng ghi nhật ký vào bảng transactions
    INSERT INTO transactions (account_id, amount, log_message)
    VALUES (p_account_id, p_amount, 'Nạp tiền vào tài khoản');

    -- Nếu mọi thứ suôn sẻ, lưu thay đổi
    COMMIT;
    SELECT 'Nạp tiền thành công!' AS message;
END //

DELIMITER ;