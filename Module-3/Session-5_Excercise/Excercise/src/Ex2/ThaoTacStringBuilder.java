package Ex2;
import java.util.Scanner;

public class ThaoTacStringBuilder {

    public static void main(String[] args) {
        // 1. Khởi tạo chuỗi ban đầu bằng StringBuilder
        StringBuilder sb = new StringBuilder("Hello, Java World!");
        
        // In ra chuỗi ban đầu
        System.out.println("Chuỗi ban đầu: " + sb.toString());

        // 2. Thực hiện xóa các ký tự từ vị trí 5 đến 9
        // Lưu ý: delete(start, end) xóa từ start đến end-1
        sb.delete(5, 9);
        System.out.println("Chuỗi sau khi xóa: " + sb.toString());

        // 3. Thay thế đoạn "World" bằng "Universe"
        // Đầu tiên tìm vị trí bắt đầu của từ "World"
        String target = "World";
        int start = sb.indexOf(target);
        
        if (start != -1) {
            // replace(start, end, str)
            sb.replace(start, start + target.length(), "Universe");
        }
        System.out.println("Chuỗi sau khi thay thế: " + sb.toString());
    }
}