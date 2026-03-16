package Ex6;
import java.util.Arrays;
import java.util.Scanner;

public class SapXepVaTimKiem {

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

        System.out.print("Nhập số cần tìm: ");
        int x = sc.nextInt();

        // 2. Sắp xếp mảng (Selection Sort - Giảm dần)
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }

        // ĐẦU RA: Hiển thị mảng đã sắp xếp
        System.out.println("\nMảng sau khi sắp xếp theo thứ tự giảm dần: " + Arrays.toString(arr));

        // 3. Tìm kiếm tuyến tính (Linear Search)
        int indexLinear = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                indexLinear = i;
                break;
            }
        }
        printResult("Tìm kiếm tuyến tính", x, indexLinear);

        // 4. Tìm kiếm nhị phân (Binary Search - Áp dụng cho mảng GIẢM DẦN)
        int indexBinary = -1;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                indexBinary = mid;
                break;
            }
            // Vì mảng giảm dần: nếu arr[mid] < x, x nằm bên trái
            if (arr[mid] < x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        printResult("Tìm kiếm nhị phân", x, indexBinary);

        sc.close();
    }

    // Hàm phụ trợ in kết quả
    public static void printResult(String method, int x, int index) {
        if (index != -1) {
            System.out.println(method + ": Phần tử " + x + " tìm thấy tại chỉ số: " + index);
        } else {
            System.out.println(method + ": Không tìm thấy phần tử " + x);
        }
    }
}