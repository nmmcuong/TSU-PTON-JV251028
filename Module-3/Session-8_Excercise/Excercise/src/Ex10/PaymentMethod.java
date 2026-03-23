package Ex10;
abstract class PaymentMethod {
    protected double amount; // Số tiền cần thanh toán chưa tính phí

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    // Các phương thức trừu tượng
    public abstract double calculateFee();
    public abstract double processPayment();
    
    // Phương thức nạp chồng (Overloaded method) - trả về chuỗi kèm đơn vị tiền tệ
    public abstract String processPayment(String currency);
}
