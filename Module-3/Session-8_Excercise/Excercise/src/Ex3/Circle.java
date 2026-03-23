package Ex3;

// Lớp Circle (Hình tròn)
class Circle implements Colorable {
    private double radius;
    private String color;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("Hình tròn [Bán kính: " + radius + ", Màu sắc: " + color + "]");
    }
}

// Lớp Rectangle (Hình chữ nhật)
class Rectangle implements Colorable {
    private double width;
    private double height;
    private String color;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("Hình chữ nhật [Rộng: " + width + ", Dài: " + height + ", Màu sắc: " + color + "]");
    }
}

// Lớp Square (Hình vuông)
class Square implements Colorable {
    private double side;
    private String color;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("Hình vuông [Cạnh: " + side + ", Màu sắc: " + color + "]");
    }
}
