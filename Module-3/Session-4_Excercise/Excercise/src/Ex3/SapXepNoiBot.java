package Ex3;
import java.util.Arrays;
import java.util.Scanner;

public class SapXepNoiBot {

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

        // 2. Sắp xếp mảng bằng thuật toán Bubble Sort (Giảm dần)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Nếu phần tử đứng trước nhỏ hơn phần tử đứng sau thì đổi chỗ
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // 3. Đầu ra
        System.out.print("Mảng sau khi sắp xếp theo thứ tự giảm dần: ");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}