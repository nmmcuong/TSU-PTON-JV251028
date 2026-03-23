package Ex2;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo đối tượng từ các lớp con
        Vehicle myCar = new Car("Toyota Camry", 180);
        Vehicle myBike = new Bike("Honda SH", 120);

        // Gọi các phương thức
        myCar.start();
        myCar.displayInfo();

        myBike.start();
        myBike.displayInfo();
    }
}
