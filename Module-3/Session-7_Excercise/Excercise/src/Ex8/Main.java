package Ex8;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU QUẢN LÝ SINH VIÊN ---");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin theo mã ID");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> displayAll();
                case 2 -> addStudent();
                case 3 -> editStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Tạm biệt!");
                    return;
                }
                default -> System.out.println("Lựa chọn sai!");
            }
        }
    }

    private static void displayAll() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("\nDANH SÁCH SINH VIÊN:");
        for (Student s : list) s.displayData();
    }

    private static void addStudent() {
        Student s = new Student();
        s.inputData(sc);
        list.add(s);
        System.out.println("Thêm thành công!");
    }

    private static void editStudent() {
        System.out.print("Nhập mã ID cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student s : list) {
            if (s.getId() == id) {
                System.out.println("Nhập thông tin mới:");
                s.inputData(sc);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có ID này.");
    }

    private static void deleteStudent() {
        System.out.print("Nhập mã ID cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removed = list.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên.");
        }
    }
}
