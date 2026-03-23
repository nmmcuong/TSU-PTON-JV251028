package Ex2;

abstract class Vehicle {
    protected String name;
    protected int speed;

    // Constructor để khởi tạo thuộc tính
    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    // Phương thức trừu tượng (không có thân hàm)
    abstract void displayInfo();

    // Phương thức thông thường
    public void start() {
        System.out.println(name + " is starting...");
    }
}
