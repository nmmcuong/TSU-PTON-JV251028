package Ex2;

// Lớp Car kế thừa từ Vehicle
class Car extends Vehicle {
    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    void displayInfo() {
        System.out.println("Loại phương tiện: Xe hơi");
        System.out.println("Tên xe: " + name);
        System.out.println("Tốc độ: " + speed + " km/h");
        System.out.println("-------------------------");
    }
}

// Lớp Bike kế thừa từ Vehicle
class Bike extends Vehicle {
    public Bike(String name, int speed) {
        super(name, speed);
    }

    @Override
    void displayInfo() {
        System.out.println("Loại phương tiện: Xe máy");
        System.out.println("Tên xe: " + name);
        System.out.println("Tốc độ: " + speed + " km/h");
        System.out.println("-------------------------");
    }
}
