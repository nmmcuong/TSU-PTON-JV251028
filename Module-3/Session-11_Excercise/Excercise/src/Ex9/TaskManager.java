package Ex9;

import java.time.LocalDate;
import java.util.List;

public class TaskManager {
    public static void main(String[] args) {
        // 1. Khởi tạo danh sách người dùng
        User u1 = new User(1, "Quý", "quy@example.com");
        User u2 = new User(2, "Lan", null);
        User u3 = new User(3, "Huyền", "huyen@example.com");
        List<User> users = List.of(u1, u2, u3);

        // 2. Khởi tạo danh sách công việc
        List<Task> tasks = List.of(
            new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
            new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
            new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
            new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
            new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true)
        );

        // --- THỰC HIỆN CÁC XỬ LÝ ---

        // Xử lý 1: Liệt kê các công việc quá hạn và chưa hoàn thành
        System.out.println("--- CÔNG VIỆC QUÁ HẠN VÀ CHƯA HOÀN THÀNH ---");
        LocalDate today = LocalDate.now(); // Giả sử hôm nay là ngày thực tế
        tasks.stream()
            .filter(t -> !t.isCompleted() && t.getDueDate().isBefore(today))
            .forEach(System.out::println);

        // Xử lý 2: Thống kê số công việc đã hoàn thành
        long completedCount = tasks.stream()
            .filter(Task::isCompleted)
            .count();
        System.out.println("\nTổng số công việc đã hoàn thành: " + completedCount);

        // Xử lý 3: In danh sách người dùng kèm thông tin Tên, Email (nếu có)
        System.out.println("\n--- DANH SÁCH NGƯỜI DÙNG ---");
        users.forEach(System.out::println);
    }
}
