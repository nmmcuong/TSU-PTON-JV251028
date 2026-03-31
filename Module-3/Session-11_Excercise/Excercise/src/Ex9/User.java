package Ex9;

import java.time.LocalDate;
import java.util.Optional;

class User {
    private int id;
    private String name;
    private Optional<String> email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    public String getName() { return name; }
    public Optional<String> getEmail() { return email; }

    @Override
    public String toString() {
        // Xử lý email: nếu có thì in ra, không có thì ghi "Không có email"
        String emailStr = email.orElse("Không có email");
        return String.format("Tên: %-10s | Email: %s", name, emailStr);
    }
}

class Task {
    private int id;
    private String title;
    private User assignedTo;
    private LocalDate dueDate;
    private boolean completed;

    public Task(int id, String title, User assignedTo, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public String getTitle() { return title; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isCompleted() { return completed; }

    @Override
    public String toString() {
        return String.format("Task: %-25s | Hạn: %s | Trạng thái: %s | Người làm: %s", 
                title, dueDate, (completed ? "X" : "Đang làm"), assignedTo.getName());
    }
}
