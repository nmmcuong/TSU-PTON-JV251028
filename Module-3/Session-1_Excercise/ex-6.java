import java.util.Scanner;

public class TinhHinhChuNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Khai báo các biến kiểu float
        float width, height, area, circumference;

        // 2. Nhập dữ liệu từ bàn phím
        System.out.print("Nhập chiều rộng (width): ");
        width = scanner.nextFloat();
        System.out.print("Nhập chiều cao (height): ");
        height = scanner.nextFloat();

        // 3. Tính diện tích và chu vi
        // Công thức diện tích: dài * rộng
        area = width * height;
        // Công thức chu vi: (dài + rộng) * 2
        circumference = (width + height) * 2;

        // 4. In kết quả lên màn hình (làm tròn 2 chữ số thập phân)
        System.out.printf("Diện tích : %.2f\n", area);
        System.out.printf("Chu vi : %.2f\n", circumference);

        scanner.close();
    }
}