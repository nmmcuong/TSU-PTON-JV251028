import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SoHappy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Đầu vào: Nhập số nguyên dương N
        System.out.print("Nhập vào số nguyên dương N: ");
        int n = scanner.nextInt();

        System.out.printf("Các số Happy nhỏ hơn hoặc bằng %d là: ", n);
        
        boolean first = true;
        // Xử lý: Duyệt qua các số từ 1 đến N
        for (int i = 1; i <= n; i++) {
            if (isHappy(i)) {
                if (!first) System.out.print(", ");
                System.out.print(i);
                first = false;
            }
        }
        System.out.println();
        scanner.close();
    }

    // Hàm kiểm tra một số có phải số Happy không
    public static boolean isHappy(int n) {
        // Sử dụng một Set để phát hiện vòng lặp vô hạn
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        
        return n == 1;
    }

    // Hàm tính tổng bình phương các chữ số
    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            totalSum += d * d;
            n = n / 10;
        }
        return totalSum;
    }
}