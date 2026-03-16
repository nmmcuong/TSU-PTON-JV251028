package Ex5;
public class SoSanhHieuSuatChuoi {

    public static void main(String[] args) {
        int soLanNoi = 1000000; // 1 triệu lần
        long startTime, endTime;

        // 1. Kiểm tra với String
        // Lưu ý: Với 1 triệu lần, String có thể chạy rất lâu hoặc gây tràn bộ nhớ 
        // tùy cấu hình máy, bạn có thể giảm xuống 10,000 để thấy kết quả nhanh hơn.
        startTime = System.currentTimeMillis();
        String str = "Hello";
        for (int i = 0; i < 10000; i++) { // Dùng số lần nhỏ cho String
            str += " World";
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với String (10,000 lần): " + (endTime - startTime) + " ms");

        // 2. Kiểm tra với StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < soLanNoi; i++) {
            sb.append(" World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuilder (1 triệu lần): " + (endTime - startTime) + " ms");

        // 3. Kiểm tra với StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < soLanNoi; i++) {
            sbf.append(" World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuffer (1 triệu lần): " + (endTime - startTime) + " ms");

        // Nhận xét kết quả
        System.out.println("\nNhận xét:");
        System.out.println("- String: Chậm nhất do tạo ra đối tượng mới sau mỗi lần nối.");
        System.out.println("- StringBuilder: Nhanh nhất, thích hợp cho đơn luồng.");
        System.out.println("- StringBuffer: Chậm hơn StringBuilder một chút do cơ chế đồng bộ hóa (Thread-safe).");
    }
}