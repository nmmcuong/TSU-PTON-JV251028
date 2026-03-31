package Ex6;

import java.util.List;

public interface ProductProcessor {
    // Phương thức abstract: Phải được cài đặt ở lớp con
    double calculateTotalValue(List<Product> products);

    // Phương thức static: Gọi trực tiếp từ Interface
    static void printProductList(List<Product> products) {
        System.out.println("--- Danh sách sản phẩm ---");
        products.forEach(p -> System.out.println(p.toString()));
    }

    // Phương thức default: Có sẵn logic, lớp con có thể dùng luôn hoặc ghi đè
    default boolean hasExpensiveProduct(List<Product> products) {
        return products.stream().anyMatch(p -> p.getPrice() > 100);
    }
}
