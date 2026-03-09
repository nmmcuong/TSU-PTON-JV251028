import java.util.Scanner;

public class TinhDienTich {
    public static void main(String[] args) {
        // Sử dụng Scanner để nhập bán kính từ bàn phím
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập bán kính r: ");
        double r = scanner.nextDouble();
        
        // Tính diện tích theo công thức A = PI * r * r
        double dienTich = Math.PI * r * r;
        
        // In kết quả ra màn hình
        // Sử dụng printf để định dạng số thập phân giống trong test case
        System.out.printf("Diện tích : %.2f\n", dienTich);
        
        scanner.close();
    }
}