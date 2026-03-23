package Ex6;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Category> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== QUẢN LÝ DANH MỤC =====");
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng (1-6): ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addCategory(); break;
                case 2: displayCategories(); break;
                case 3: updateCategory(); break;
                case 4: deleteCategory(); break;
                case 5: searchByName(); break;
                case 6: 
                    System.out.println("Đang thoát chương trình...");
                    return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // 1. Thêm mới
    private static void addCategory() {
        System.out.print("Nhập ID danh mục: "); String id = sc.nextLine();
        System.out.print("Nhập tên danh mục: "); String name = sc.nextLine();
        System.out.print("Nhập mô tả: "); String desc = sc.nextLine();
        list.add(new Category(id, name, desc));
        System.out.println("Thêm thành công!");
    }

    // 2. Hiển thị
    private static void displayCategories() {
        if (list.isEmpty()) {
            System.out.println("Danh sách danh mục đang trống.");
        } else {
            for (Category c : list) System.out.println(c);
        }
    }

    // 3. Cập nhật
    private static void updateCategory() {
        System.out.print("Nhập ID danh mục cần cập nhật: ");
        String id = sc.nextLine();
        for (Category c : list) {
            if (c.getId().equals(id)) {
                System.out.print("Tên mới: "); c.setName(sc.nextLine());
                System.out.print("Mô tả mới: "); c.setDescription(sc.nextLine());
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy ID này.");
    }

    // 4. Xóa
    private static void deleteCategory() {
        System.out.print("Nhập ID danh mục cần xóa: ");
        String id = sc.nextLine();
        list.removeIf(c -> c.getId().equals(id));
        System.out.println("Đã thực hiện lệnh xóa.");
    }

    // 5. Tìm kiếm theo tên
    private static void searchByName() {
        System.out.print("Nhập tên danh mục cần tìm: ");
        String searchName = sc.nextLine();
        boolean found = false;
        System.out.println("--- Kết quả tìm kiếm ---");
        for (Category c : list) {
            // Tìm kiếm không phân biệt hoa thường và chứa từ khóa
            if (c.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy danh mục nào khớp với tên vừa nhập.");
    }
}

