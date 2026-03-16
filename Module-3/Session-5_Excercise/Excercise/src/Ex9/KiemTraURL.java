package Ex9;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KiemTraURL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập URL từ bàn phím
        System.out.print("Nhập vào URL cần kiểm tra: ");
        String url = sc.nextLine().trim();

        // 2. Sử dụng Regular Expression để kiểm tra và bắt nhóm (capturing groups)
        // Group 1: Giao thức (http hoặc https)
        // Group 2: Tên miền (các ký tự sau // cho đến khi gặp / hoặc hết chuỗi)
        // Group 3: Đường dẫn (phần còn lại bắt đầu bằng /)
        String regex = "^(https?)://([^/\\s]+)(/.*)?$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        // 3. Xử lý và in kết quả
        if (matcher.matches()) {
            String protocol = matcher.group(1);
            String domain = matcher.group(2);
            String path = matcher.group(3);

            // Xử lý trường hợp không có đường dẫn
            if (path == null || path.equals("")) {
                System.out.println("Giao thức: " + protocol + ", Tên miền: " + domain + ", Đường dẫn: Không có đường dẫn.");
            } else {
                System.out.println("Giao thức: " + protocol + ", Tên miền: " + domain + ", Đường dẫn: " + path);
            }
        } else {
            System.out.println("URL không hợp lệ.");
        }

        sc.close();
    }
}