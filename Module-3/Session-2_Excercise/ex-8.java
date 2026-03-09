import java.util.Scanner;

public class DocSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập vào một số hợp lệ (100-999)
        System.out.print("Nhập vào một số có 3 chữ số (100-999): ");
        int n = scanner.nextInt();

        // Kiểm tra phạm vi 100-999
        if (n < 100 || n > 999) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            // 2. Tách số thành hàng trăm, hàng chục, hàng đơn vị
            int hundreds = n / 100;           // Lấy chữ số hàng trăm
            int tens = (n % 100) / 10;        // Lấy chữ số hàng chục
            int units = n % 10;               // Lấy chữ số hàng đơn vị

            // 3. In kết quả tương ứng
            System.out.print("Kết quả: ");
            docChuSo(hundreds);
            System.out.print(" trăm ");

            if (tens == 0 && units != 0) {
                System.out.print("lẻ ");
            } else if (tens != 0) {
                docHangChuc(tens);
            }

            if (units != 0) {
                docHangDonVi(tens, units);
            }
            System.out.println();
        }
        scanner.close();
    }

    // Hàm phụ trợ đọc chữ số hàng trăm
    public static void docChuSo(int so) {
        String[] chu = {"không", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín"};
        System.out.print(chu[so]);
    }

    // Hàm phụ trợ đọc hàng chục
    public static void docHangChuc(int so) {
        if (so == 1) System.out.print("mười ");
        else {
            docChuSo(so);
            System.out.print(" mươi ");
        }
    }

    // Hàm phụ trợ đọc hàng đơn vị (xử lý các trường hợp đặc biệt như "lăm", "mốt")
    public static void docHangDonVi(int hangChuc, int so) {
        if (so == 1 && hangChuc > 1) System.out.print("mốt");
        else if (so == 5 && hangChuc > 0) System.out.print("lăm");
        else {
            String[] chu = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
            System.out.print(chu[so]);
        }
    }
}