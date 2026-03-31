package ra.presentation;

import ra.entity.Categories;
import ra.entity.Product;
import java.util.Scanner;

public class ShopManagement {
    private static Categories[] arrCategories = new Categories[100];
    private static Product[] arrProduct = new Product[100];
    private static int indexCatalog = 0;
    private static int indexProduct = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: menuCategories(); break;
                case 2: menuProduct(); break;
                case 3: System.exit(0);
            }
        }
    }

    // --- QUẢN LÝ DANH MỤC ---
    public static void menuCategories() {
        while (true) {
            System.out.println("\n********************CATEGORIES MENU***********");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 6) break;
            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng danh mục: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        arrCategories[indexCatalog] = new Categories();
                        arrCategories[indexCatalog].inputData(scanner, arrCategories, indexCatalog);
                        indexCatalog++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < indexCatalog; i++) arrCategories[i].displayData();
                    break;
                case 3:
                    updateCatalog();
                    break;
                case 4:
                    deleteCatalog();
                    break;
                case 5:
                    changeStatusCatalog();
                    break;
            }
        }
    }

    private static void updateCatalog() {
        System.out.print("Nhập mã danh mục cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        int findIdx = -1;
        for (int i = 0; i < indexCatalog; i++) {
            if (arrCategories[i].getCatalogId() == id) { findIdx = i; break; }
        }
        if (findIdx != -1) {
            System.out.print("Tên mới: "); arrCategories[findIdx].setCatalogName(scanner.nextLine());
            System.out.print("Mô tả mới: "); arrCategories[findIdx].setDescriptions(scanner.nextLine());
            System.out.print("Trạng thái mới (true/false): "); arrCategories[findIdx].setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
        } else System.err.println("Không tìm thấy!");
    }

    private static void deleteCatalog() {
        System.out.print("Nhập mã danh mục cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean hasProduct = false;
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getCatalogId() == id) { hasProduct = true; break; }
        }
        if (hasProduct) {
            System.err.println("Danh mục này có sản phẩm, không thể xóa!");
        } else {
            // Logic xóa mảng
            for (int i = 0; i < indexCatalog; i++) {
                if (arrCategories[i].getCatalogId() == id) {
                    for (int j = i; j < indexCatalog - 1; j++) arrCategories[j] = arrCategories[j+1];
                    indexCatalog--;
                    System.out.println("Xóa thành công.");
                    return;
                }
            }
            System.err.println("Không tìm thấy.");
        }
    }

    private static void changeStatusCatalog() {
        System.out.print("Nhập mã danh mục cần đổi trạng thái: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < indexCatalog; i++) {
            if (arrCategories[i].getCatalogId() == id) {
                arrCategories[i].setCatalogStatus(!arrCategories[i].isCatalogStatus());
                System.out.println("Cập nhật thành công.");
                return;
            }
        }
        System.err.println("Không tìm thấy.");
    }

    // --- QUẢN LÝ SẢN PHẨM ---
    public static void menuProduct() {
        while (true) {
            System.out.println("\n*******************PRODUCT MANAGEMENT*****************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã");
            System.out.println("5. Xóa sản phẩm");
            System.out.println("6. Tìm kiếm sản phẩm theo tên");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a - b");
            System.out.println("8. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 8) break;
            switch (choice) {
                case 1:
                    System.out.print("Số lượng sản phẩm: ");
                    int m = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < m; i++) {
                        arrProduct[indexProduct] = new Product();
                        arrProduct[indexProduct].inputData(scanner, arrProduct, indexProduct, arrCategories, indexCatalog);
                        indexProduct++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < indexProduct; i++) arrProduct[i].displayData();
                    break;
                case 3:
                    sortProductByPrice();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    searchProductByName();
                    break;
                case 7:
                    searchProductByPriceRange();
                    break;
            }
        }
    }

    private static void sortProductByPrice() {
        for (int i = 0; i < indexProduct - 1; i++) {
            for (int j = i + 1; j < indexProduct; j++) {
                if (arrProduct[i].getPrice() > arrProduct[j].getPrice()) {
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp.");
    }

    private static void updateProduct() {
        System.out.print("Nhập mã SP cần sửa: ");
        String id = scanner.nextLine();
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductId().equalsIgnoreCase(id)) {
                arrProduct[i].inputData(scanner, arrProduct, indexProduct, arrCategories, indexCatalog);
                return;
            }
        }
        System.err.println("Không tìm thấy.");
    }

    private static void deleteProduct() {
        System.out.print("Nhập mã SP cần xóa: ");
        String id = scanner.nextLine();
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductId().equalsIgnoreCase(id)) {
                for (int j = i; j < indexProduct - 1; j++) arrProduct[j] = arrProduct[j+1];
                indexProduct--;
                System.out.println("Xóa thành công.");
                return;
            }
        }
        System.err.println("Không tìm thấy.");
    }

    private static void searchProductByName() {
        System.out.print("Nhập tên cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductName().toLowerCase().contains(name)) arrProduct[i].displayData();
        }
    }

    private static void searchProductByPriceRange() {
        System.out.print("Giá từ: "); float a = Float.parseFloat(scanner.nextLine());
        System.out.print("Đến: "); float b = Float.parseFloat(scanner.nextLine());
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getPrice() >= a && arrProduct[i].getPrice() <= b) arrProduct[i].displayData();
        }
    }
}
