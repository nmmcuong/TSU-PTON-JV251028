package Ex5;
import java.util.Scanner;

public class TongChanLeMang2Chieu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Khởi tạo mảng 2 chiều
        System.out.print("Nhập số hàng: ");
        int rows = sc.nextInt();
        System.out.print("Nhập số cột: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Nhập các phần tử cho mảng (theo từng hàng):");
        for (int i = 0; i < rows; i++) {
            System.out.print("Hàng " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 2. Tính tổng số chẵn và số lẻ
        int tongChan = 0;
        int tongLe = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] % 2 == 0) {
                    tongChan += matrix[i][j]; // Chia hết cho 2 là số chẵn
                } else {
                    tongLe += matrix[i][j];   // Ngược lại là số lẻ
                }
            }
        }

        // 3. Đầu ra
        System.out.println("\nTổng các số chẵn là: " + tongChan);
        System.out.println("Tổng các số lẻ là: " + tongLe);

        sc.close();
    }
}