package Ex7;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1. Khởi tạo danh sách sinh viên như trong hình
        List<Student> students = List.of(
            new Student("Quý", "IT", 8.5),
            new Student("Lan", "Business", 7.2),
            new Student("Minh", "IT", 9.0),
            new Student("Huyền", "Design", 6.8),
            new Student("Long", "IT", 7.9),
            new Student("Trang", "Business", 8.1),
            new Student("Việt", "IT", 8.0),
            new Student("Tú", "Design", 7.5),
            new Student("Phúc", "Business", 6.9),
            new Student("An", "AI", 9.5)
        );

        // 2. Thống kê số lượng sinh viên từng chuyên ngành (trả về Map<String, Long>)
        Map<String, Long> majorCountMap = students.stream()
            .collect(Collectors.groupingBy(Student::getMajor, Collectors.counting()));

        // 3. Sắp xếp danh sách thống kê theo số lượng giảm dần và in ra
        System.out.println("--- Thống kê chuyên ngành (Sắp xếp giảm dần) ---");
        majorCountMap.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(entry -> {
                System.out.printf("Chuyên ngành: %-10s | Số lượng: %d\n", 
                                  entry.getKey(), entry.getValue());
            });
    }
}
