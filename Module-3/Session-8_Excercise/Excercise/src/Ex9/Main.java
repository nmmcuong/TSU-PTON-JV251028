package Ex9;
import java.util.ArrayList;
import java.util.List;

class Garage {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void startAll() {
        System.out.println("--- KHỞI ĐỘNG TẤT CẢ XE ---");
        for (Car c : cars) System.out.println(c.start());
    }

    public void stopAll() {
        System.out.println("\n--- DỪNG TẤT CẢ XE ---");
        for (Car c : cars) System.out.println(c.stop());
    }

    public void refuelAll() {
        System.out.println("\n--- NẠP NHIÊN LIỆU ---");
        for (Car c : cars) {
            if (c instanceof Refuelable) {
                ((Refuelable) c).refuel();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Garage myGarage = new Garage();

        // Thêm các loại xe vào gara
        myGarage.addCar(new ElectricCar("Tesla Model S", 2024, 75000));
        myGarage.addCar(new GasCar("Toyota Camry", 2023, 35000));

        // Thực hiện các hành động hàng loạt
        myGarage.startAll();
        myGarage.refuelAll();
        myGarage.stopAll();
    }
}
