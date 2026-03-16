package Ex4;
import java.util.Scanner;

public class KiemTraEmail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập chuỗi email và loại bỏ khoảng trắng thừa
        System.out.print("Nhập địa chỉ email: ");
        String email = sc.nextLine().trim();


        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";

        // 3. Kiểm tra và in kết quả
        if (email.matches(regex)) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }

        sc.close();
    }
}