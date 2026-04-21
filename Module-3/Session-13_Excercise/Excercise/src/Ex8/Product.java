package Ex8;

import java.util.Date;

// --- File: Product.java ---
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    @Override
    public String toString() { return "ID: " + id + " | Tên: " + name + " | Giá: " + price; }
}

// --- File: Customer.java ---
class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public int getId() { return id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}

// --- File: Order.java ---
class Order {
    private int id;
    private int customerId;
    private Date orderDate;
    private double totalAmount;

    public Order(int id, int customerId, Date orderDate) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
    }
    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    @Override
    public String toString() {
        return "Đơn hàng #" + id + " | Khách hàng ID: " + customerId + " | Ngày: " + orderDate + " | Tổng tiền: " + totalAmount;
    }
}
