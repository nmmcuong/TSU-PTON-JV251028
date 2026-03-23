package Ex8;
public class Main {
    public static void main(String[] args) {
        // Tạo các đối tượng sản phẩm
        Product p1 = new Electronics("Laptop", 1000);
        Product p2 = new Clothing("Áo khoác", 500);
        Product p3 = new Food("Bánh mì", 100);

        System.out.println("--- GIÁ SAU CHIẾT KHẤU (MUA LẺ 1 MÓN) ---");
        printInfo(p1);
        printInfo(p2);
        printInfo(p3);

        System.out.println("\n--- GIÁ KHI MUA SỐ LƯỢNG LỚN (150 SẢN PHẨM) ---");
        int qty = 150;
        printBulkInfo(p1, qty);
        printBulkInfo(p2, qty);
        printBulkInfo(p3, qty);
    }

    // Hàm phụ trợ để in thông tin mua lẻ
    public static void printInfo(Product p) {
        System.out.println(p.toString() + " | Chiết khấu: " + p.getDiscount() + "% | Giá cuối: " + p.getFinalPrice());
    }

    // Hàm phụ trợ để in thông tin mua sỉ
    public static void printBulkInfo(Product p, int qty) {
        System.out.println(p.toString() + " | SL: " + qty + " | Chiết khấu: " + p.getDiscount(qty) + "% | Tổng: " + p.getFinalPrice(qty));
    }
}
