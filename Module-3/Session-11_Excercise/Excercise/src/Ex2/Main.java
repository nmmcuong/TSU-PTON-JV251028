package Ex2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo danh sách gồm 10 đối tượng Student
        List<Student> students = Arrays.asList(
            new Student("Alice", 20, 8.5),
            new Student("Bob", 22, 6.0),
            new Student("Charlie", 21, 7.5),
            new Student("David", 25, 9.0),
            new Student("Eve", 20, 5.5),
            new Student("Frank", 22, 8.0),
            new Student("Grace", 21, 7.0),
            new Student("Heidi", 23, 8.0),
            new Student("Ivan", 20, 6.0),
            new Student("Judy", 22, 7.2)
        );

        System.out.println("Danh sách sinh viên có điểm lớn hơn 7.0, sắp xếp theo tên:");

        // 2. Sử dụng Stream để lọc (filter) và sắp xếp (sorted)
        students.stream()
            .filter(s -> s.getGrade() > 7.0) // Lọc sinh viên có điểm > 7.0
            .sorted(Comparator.comparing(Student::getName)) // Sắp xếp theo tên
            .forEach(System.out::println); // In kết quả
    }
}
