package Ex4;
public class Main {
    public static void main(String[] args) {
        // 1. Khởi tạo hai tài khoản A và B
        BankAccount accountA = new BankAccount("A01", 5000.0, "Nguyễn Văn A", "0901234567");
        BankAccount accountB = new BankAccount("B01", 1000.0, "Trần Thị B", "0907654321");

        System.out.println("--- Số dư ban đầu ---");
        accountA.displayBalance();
        accountB.displayBalance();

        // 2. Thực hiện chuyển tiền từ A sang B (ví dụ: chuyển 2000)
        double transferAmount = 2000.0;
        System.out.println("\n--- Thực hiện chuyển " + transferAmount + " từ A sang B ---");

        if (accountA.getBalance() >= transferAmount) {
            accountA.withdraw(transferAmount); // Rút từ A
            accountB.deposit(transferAmount);  // Nạp vào B
            System.out.println("Chuyển khoản thành công!");
        } else {
            System.out.println("Chuyển khoản thất bại do tài khoản A không đủ tiền.");
        }

        // 3. In lại số dư sau khi chuyển
        System.out.println("\n--- Số dư sau khi giao dịch ---");
        accountA.displayBalance();
        accountB.displayBalance();
    }
}
