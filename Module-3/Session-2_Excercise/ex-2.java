import java.util.Scanner;

public class KiemTraNgayTuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chương trình yêu cầu nhập một số nguyên
        System.out.print("Nhập vào một số nguyên: ");
        int day = scanner.nextInt();

        // Sử dụng cấu trúc switch-case để xử lý các giá trị nhập vào
        switch (day) {
            case 1:
                System.out.println("Chủ nhật");
                break;
            case 2:
                System.out.println("Thứ hai");
                break;
            case 3:
                System.out.println("Thứ ba");
                break;
            case 4:
                System.out.println("Thứ tư");
                break;
            case 5:
                System.out.println("Thứ năm");
                break;
            case 6:
                System.out.println("Thứ sáu");
                break;
            case 7:
                System.out.println("Thứ bảy");
                break;
            // Kết hợp câu lệnh default để xử lý các trường hợp giá trị ngoài phạm vi (1-7)
            default:
                System.out.println("Số nhập vào không hợp lệ");
                break;
        }

        scanner.close();
    }
}