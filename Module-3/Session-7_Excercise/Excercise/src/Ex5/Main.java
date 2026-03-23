package Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== QUẢN LÝ SẢN PHẨM =====");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");
            
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addProduct(); break;
                case 2: displayProducts(); break;
                case 3: updateProduct(); break;
                case 4: deleteProduct(); break;
                case 5: 
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // 1. Thêm sản phẩm
    private static void addProduct() {
        System.out.print("Nhập ID: "); String id = sc.nextLine();
        System.out.print("Nhập tên: "); String name = sc.nextLine();
        System.out.print("Nhập giá: "); double price = Double.parseDouble(sc.nextLine());
        list.add(new Product(id, name, price));
        System.out.println("Thêm thành công!");
    }

    // 2. Hiển thị danh sách
    private static void displayProducts() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            System.out.println("--- Danh sách sản phẩm ---");
            for (Product p : list) System.out.println(p);
        }
    }

    // 3. Cập nhật sản phẩm
    private static void updateProduct() {
        System.out.print("Nhập ID cần cập nhật: ");
        String id = sc.nextLine();
        for (Product p : list) {
            if (p.getId().equals(id)) {
                System.out.print("Tên mới: "); p.setName(sc.nextLine());
                System.out.print("Giá mới: "); p.setPrice(Double.parseDouble(sc.nextLine()));
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có ID: " + id);
    }

    // 4. Xóa sản phẩm
    private static void deleteProduct() {
        System.out.print("Nhập ID cần xóa: ");
        String id = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                System.out.println("Đã xóa sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }
}
