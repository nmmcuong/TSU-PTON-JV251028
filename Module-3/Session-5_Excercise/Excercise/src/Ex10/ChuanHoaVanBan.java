package Ex10;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChuanHoaVanBan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào đoạn văn bản: ");
        String input = sc.nextLine();

        // 1. Kiểm tra đầu vào rỗng
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Không có văn bản để xử lý.");
            return;
        }

        // 2. Xóa các ký tự đặc biệt (chỉ giữ lại a-z, A-Z, 0-9 và khoảng trắng)
        String cleanText = input.replaceAll("[^a-zA-Z0-9\\s]", "");

        // 3. Chuẩn hóa văn bản
        // Chuyển sang chữ thường và xóa khoảng trắng thừa
        String normalizedText = cleanText.toLowerCase().trim().replaceAll("\\s+", " ");

        // 4. Trích xuất các số trong văn bản gốc
        List<String> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            numbers.add(matcher.group());
        }

        // 5. Hiển thị kết quả
        System.out.println("--- Kết quả ---");
        System.out.println("Chuẩn hóa văn bản: \"" + normalizedText + "\"");
        System.out.println("Danh sách số: " + numbers);

        sc.close();
    }
}