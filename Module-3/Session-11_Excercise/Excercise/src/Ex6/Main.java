package Ex6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo danh sách sản phẩm
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.0));
        products.add(new Product("Mouse", 25.0));
        products.add(new Product("Keyboard", 45.0));
        products.add(new Product("Monitor", 150.0));

        ProductProcessor processor = new ProductProcessorImpl();

        // 2. Kiểm tra xem có sản phẩm > 100 hay không
        System.out.println("Kiểm tra sản phẩm đắt tiền (> 100):");
        if (processor.hasExpensiveProduct(products)) {
            products.stream()
                    .filter(p -> p.getPrice() > 100)
                    .forEach(p -> System.out.println("Sản phẩm đắt: " + p.getName() + " (" + p.getPrice() + ")"));
        } else {
            System.out.println("Không có sản phẩm đắt tiền.");
        }

        // 3. Tính tổng giá trị
        double total = processor.calculateTotalValue(products);
        System.out.println("\nTổng giá trị tất cả sản phẩm: " + total);

        // 4. In danh sách bằng phương thức static
        System.out.println();
        ProductProcessor.printProductList(products);
    }
}
