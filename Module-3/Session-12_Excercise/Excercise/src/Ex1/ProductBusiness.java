package Ex1;

import Ex1.Product;
import java.util.*;

public class ProductBusiness {
    public static List<Product> listProduct = new ArrayList<>();
    private static int nextId = 1;

    public static void addProduct(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1));
            Product p = new Product();
            p.setProductId(nextId++);
            p.inputData(scanner, listProduct);
            listProduct.add(p);
        }
        System.out.println("Thêm thành công!");
    }

    public static void displayProducts() {
        if (listProduct.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        listProduct.forEach(System.out::println);
    }

    public static void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product p : listProduct) {
            if (p.getProductId() == id) {
                System.out.println("Nhập thông tin mới:");
                p.inputData(scanner, listProduct);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.err.println("Không tìm thấy mã sản phẩm!");
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean removed = listProduct.removeIf(p -> p.getProductId() == id);
        if (removed) {
            System.out.println("Xóa thành công!");
        } else {
            System.err.println("Không tìm thấy mã sản phẩm!");
        }
    }

    public static void searchByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Product p : listProduct) {
            if (p.getProductName().toLowerCase().contains(keyword)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy kết quả!");
    }

    public static void sortByPriceAsc() {
        listProduct.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Đã sắp xếp theo giá tăng dần!");
        displayProducts();
    }

    public static void sortByQuantityDesc() {
        listProduct.sort((p1, p2) -> p2.getQuantity() - p1.getQuantity());
        System.out.println("Đã sắp xếp theo số lượng giảm dần!");
        displayProducts();
    }
}
