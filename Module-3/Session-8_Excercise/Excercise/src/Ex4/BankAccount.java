package Ex4;
public class BankAccount implements IBank {
    private String accountId;
    private double balance;
    private String userName;
    private String phoneNumber;

    // Constructor để khởi tạo tài khoản
    public BankAccount(String accountId, double balance, String userName, String phoneNumber) {
        this.accountId = accountId;
        this.balance = balance;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    // Ghi đè phương thức nạp tiền
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(userName + " đã nạp thành công: " + amount);
        }
    }

    // Ghi đè phương thức rút tiền
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println(userName + " đã rút thành công: " + amount);
        } else {
            System.out.println("Giao dịch thất bại: Số dư không đủ hoặc số tiền không hợp lệ.");
        }
    }

    // Hiển thị số dư
    public void displayBalance() {
        System.out.println("Tài khoản: " + userName + " | ID: " + accountId + " | Số dư: " + balance);
    }

    // Getter cho balance (dùng cho việc chuyển tiền)
    public double getBalance() {
        return balance;
    }
}
