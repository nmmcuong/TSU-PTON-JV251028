package Ex2;

import java.util.Arrays;
import java.util.Scanner;

public class TimKiemMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        // 1. Sắp xếp chọn giảm dần
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));

        // 2. Tìm kiếm
        System.out.print("Nhập số cần tìm: ");
        int x = sc.nextInt();

        // Tuyến tính
        int linearIdx = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) { linearIdx = i; break; }
        }
        System.out.println("Tìm kiếm tuyến tính: Vị trí " + linearIdx);

        // Nhị phân (cho mảng giảm dần)
        int low = 0, high = n - 1, binaryIdx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) { binaryIdx = mid; break; }
            if (arr[mid] < x) high = mid - 1; else low = mid + 1;
        }
        System.out.println("Tìm kiếm nhị phân: Vị trí " + binaryIdx);
    }
}