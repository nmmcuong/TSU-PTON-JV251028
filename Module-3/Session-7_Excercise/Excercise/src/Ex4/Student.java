package Ex4;
public class Student {
    private String name;
    private int age;
    private String className;
    private double avgScore;

    // Constructor để dễ dàng tạo danh sách mẫu
    public Student(String name, int age, String className, double avgScore) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.avgScore = avgScore;
    }

    // Getter cho avgScore để so sánh điểm
    public double getAvgScore() {
        return avgScore;
    }

    // Phương thức hiển thị thông tin theo định dạng yêu cầu
    public void displayInfo() {
        System.out.println("Tên: " + name + ", Tuổi: " + age + 
                           ", Lớp: " + className + ", Điểm trung bình: " + avgScore);
    }
}
