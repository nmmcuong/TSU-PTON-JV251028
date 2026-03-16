package Ex1;

import java.util.Scanner;

public class TimKiemChuoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập dữ liệu
        System.out.print("Nhập vào một chuỗi văn bản: ");
        String vanBan = sc.nextLine();

        System.out.print("Nhập vào từ cần tìm: ");
        String tuCanTim = sc.nextLine();

        // 2. Xử lý tìm kiếm
        // Phương thức indexOf trả về chỉ số đầu tiên tìm thấy, hoặc -1 nếu không thấy
        int viTri = vanBan.indexOf(tuCanTim);

        // 3. Hiển thị kết quả theo yêu cầu
        if (viTri != -1) {
            System.out.println("Từ \"" + tuCanTim + "\" xuất hiện tại vị trí " + viTri + " trong chuỗi.");
        } else {
            System.out.println("Không tìm thấy từ \"" + tuCanTim + "\" trong chuỗi.");
        }

        sc.close();
    }
}