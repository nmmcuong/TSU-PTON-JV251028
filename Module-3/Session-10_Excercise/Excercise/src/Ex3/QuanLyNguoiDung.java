package Ex3;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNguoiDung {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<User> listUsers = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n***************** MENU QUẢN LÝ NGƯỜI DÙNG *****************");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn:");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: addUser(); break;
                    case 2: deleteUser(); break;
                    case 3: showUsers(); break;
                    case 4: System.out.println("Tạm biệt!"); break;
                    default: System.out.println("Vui lòng chọn từ 1-4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            }
        } while (choice != 4);
    }

    // Hàm dùng chung để kiểm tra nhập trống
    private static String inputNotEmpty(String message) {
        while (true) {
            System.out.println(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Vui lòng ko để trống !");
                continue;
            }
            return input;
        }
    }

    private static void addUser() {
        String name = inputNotEmpty("Nhập tên người dùng:");
        String email = inputNotEmpty("Nhập email người dùng:");
        String phone = inputNotEmpty("Nhập số điện thoại người dùng:");

        listUsers.add(new User(name, email, phone));
        System.out.println("Người dùng đã được thêm thành công.");
    }

    private static void deleteUser() {
        System.out.println("Nhập email người dùng để xóa:");
        String email = sc.nextLine().trim();
        boolean removed = false;

        // Sử dụng removeIf để xóa nhanh theo điều kiện
        removed = listUsers.removeIf(user -> user.getEmail().equalsIgnoreCase(email));

        if (removed) {
            System.out.println("Người dùng đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy người dùng có email này!");
        }
    }

    private static void showUsers() {
        if (listUsers.isEmpty()) {
            System.out.println("Danh sách người dùng trống!");
        } else {
            System.out.println("\nDanh sách người dùng:");
            for (User u : listUsers) {
                System.out.println(u);
            }
        }
    }
}