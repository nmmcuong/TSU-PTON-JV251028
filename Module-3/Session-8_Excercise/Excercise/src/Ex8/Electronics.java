package Ex8;
//Lớp Electronics - Chiết khấu 10%
class Electronics extends Product {
 public Electronics(String name, double price) {
     super(name, price);
 }

 @Override
 public double getDiscount() {
     return 10;
 }
}

//Lớp Clothing - Chiết khấu 20%
class Clothing extends Product {
 public Clothing(String name, double price) {
     super(name, price);
 }

 @Override
 public double getDiscount() {
     return 20;
 }
}

//Lớp Food - Chiết khấu 5%
class Food extends Product {
 public Food(String name, double price) {
     super(name, price);
 }

 @Override
 public double getDiscount() {
     return 5;
 }
}
