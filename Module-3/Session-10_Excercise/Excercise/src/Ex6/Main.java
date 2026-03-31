package Ex6;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static OrderManager manager = new OrderManager();

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n***************** MENU QUẢN LÝ ĐƠN HÀNG *****************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: handleAdd(); break;
                    case 2: handleUpdate(); break;
                    case 3: handleDelete(); break;
                    case 4: manager.display(); break;
                    case 5: System.out.println("Tạm biệt!"); break;
                    default: System.out.println("Vui lòng chọn 1-5!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            }
        } while (choice != 5);
    }

    private static String inputNotEmpty(String msg) {
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Vui lòng ko để trống !");
                continue;
            }
            return input;
        }
    }

    private static void handleAdd() {
        String ma = inputNotEmpty("Nhập mã đơn hàng:");
        String ten = inputNotEmpty("Nhập tên khách hàng:");
        manager.add(new Order(ma, ten));
    }

    private static void handleUpdate() {
        manager.display();
        String maCanSua = inputNotEmpty("Nhập mã đơn hàng cần sửa:");
        String maMoi = inputNotEmpty("Nhập mã đơn hàng mới:");
        String tenMoi = inputNotEmpty("Nhập tên khách hàng mới:");
        manager.update(maCanSua, new Order(maMoi, tenMoi));
    }

    private static void handleDelete() {
        manager.display();
        String maCanXoa = inputNotEmpty("Nhập mã đơn hàng cần xóa:");
        manager.delete(maCanXoa);
    }
}