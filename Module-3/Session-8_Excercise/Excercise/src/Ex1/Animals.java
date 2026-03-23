package Ex1;
public class Animals {
    private String name;
    private int age;

    public Animals(String name, int age) {
        setName(name); // Sử dụng setter để tận dụng kiểm tra hợp lệ
        setAge(age);
    }

    // Getter và Setter có kiểm tra hợp lệ
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Lỗi: Tên không được để trống!");
            this.name = "Unknown";
        } else {
            this.name = name;
        }
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Lỗi: Tuổi không được âm!");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public String makeSound() {
        return "Some generic sound";
    }

    public void displayInfo() {
        System.out.print("Tên: " + name + ", Tuổi: " + age);
    }
}
