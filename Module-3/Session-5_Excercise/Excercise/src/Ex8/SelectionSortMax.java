package Ex8;
import java.util.Scanner;
import java.util.Arrays;

public class SelectionSortMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        // Thuật toán Selection Sort giảm dần
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

        System.out.println("Mảng sau khi sắp xếp giảm dần: " + Arrays.toString(arr));
        System.out.println("Phần tử lớn nhất trong mảng là: " + arr[0]);
    }
}