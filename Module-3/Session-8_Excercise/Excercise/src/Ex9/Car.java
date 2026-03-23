package Ex9;
//Lớp trừu tượng Car
abstract class Car {
 protected String model;
 protected int year;
 protected double price;

 public Car(String model, int year, double price) {
     this.model = model;
     this.year = year;
     this.price = price;
 }

 // Các phương thức trừu tượng
 abstract String start();
 abstract String stop();
}

//Interface Refuelable
interface Refuelable {
 void refuel();
}
