import java.util.Scanner;

public class KiemTraSoNgay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu nhập một số nguyên từ bàn phím
        System.out.print("Nhập vào một tháng (1-12): ");
        int thang = scanner.nextInt();

        // Sử dụng cấu trúc switch-case để xác định số ngày
        switch (thang) {
            // Nhóm các tháng có 31 ngày
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.printf("Tháng %d có 31 ngày.\n", thang);
                break;
            
            // Nhóm các tháng có 30 ngày
            case 4: case 6: case 9: case 11:
                System.out.printf("Tháng %d có 30 ngày.\n", thang);
                break;
            
            // Tháng 2 đặc biệt
            case 2:
                System.out.println("Tháng 2 có 28 hoặc 29 ngày (tùy vào năm nhuận).");
                break;
            
            // Sử dụng default để xử lý các giá trị không hợp lệ
            default:
                System.out.println("Tháng không hợp lệ.");
                break;
        }

        scanner.close();
    }
}