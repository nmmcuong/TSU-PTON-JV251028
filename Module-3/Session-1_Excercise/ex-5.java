import java.util.Scanner;

public class TongPhanSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập phân số thứ nhất (a/b)
        System.out.print("Nhập tử số phân số 1 (a): ");
        int a = scanner.nextInt();
        System.out.print("Nhập mẫu số phân số 1 (b): ");
        int b = scanner.nextInt();

        // Nhập phân số thứ hai (c/d)
        System.out.print("Nhập tử số phân số 2 (c): ");
        int c = scanner.nextInt();
        System.out.print("Nhập mẫu số phân số 2 (d): ");
        int d = scanner.nextInt();

        // Tính toán theo công thức: (a*d + b*c) / (b*d)
        int tuSoMoi = (a * d) + (b * c);
        int mauSoMoi = b * d;

        // In kết quả ra màn hình dưới dạng phân số a/b
        System.out.printf("kết quả : %d/%d\n", tuSoMoi, mauSoMoi);

        scanner.close();
    }
}