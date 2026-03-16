package Ex4;
import java.util.Arrays;
import java.util.Scanner;

public class DaoNguocMang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập kích thước mảng
        System.out.print("Nhập kích thước mảng: ");
        int n = sc.nextInt();

        // Xử lý Test Case mảng rỗng
        if (n <= 0) {
            System.out.println("Kích thước rỗng");
            return; // Kết thúc chương trình
        }

        // 2. Nhập giá trị các phần tử
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Hiển thị mảng ban đầu
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));

        // 3. Xử lý đảo ngược mảng (Không dùng mảng phụ)
        // Duyệt đến n/2 vì ta hoán đổi cặp đầu - cuối
        for (int i = 0; i < n / 2; i++) {
            // Hoán đổi arr[i] với arr[n - i - 1]
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        // 4. Đầu ra
        System.out.println("Mảng sau khi đảo ngược: " + Arrays.toString(arr));
        
        sc.close();
    }
}