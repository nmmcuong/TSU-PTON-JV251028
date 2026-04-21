package Ex8;

import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Scanner sc = new Scanner(System.in);
        
        // Thêm vài khách hàng mẫu để test
        manager.addSampleCustomer(new Customer(1, "Nguyen Van A", "a@gmail.com"));

        while (true) {
            System.out.println("\n--- QUẢN LÝ ĐƠN HÀNG ---");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Cập nhật khách hàng");
            System.out.println("3. Tạo đơn hàng mới");
            System.out.println("4. Hiển thị tất cả đơn hàng");
            System.out.println("5. Tìm đơn hàng theo khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Xóa bộ nhớ đệm

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID SP: "); int pid = sc.nextInt(); sc.nextLine();
                    System.out.print("Nhập tên SP: "); String pname = sc.nextLine();
                    System.out.print("Nhập giá SP: "); double price = sc.nextDouble();
                    manager.addProduct(new Product(pid, pname, price));
                    break;
                case 2:
                    System.out.print("Nhập ID khách hàng cần sửa: "); int cid = sc.nextInt(); sc.nextLine();
                    System.out.print("Tên mới: "); String nName = sc.nextLine();
                    System.out.print("Email mới: "); String nEmail = sc.nextLine();
                    manager.updateCustomer(cid, nName, nEmail);
                    break;
                case 3:
                    System.out.print("Nhập ID đơn hàng: "); int oid = sc.nextInt();
                    System.out.print("Nhập ID khách hàng: "); int ocid = sc.nextInt();
                    System.out.print("Tổng tiền: "); double total = sc.nextDouble();
                    manager.createOrder(new Order(oid, ocid, new Date()), total);
                    break;
                case 4:
                    manager.lastOrders();
                    break;
                case 5:
                    System.out.print("Nhập ID khách hàng: "); int searchCid = sc.nextInt();
                    manager.getOrderByCustomer(searchCid);
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
