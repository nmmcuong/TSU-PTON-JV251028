package Ex7;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LocPhanTuDuyNhat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập dữ liệu
        System.out.print("Nhập số phần tử của mảng: ");
        if (!sc.hasNextInt()) {
            System.out.println("Mảng không hợp lệ");
            return;
        }
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Mảng không hợp lệ");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Nhập giá trị từng phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 2. Xử lý: Xác định tần suất xuất hiện
        List<Integer> ketQua = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            // Chỉ giữ lại những phần tử xuất hiện đúng 1 lần
            if (count == 1) {
                ketQua.add(arr[i]);
            }
        }

        // 3. In kết quả
        if (ketQua.isEmpty()) {
            System.out.println("Không có phần tử nào duy nhất trong mảng");
        } else {
            System.out.print("Output: " + ketQua);
        }

        sc.close();
    }
}