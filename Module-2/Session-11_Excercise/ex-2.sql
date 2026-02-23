DELIMITER //

CREATE PROCEDURE withdraw_money(
    IN p_account_id INT,
    IN p_amount DECIMAL(10, 2)
)
BEGIN
    DECLARE current_balance DECIMAL(10, 2);

    -- 1. Bắt đầu phiên giao dịch
    START TRANSACTION;

    -- 2. Trừ tiền trong tài khoản
    UPDATE accounts 
    SET balance = balance - p_amount 
    WHERE accountID = p_account_id;

    -- 3. Kiểm tra số dư hiện tại
    SELECT balance INTO current_balance 
    FROM accounts 
    WHERE accountID = p_account_id;

    -- 4. Điều kiện: Nếu số dư < 0 thì Rollback, ngược lại Commit
    IF current_balance < 0 THEN
        ROLLBACK;
        SELECT 'Giao dịch thất bại! Số dư không đủ.' AS message;
    ELSE
        COMMIT;
        SELECT 'Rút tiền thành công.' AS message;
    END IF;
END //

DELIMITER ;