package ra.entity;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String major;

    // 1. Constructor không tham số
    public Student() {
    }

    // 2. Constructor đầy đủ tham số
    public Student(String studentId, String studentName, int age, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.major = major;
    }

    // 3. Getter và Setter
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    // 4. Phương thức nhập dữ liệu
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        this.studentId = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        this.studentName = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chuyên ngành: ");
        this.major = scanner.nextLine();
    }

    // 5. Phương thức hiển thị dữ liệu
    public void displayData() {
        System.out.printf("ID: %-10s | Tên: %-20s | Tuổi: %-5d | Ngành: %-15s\n", 
                studentId, studentName, age, major);
    }
}
