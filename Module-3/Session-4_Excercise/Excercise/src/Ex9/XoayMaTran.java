package Ex9;

import java.util.Scanner;

public class XoayMaTran {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập kích thước n
        System.out.print("Nhập kích thước ma trận vuông n: ");
        int n = sc.nextInt();

        // Xử lý Test Case n <= 0
        if (n <= 0) {
            System.out.println("Ma trận không hợp lệ");
            return;
        }

        int[][] matrix = new int[n][n];

        // 2. Nhập các phần tử ma trận
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 3. Xử lý xoay 90 độ theo chiều kim đồng hồ
        
        // Bước A: Chuyển vị ma trận (Transpose)
        // Hoán đổi matrix[i][j] với matrix[j][i]
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Bước B: Đảo ngược thứ tự các phần tử trong từng hàng
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        // 4. In kết quả
        System.out.println("Ma trận sau khi xoay 90 độ:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}