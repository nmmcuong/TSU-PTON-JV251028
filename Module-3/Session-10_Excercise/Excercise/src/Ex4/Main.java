package Ex4;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static AttendanceManager manager = new AttendanceManager();

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n***************** MENU QUẢN LÝ ĐIỂM DANH *****************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
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
                System.out.println("Lỗi: Nhập liệu không hợp lệ!");
            }
        } while (choice != 5);
    }

    private static void handleAdd() {
        try {
            System.out.print("Nhập id sinh viên: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập tên sinh viên: ");
            String name = sc.nextLine();
            manager.add(new Student(id, name));
        } catch (Exception e) {
            System.out.println("Lỗi: ID phải là số nguyên!");
        }
    }

    private static void handleUpdate() {
        manager.display();
        try {
            System.out.print("Nhập id sinh viên cần sửa: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập tên mới sinh viên: ");
            String newName = sc.nextLine();
            manager.update(id, new Student(id, newName));
        } catch (Exception e) {
            System.out.println("Lỗi: Nhập liệu không hợp lệ!");
        }
    }

    private static void handleDelete() {
        manager.display();
        try {
            System.out.print("Nhập id sinh viên cần xóa: ");
            int id = Integer.parseInt(sc.nextLine());
            manager.delete(id);
        } catch (Exception e) {
            System.out.println("Lỗi: ID không hợp lệ!");
        }
    }
}