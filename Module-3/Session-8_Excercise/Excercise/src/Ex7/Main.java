package Ex7;
public class Main {
    public static void main(String[] args) {
        // 1. Tạo các đối tượng
        Employee emp = new Employee("Nguyễn Văn A", "NV01", 1000);
        Manager mgr = new Manager("Trần Thị B", "QL02", 2000, 500);
        Developer dev = new Developer("Lê Văn C", "LT03", 1500, "Java");

        // 2. In thông tin chi tiết bằng toString() và lương thực nhận bằng getSalary()
        System.out.println("--- Thông tin nhân viên ban đầu ---");
        System.out.println(emp.toString());
        System.out.println(mgr.toString());
        System.out.println(dev.toString());

        // 3. Tăng lương cho nhân viên Nguyễn Văn A
        System.out.println("\n--- Thực hiện tăng lương cho " + emp.getSalary() + " ---");
        emp.increaseSalary(200);
        
        System.out.println("Thông tin sau khi tăng lương:");
        System.out.println(emp.toString());
    }
}
