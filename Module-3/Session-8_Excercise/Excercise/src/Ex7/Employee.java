package Ex7;
public class Employee {
    private String name;
    private String id;
    private double salary;

    // Constructors
    public Employee() {}

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Phương thức trả về lương cơ bản
    public double getSalary() {
        return salary;
    }

    // Tăng lương cho nhân viên
    public void increaseSalary(double amount) {
        if (amount > 0) {
            this.salary += amount;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tên: " + name + " | Lương cơ bản: " + salary;
    }

    // Getter cho salary để lớp con có thể sử dụng tính toán
    protected double getBaseSalary() {
        return salary;
    }
}
