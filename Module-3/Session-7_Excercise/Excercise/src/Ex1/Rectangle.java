package Ex1;

public class Rectangle {
    // 1. Các thuộc tính
    private double length;
    private double width;

    // 2. Các Constructor
    // Khởi tạo hình chữ nhật với kích thước mặc định (1, 1)
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    // Khởi tạo với chiều dài và chiều rộng do người dùng cung cấp
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // 3. Các phương thức
    // Tính diện tích
    public double getArea() {
        return length * width;
    }

    // Tính chu vi
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Hiển thị thông tin
    public void display() {
        System.out.println("Chiều dài: " + length);
        System.out.println("Chiều rộng: " + width);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }

    // 4. Phương thức main để kiểm tra
    public static void main(String[] args) {
        // Tạo đối tượng 1: Sử dụng constructor mặc định
        System.out.println("Hình chữ nhật 1:");
        Rectangle rect1 = new Rectangle();
        rect1.display();

        System.out.println(); // In dòng trống để phân tách

        // Tạo đối tượng 2: Sử dụng constructor có tham số (5.0 và 3.0)
        System.out.println("Hình chữ nhật 2:");
        Rectangle rect2 = new Rectangle(5.0, 3.0);
        rect2.display();
    }
}
