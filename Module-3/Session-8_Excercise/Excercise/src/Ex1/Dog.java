package Ex1;
// Lớp Dog kế thừa Animals
class Dog extends Animals {
    private String breed; // Giống chó

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Woof Woof";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", Giống: " + breed);
    }
}

// Lớp Cat kế thừa Animals
class Cat extends Animals {
    private String furColor; // Màu lông

    public Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", Màu lông: " + furColor);
    }
}
