package Ex4;

import java.util.*;

public class ProductManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Sử dụng HashMap với Key là ID (String) và Value là đối tượng Product
        Map<String, Product> productMap = new HashMap<>();
        
        while (true) {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ SẢN PHẨM ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách");
            System.out.println("5. Lọc sản phẩm (Giá > 100)");
            System.out.println("6. Tính tổng giá trị");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) break;

            switch (choice) {
                case 1: // Thêm
                    System.out.print("Nhập ID: "); String id = sc.nextLine();
                    System.out.print("Nhập tên: "); String name = sc.nextLine();
                    System.out.print("Nhập giá: "); double price = Double.parseDouble(sc.nextLine());
                    productMap.put(id, new Product(id, name, price));
                    System.out.println("Đã thêm thành công!");
                    break;

                case 2: // Sửa
                    System.out.print("Nhập ID cần sửa: "); String editId = sc.nextLine();
                    if (productMap.containsKey(editId)) {
                        System.out.print("Tên mới: "); productMap.get(editId).setName(sc.nextLine());
                        System.out.print("Giá mới: "); productMap.get(editId).setPrice(Double.parseDouble(sc.nextLine()));
                        System.out.println("Cập nhật thành công!");
                    } else {
                        System.out.println("Không tìm thấy ID này.");
                    }
                    break;

                case 3: // Xóa
                    System.out.print("Nhập ID cần xóa: "); String delId = sc.nextLine();
                    if (productMap.remove(delId) != null) {
                        System.out.println("Đã xóa sản phẩm.");
                    } else {
                        System.out.println("ID không tồn tại.");
                    }
                    break;

                case 4: // Hiển thị
                    System.out.println("--- Danh sách sản phẩm ---");
                    productMap.values().forEach(System.out::println);
                    break;

                case 5: // Lọc > 100
                    System.out.println("--- Sản phẩm có giá > 100 ---");
                    productMap.values().stream()
                        .filter(p -> p.getPrice() > 100)
                        .forEach(System.out::println);
                    break;

                case 6: // Tính tổng
                    double total = productMap.values().stream()
                        .mapToDouble(Product::getPrice)
                        .sum();
                    System.out.println("Tổng giá trị kho hàng: " + total);
                    break;
            }
        }
    }
}
