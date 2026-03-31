package Ex7;

class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Getters và Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }

    // Phương thức phân loại sinh viên
    public String xepLoai() {
        if (gpa >= 8.5) return "Xuất sắc";
        if (gpa >= 7.0) return "Giỏi";
        if (gpa >= 5.5) return "Khá";
        return "Trung bình/Yếu";
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %-15s | GPA: %.1f | Xếp loại: %s", 
                              id, name, gpa, xepLoai());
    }
}