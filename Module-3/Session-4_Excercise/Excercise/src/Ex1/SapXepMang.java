package Ex1;
import java.util.Arrays;
import java.util.Scanner;

public class SapXepMang {

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

        // 2. Sắp xếp mảng (Sử dụng Selection Sort - Giảm dần)
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i; // Giả định vị trí i là lớn nhất
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j; // Tìm thấy số lớn hơn thì cập nhật index
                }
            }
            // Hoán đổi vị trí số lớn nhất tìm được với vị trí i hiện tại
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }

        // 3. Đầu ra
        System.out.print("Mảng sau khi sắp xếp theo thứ tự giảm dần: ");
        System.out.println(Arrays.toString(arr));

        // Sau khi sắp xếp giảm dần, phần tử lớn nhất luôn nằm ở index 0
        if (n > 0) {
            System.out.println("Phần tử lớn nhất trong mảng là: " + arr[0]);
        }
        
        sc.close();
    }
}