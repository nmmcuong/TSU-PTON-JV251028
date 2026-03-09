import java.util.Scanner;

public class KiemTraChanLe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chương trình yêu cầu người dùng nhập một số nguyên [n]
        System.out.print("Nhập vào một số nguyên n: ");
        int n = scanner.nextInt();

        // Sử dụng câu lệnh điều khiển if-else để phân loại kết quả
        if (n == 0) {
            // Nếu số nhập vào là 0
            System.out.println("Số không phải chẵn cũng không phải lẻ");
        } 
        else if (n % 2 == 0) {
            // Sử dụng toán tử % để kiểm tra số chẵn (n % 2 == 0)
            System.out.printf("Số %d là số chẵn\n", n);
        } 
        else {
            // Nếu không phải 0 và không chia hết cho 2 thì là số lẻ (n % 2 != 0)
            System.out.printf("Số %d là số lẻ\n", n);
        }

        scanner.close();
    }
}