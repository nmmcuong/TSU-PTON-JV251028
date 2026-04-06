package Ex3;

import java.util.Scanner;

public class Order {
    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private float orderAmount;
    private String status; // Pending, Shipped, Delivered

    public Order() {
        this.status = "Pending"; // Mặc định là Pending
    }

    public Order(int orderId, String customerName, String phoneNumber, String address, float orderAmount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }

    // Getter và Setter
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public String getCustomerName() { return customerName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public float getOrderAmount() { return orderAmount; }

    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên khách hàng (6-100 ký tự): ");
            this.customerName = scanner.nextLine();
            if (this.customerName.length() >= 6 && this.customerName.length() <= 100) break;
            System.err.println("Tên không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập số điện thoại VN: ");
            this.phoneNumber = scanner.nextLine();
            if (this.phoneNumber.matches("^(03|05|07|08|09)\\d{8}$")) break;
            System.err.println("SĐT không đúng định dạng!");
        }

        while (true) {
            System.out.print("Nhập địa chỉ giao hàng: ");
            this.address = scanner.nextLine();
            if (!this.address.isEmpty()) break;
            System.err.println("Địa chỉ không được để trống!");
        }

        while (true) {
            System.out.print("Nhập giá trị đơn hàng (>0): ");
            try {
                this.orderAmount = Float.parseFloat(scanner.nextLine());
                if (this.orderAmount > 0) break;
            } catch (Exception e) {}
            System.err.println("Giá trị phải là số thực lớn hơn 0!");
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Khách: %-15s | SĐT: %s | Giá trị: %.2f | Trạng thái: %s",
                orderId, customerName, phoneNumber, orderAmount, status);
    }
}
