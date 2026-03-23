package Ex8;
public class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Phương thức trả về chiết khấu mặc định (0%)
    public double getDiscount() {
        return 0;
    }

    // Nạp chồng (Overloading): Tính chiết khấu dựa trên số lượng
    public double getDiscount(int quantity) {
        if (quantity > 100) {
            return 5; // Chiết khấu 5% cho tất cả nếu mua trên 100 sản phẩm
        }
        return getDiscount(); // Trả về chiết khấu mặc định của từng loại sản phẩm
    }

    // Tính giá cuối cho 1 sản phẩm
    public double getFinalPrice() {
        double discount = getDiscount();
        return price - (price * discount / 100);
    }

    // Nạp chồng (Overloading): Tính tổng giá cho số lượng sản phẩm nhất định
    public double getFinalPrice(int quantity) {
        double discount = getDiscount(quantity);
        double pricePerUnit = price - (price * discount / 100);
        return pricePerUnit * quantity;
    }

    @Override
    public String toString() {
        return String.format("Sản phẩm: %-12s | Giá gốc: %-8.1f", name, price);
    }
}
