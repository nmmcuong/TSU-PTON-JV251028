-- 1. Chuẩn bị bảng accounts và dữ liệu mẫu
CREATE TABLE IF NOT EXISTS accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    balance DECIMAL(15, 2)
);

-- Thêm dữ liệu mẫu theo yêu cầu
INSERT INTO accounts (customer_name, balance) VALUES 
('Nguyễn Văn Tam', 2000000), 
('Nguyễn Văn Tứ', 0);

-- 2. Tạo Stored Procedure transfer_money
DELIMITER //

CREATE PROCEDURE transfer_money(
    IN p_sender_id INT,
    IN p_receiver_id INT,
    IN p_amount DECIMAL(15, 2)
)
BEGIN
    DECLARE sender_balance DECIMAL(15, 2);

    -- Xử lý lỗi: Nếu có bất kỳ lỗi nào, tự động Rollback
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Giao dịch thất bại, đã rollback!' AS message;
    END;

    -- Bắt đầu Transaction
    START TRANSACTION;

    -- Kiểm tra số dư người gửi
    SELECT balance INTO sender_balance FROM accounts WHERE account_id = p_sender_id;

    IF sender_balance >= p_amount THEN
        -- Trừ tiền người gửi
        UPDATE accounts SET balance = balance - p_amount WHERE account_id = p_sender_id;
        
        -- Cộng tiền người nhận
        UPDATE accounts SET balance = balance + p_amount WHERE account_id = p_receiver_id;
        
        -- Lưu thay đổi
        COMMIT;
        SELECT 'Chuyển tiền thành công!' AS message;
    ELSE
        -- Nếu không đủ tiền, hủy giao dịch
        ROLLBACK;
        SELECT 'Không đủ số dư để chuyển!' AS message;
    END IF;
END //

DELIMITER ;