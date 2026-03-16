package Ex2;
import java.util.Scanner;

public class TinhTongMang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Khởi tạo mảng
        System.out.print("Nhập kích thước mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 2. Tính tổng
        int tong = 0;
        for (int i = 0; i < n; i++) {
            tong += arr[i]; // Cộng dồn từng phần tử vào biến tong
        }

        // 3. Đầu ra
        System.out.println("Tổng các phần tử trong mảng là: " + tong);
        
        sc.close();
    }
}