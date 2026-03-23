package Ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Tạo danh sách có sẵn các đối tượng Student
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alice", 19, "A1", 9.0));
        studentList.add(new Student("Bob", 21, "A1", 7.0));
        studentList.add(new Student("Charlie", 20, "A2", 6.5));
        studentList.add(new Student("David", 22, "A2", 5.0));
        studentList.add(new Student("Eve", 20, "A1", 8.0));

        // 2. Nhập khoảng điểm min và max
        System.out.print("Nhập điểm min: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập điểm max: ");
        double max = Double.parseDouble(scanner.nextLine());

        // 3. Hiển thị danh sách sinh viên thỏa mãn điều kiện
        System.out.println("\nDanh sách sinh viên có điểm trung bình từ " + min + " đến " + max + ":");
        
        boolean found = false;
        for (Student s : studentList) {
            if (s.getAvgScore() >= min && s.getAvgScore() <= max) {
                s.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có sinh viên nào trong khoảng điểm này.");
        }

        scanner.close();
    }
}
