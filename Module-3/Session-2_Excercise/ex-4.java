import java.util.Scanner;

public class TinhTongVongLap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đầu vào: Nhập số nguyên dương N từ bàn phím
        System.out.print("Nhập vào số nguyên dương N: ");
        int n = scanner.nextInt();

        // Kiểm tra số nhập vào có hợp lệ hay không (N phải lớn hơn 0)
        if (n <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            int tong = 0;
            // Xử lý: Sử dụng vòng lặp for để tính tổng từ 1 đến N
            for (int i = 1; i <= n; i++) {
                tong += i; // Cộng dồn từng giá trị vào biến tong
            }

            // Đầu ra: Hiển thị kết quả tính tổng
            System.out.printf("Tổng các số từ 1 đến %d là: %d\n", n, tong);
        }

        scanner.close();
    }
}