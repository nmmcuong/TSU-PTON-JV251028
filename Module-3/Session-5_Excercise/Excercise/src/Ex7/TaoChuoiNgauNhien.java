package Ex7;
import java.util.Random;
import java.util.Scanner;

public class TaoChuoiNgauNhien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Nhập số nguyên n từ người dùng
        System.out.print("Nhập độ dài n (1 <= n <= 1000): ");
        int n = sc.nextInt();

        // Kiểm tra điều kiện đầu vào
        if (n < 1 || n > 1000) {
            System.out.println("Độ dài không hợp lệ!");
            return;
        }

        // 2. Định nghĩa tập hợp các ký tự cho phép
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        // Sử dụng StringBuilder để xây dựng chuỗi hiệu quả hơn cho n lớn (n=1000)
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // 3. Vòng lặp tạo chuỗi ngẫu nhiên độ dài n
        for (int i = 0; i < n; i++) {
            // Lấy ngẫu nhiên một chỉ số trong tập characters
            int index = random.nextInt(characters.length());
            // Thêm ký tự tại chỉ số đó vào chuỗi
            sb.append(characters.charAt(index));
        }

        // 4. In kết quả
        System.out.println("Chuỗi ngẫu nhiên có độ dài " + n + " là:");
        System.out.println("\"" + sb.toString() + "\"");

        sc.close();
    }
}