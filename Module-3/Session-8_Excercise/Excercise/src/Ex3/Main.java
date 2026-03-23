package Ex3;

public class Main {
    public static void main(String[] args) {
        // 1. Khởi tạo các đối tượng
        Circle circle = new Circle(5.5);
        Rectangle rectangle = new Rectangle(4, 8);
        Square square = new Square(10);

        // 2. Thiết lập màu sắc (sử dụng phương thức từ interface)
        circle.setColor("Đỏ");
        rectangle.setColor("Xanh dương");
        square.setColor("Vàng");

        // 3. In kết quả ra màn hình
        System.out.println("--- Thông tin các hình sau khi tô màu ---");
        circle.display();
        rectangle.display();
        square.display();
    }
}
