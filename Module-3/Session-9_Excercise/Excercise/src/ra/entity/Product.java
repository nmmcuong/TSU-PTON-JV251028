package ra.entity;

import java.util.Scanner;

public class Product implements IShop {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private int catalogId;
    private int productStatus;

    public Product() {}

    // Getters và Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
    public int getCatalogId() { return catalogId; }
    public void setCatalogId(int catalogId) { this.catalogId = catalogId; }

    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCatalog) {
        // Nhập mã SP: 4 ký tự, bắt đầu C/S/A, không trùng
        while (true) {
            System.out.print("Nhập mã sản phẩm (Cxxx/Sxxx/Axxx): ");
            String id = scanner.nextLine();
            if (id.matches("^[CSA].{3}$")) {
                boolean isExist = false;
                for (int i = 0; i < indexProduct; i++) {
                    if (arrProduct[i].getProductId().equalsIgnoreCase(id)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    this.productId = id;
                    break;
                }
            }
            System.err.println("Mã SP không đúng định dạng hoặc đã tồn tại!");
        }

        // Nhập tên SP: 10-50 ký tự, không trùng
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
            String name = scanner.nextLine();
            boolean isExist = false;
            for (int i = 0; i < indexProduct; i++) {
                if (arrProduct[i].getProductName().equalsIgnoreCase(name)) {
                    isExist = true;
                    break;
                }
            }
            if (name.length() >= 10 && name.length() <= 50 && !isExist) {
                this.productName = name;
                break;
            }
            System.err.println("Tên không hợp lệ hoặc đã tồn tại!");
        }

        // Giá > 0
        while (true) {
            System.out.print("Nhập giá sản phẩm: ");
            this.price = Float.parseFloat(scanner.nextLine());
            if (this.price > 0) break;
            System.err.println("Giá phải lớn hơn 0!");
        }

        System.out.print("Mô tả SP: ");
        this.description = scanner.nextLine();

        // Chọn danh mục
        System.out.println("--- Danh sách danh mục đang có ---");
        for (int i = 0; i < indexCatalog; i++) {
            System.out.printf("%d. %s\n", arrCategories[i].getCatalogId(), arrCategories[i].getCatalogName());
        }
        System.out.print("Chọn mã danh mục cho sản phẩm: ");
        this.catalogId = Integer.parseInt(scanner.nextLine());

        // Trạng thái 0, 1, 2
        while (true) {
            System.out.print("Trạng thái (0-Đang bán, 1-Hết hàng, 2-Không bán): ");
            this.productStatus = Integer.parseInt(scanner.nextLine());
            if (this.productStatus >= 0 && this.productStatus <= 2) break;
            System.err.println("Vui lòng nhập 0, 1 hoặc 2!");
        }
    }

    @Override
    public void displayData() {
        String statusStr = (productStatus == 0) ? "Đang bán" : (productStatus == 1 ? "Hết hàng" : "Không bán");
        System.out.printf("ID: %-5s | Tên: %-20s | Giá: %-10.2f | Danh mục ID: %-3d | Trạng thái: %s\n",
                productId, productName, price, catalogId, statusStr);
    }
}
