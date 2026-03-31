package ra.entity;

import java.util.Scanner;

public class Categories implements IShop {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {}

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    // Getters và Setters
    public int getCatalogId() { return catalogId; }
    public void setCatalogId(int catalogId) { this.catalogId = catalogId; }
    public String getCatalogName() { return catalogName; }
    public void setCatalogName(String catalogName) { this.catalogName = catalogName; }
    public String getDescriptions() { return descriptions; }
    public void setDescriptions(String descriptions) { this.descriptions = descriptions; }
    public boolean isCatalogStatus() { return catalogStatus; }
    public void setCatalogStatus(boolean catalogStatus) { this.catalogStatus = catalogStatus; }

    public void inputData(Scanner scanner, Categories[] arrCategories, int index) {
        // Tự tăng ID
        if (index == 0) {
            this.catalogId = 1;
        } else {
            int maxId = arrCategories[0].getCatalogId();
            for (int i = 1; i < index; i++) {
                if (arrCategories[i].getCatalogId() > maxId) {
                    maxId = arrCategories[i].getCatalogId();
                }
            }
            this.catalogId = maxId + 1;
        }

        // Nhập tên danh mục (max 50, không trùng)
        while (true) {
            System.out.print("Nhập tên danh mục (tối đa 50 ký tự): ");
            String name = scanner.nextLine();
            boolean isExist = false;
            for (int i = 0; i < index; i++) {
                if (arrCategories[i].getCatalogName().equalsIgnoreCase(name)) {
                    isExist = true;
                    break;
                }
            }
            if (name.length() <= 50 && !isExist) {
                this.catalogName = name;
                break;
            }
            System.err.println("Tên không hợp lệ hoặc đã tồn tại!");
        }

        System.out.print("Nhập mô tả: ");
        this.descriptions = scanner.nextLine();

        // Nhập trạng thái
        while (true) {
            System.out.print("Trạng thái (true - Hoạt động, false - Không hoạt động): ");
            String status = scanner.nextLine();
            if (status.equalsIgnoreCase("true") || status.equalsIgnoreCase("false")) {
                this.catalogStatus = Boolean.parseBoolean(status);
                break;
            }
            System.err.println("Chỉ nhận true hoặc false!");
        }
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %-3d | Tên: %-20s | Trạng thái: %s\n", 
                catalogId, catalogName, catalogStatus ? "Hoạt động" : "Không hoạt động");
    }
}
