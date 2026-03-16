package Ex3;
import java.util.Scanner;

public class ThayTheChuSo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập chuỗi từ bàn phím
        System.out.print("Nhập vào một chuỗi: ");
        String input = sc.nextLine();

        // 2. Sử dụng replaceAll với Regex "\\d" để tìm tất cả chữ số
        // \\d đại diện cho các ký tự từ 0 đến 9
        String result = input.replaceAll("\\d", "*");

        // 3. In kết quả ra màn hình
        System.out.println("Kết quả sau khi thay thế:");
        System.out.println(result);

        sc.close();
    }
}