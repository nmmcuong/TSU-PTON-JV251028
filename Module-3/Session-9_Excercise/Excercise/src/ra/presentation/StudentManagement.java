package ra.presentation;

import ra.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("\n********************QUẢN LÝ SINH VIÊN********************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("4. Xóa sinh viên theo mã sinh viên");
            System.out.println("5. Tìm sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: displayAllStudents(); break;
                case 2: addStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: searchStudentByName(); break;
                case 6: System.exit(0);
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }

    // 1. Hiển thị danh sách
    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        for (Student s : studentList) {
            s.displayData();
        }
    }

    // 2. Thêm sinh viên (Cho phép thêm nhiều)
    private static void addStudents() {
        System.out.print("Nhập số lượng sinh viên muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sinh viên thứ " + (i + 1) + ":");
            Student s = new Student();
            s.inputData(scanner);
            studentList.add(s);
        }
    }

    // 3. Cập nhật theo mã
    private static void updateStudent() {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String id = scanner.nextLine();
        boolean found = false;
        for (Student s : studentList) {
            if (s.getStudentId().equals(id)) {
                System.out.println("Nhập thông tin mới:");
                s.inputData(scanner);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Mã sinh viên không tồn tại");
    }

    // 4. Xóa theo mã
    private static void deleteStudent() {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine();
        boolean removed = studentList.removeIf(s -> s.getStudentId().equals(id));
        if (!removed) System.out.println("Mã sinh viên không tồn tại");
        else System.out.println("Xóa thành công!");
    }

    // 5. Tìm theo tên và đếm số lượng
    private static void searchStudentByName() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        int count = 0;
        for (Student s : studentList) {
            if (s.getStudentName().toLowerCase().contains(name)) {
                s.displayData();
                count++;
            }
        }
        System.out.println("Tổng số lượng sinh viên tìm thấy: " + count);
    }
}
