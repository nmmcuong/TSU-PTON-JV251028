package Ex10;
public class Main {
    public static void main(String[] args) {
        double orderAmount = 1000.0;

        // Tạo danh sách các phương thức thanh toán
        PaymentMethod credit = new CreditCard(orderAmount);
        PaymentMethod debit = new DebitCard(orderAmount);
        PaymentMethod cash = new Cash(orderAmount);

        System.out.println("===== HỆ THỐNG THANH TOÁN =====");
        System.out.println("Số tiền gốc: " + orderAmount);
        System.out.println("-------------------------------");

        // Hiển thị kết quả thanh toán cho từng loại
        printTransaction("Thẻ tín dụng (Credit Card)", credit);
        printTransaction("Thẻ ghi nợ (Debit Card)", debit);
        printTransaction("Tiền mặt (Cash)", cash);
    }

    public static void printTransaction(String type, PaymentMethod method) {
        System.out.println("[" + type + "]");
        System.out.println("- Phí giao dịch: " + method.calculateFee());
        System.out.println("- Tổng thanh toán: " + method.processPayment("USD"));
        System.out.println();
    }
}
