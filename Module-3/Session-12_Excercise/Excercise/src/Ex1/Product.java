package Ex1;

import java.util.List;
import java.util.Scanner;

public class Product {
    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public Product() {}

    public Product(int productId, String productName, float price, String category, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    // Getter và Setter
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void inputData(Scanner scanner, List<Product> list) {
        // Tên sản phẩm: 10-50 ký tự, không trùng lặp
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
            this.productName = scanner.nextLine();
            boolean isExist = false;
            for (Product p : list) {
                if (p.getProductName().equals(this.productName)) {
                    isExist = true;
                    break;
                }
            }
            if (this.productName.length() >= 10 && this.productName.length() <= 50 && !isExist) {
                break;
            }
            System.err.println("Tên không hợp lệ hoặc đã tồn tại!");
        }

        // Giá sản phẩm > 0
        while (true) {
            System.out.print("Nhập giá sản phẩm (>0): ");
            try {
                this.price = Float.parseFloat(scanner.nextLine());
                if (this.price > 0) break;
            } catch (Exception e) { }
            System.err.println("Giá phải là số thực lớn hơn 0!");
        }

        // Danh mục sản phẩm (tối đa 200 ký tự)
        while (true) {
            System.out.print("Nhập danh mục sản phẩm: ");
            this.category = scanner.nextLine();
            if (this.category.length() > 0 && this.category.length() <= 200) break;
            System.err.println("Danh mục không được để trống và tối đa 200 ký tự!");
        }

        // Số lượng tồn kho >= 0
        while (true) {
            System.out.print("Nhập số lượng tồn kho (>=0): ");
            try {
                this.quantity = Integer.parseInt(scanner.nextLine());
                if (this.quantity >= 0) break;
            } catch (Exception e) { }
            System.err.println("Số lượng phải là số nguyên >= 0!");
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %-20s | Giá: %.2f | Danh mục: %s | SL: %d",
                productId, productName, price, category, quantity);
    }
}
