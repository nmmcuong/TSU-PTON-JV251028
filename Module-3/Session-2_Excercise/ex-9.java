import java.util.Scanner;

public class SoArmstrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Đầu vào: Nhập N và kiểm tra tính hợp lệ
        while (true) {
            System.out.print("Nhập vào số nguyên dương N: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n >= 0) break;
            } else {
                scanner.next(); // Đọc bỏ giá trị không phải số
            }
            System.out.println("Số nhập vào không hợp lệ");
        }

        System.out.printf("Các số Armstrong trong khoảng từ 0 đến %d là:\n", n);
        
        // Xử lý: Duyệt qua các số từ 0 đến N
        for (int i = 0; i <= n; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        scanner.close();
    }

    // Hàm kiểm tra một số có phải là số Armstrong không
    public static boolean isArmstrong(int num) {
        if (num == 0) return true;

        int temp = num;
        int k = 0;
        
        // Bước 1: Tìm số chữ số (k)
        int countTemp = num;
        while (countTemp > 0) {
            countTemp /= 10;
            k++;
        }

        // Bước 2: Tính tổng lũy thừa bậc k của từng chữ số
        long sum = 0;
        temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, k);
            temp /= 10;
        }

        // Bước 3: So sánh tổng với số ban đầu
        return sum == num;
    }
}