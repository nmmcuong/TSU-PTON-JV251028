package Ex9;
//Lớp xe điện kế thừa Car và triển khai Refuelable
class ElectricCar extends Car implements Refuelable {
 public ElectricCar(String model, int year, double price) {
     super(model, year, price);
 }

 @Override
 String start() {
     return String.format("Xe điện %s (Năm SX: %d, Giá: [%.1f]) đã khởi động không tiếng ồn.", model, year, price);
 }

 @Override
 String stop() {
     return String.format("Xe điện %s (Năm SX: %d, Giá: [%.1f]) đã dừng và ngắt kết nối động cơ.", model, year, price);
 }

 @Override
 public void refuel() {
     System.out.printf("Xe điện %s (Năm SX: %d, Giá: [%.1f]) đang sạc điện...\n", model, year, price);
 }
}

//Lớp xe chạy xăng kế thừa Car và triển khai Refuelable
class GasCar extends Car implements Refuelable {
 public GasCar(String model, int year, double price) {
     super(model, year, price);
 }

 @Override
 String start() {
     return String.format("Xe chạy xăng %s (Năm SX: %d, Giá: [%.1f]) đã khởi động với tiếng động cơ.", model, year, price);
 }

 @Override
 String stop() {
     return String.format("Xe chạy xăng %s (Năm SX: %d, Giá: [%.1f]) đã dừng và động cơ tắt.", model, year, price);
 }

 @Override
 public void refuel() {
     System.out.printf("Xe chạy xăng %s (Năm SX: %d, Giá: [%.1f]) đang được đổ xăng...\n", model, year, price);
 }
}
