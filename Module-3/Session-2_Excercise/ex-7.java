import java.util.Scanner;

public class PhanLoaiTamGiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào 3 cạnh của tam giác:");
        System.out.print("Cạnh a: ");
        double a = scanner.nextDouble();
        System.out.print("Cạnh b: ");
        double b = scanner.nextDouble();
        System.out.print("Cạnh c: ");
        double c = scanner.nextDouble();

        // 1. Kiểm tra điều kiện hợp lệ của tam giác
        if (a + b > c && a + c > b && b + c > a) {
            
            // 2. Phân loại tam giác sử dụng if-else
            if (a == b && b == c) {
                System.out.println("Tam giác đều");
            } 
            else if (a == b || b == c || a == c) {
                System.out.println("Tam giác cân");
            } 
            else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                System.out.println("Tam giác vuông");
            } 
            else {
                System.out.println("Tam giác thường");
            }
            
        } else {
            // Hiển thị thông báo lỗi nếu không phải tam giác
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }

        scanner.close();
    }
}