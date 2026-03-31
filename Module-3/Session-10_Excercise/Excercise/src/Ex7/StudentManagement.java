package Ex7;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Student> list = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n--- QUẢN LÝ SINH VIÊN ---");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Hiển thị danh sách sau khi phân loại");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: inputStudents(); break;
                    case 2: displayAll(); break;
                    case 3: searchByName(); break;
                    case 4: displayByClassification(); break;
                    case 5: break;
                    default: System.out.println("Vui lòng chọn 1-5!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            }
        } while (choice != 5);
    }

    private static void inputStudents() {
        System.out.println("Nhập danh sách sinh viên (ít nhất 5):");
        while (list.size() < 5) {
            System.out.println("--- Sinh viên thứ " + (list.size() + 1) + " ---");
            try {
                System.out.print("Nhập ID: ");
                int id = Integer.parseInt(sc.nextLine());
                
                System.out.print("Nhập Tên: ");
                String name = sc.nextLine().trim();
                if (name.isEmpty()) throw new Exception("Tên không được trống!");

                System.out.print("Nhập GPA: ");
                double gpa = Double.parseDouble(sc.nextLine());
                if (gpa < 0 || gpa > 10) throw new Exception("GPA phải từ 0-10!");

                list.add(new Student(id, name, gpa));
            } catch (Exception e) {
                System.out.println("Lỗi nhập liệu: " + e.getMessage() + ". Vui lòng nhập lại sinh viên này.");
            }
        }
        System.out.println("Đã đủ số lượng tối thiểu!");
    }

    private static void displayAll() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        for (Student s : list) System.out.println(s);
    }

    private static void searchByName() {
        System.out.print("Nhập tên cần tìm: ");
        String key = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Student s : list) {
            if (s.getName().toLowerCase().contains(key)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sinh viên nào.");
    }

    private static void displayByClassification() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("\n--- DANH SÁCH PHÂN LOẠI ---");
        // In theo thứ tự ưu tiên Xuất sắc -> Yếu
        String[] loai = {"Xuất sắc", "Giỏi", "Khá", "Trung bình/Yếu"};
        for (String l : loai) {
            System.out.println("[" + l + "]:");
            for (Student s : list) {
                if (s.xepLoai().equals(l)) System.out.println("  " + s);
            }
        }
    }
}