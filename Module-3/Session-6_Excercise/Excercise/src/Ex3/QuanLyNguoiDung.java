package Ex3;

import java.util.Scanner;

public class QuanLyNguoiDung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hoTen = "", email = "", sdt = "", matKhau = "";
        int luaChon;

        do {
            System.out.println("\n*******************QUẢN LÝ NGƯỜI DÙNG*******************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng thừa

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập họ và tên: ");
                    hoTen = sc.nextLine();
                    System.out.print("Nhập email: ");
                    email = sc.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    sdt = sc.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    matKhau = sc.nextLine();
                    break;

                case 2:
                    if (hoTen.isEmpty()) {
                        System.out.println("Vui lòng nhập họ tên trước (Mục 1).");
                    } else {
                        hoTen = chuanHoaHoTen(hoTen);
                        System.out.println("Họ tên sau khi chuẩn hóa: " + hoTen);
                    }
                    break;

                case 3:
                    // Regex: username (chữ, số, ., _) + @ + domain + . + TLD (2-6 ký tự)
                    String emailRegex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
                    if (email.matches(emailRegex)) {
                        System.out.println("Email hợp lệ.");
                    } else {
                        System.out.println("Email không hợp lệ.");
                    }
                    break;

                case 4:
                    // Regex cho SĐT di động Việt Nam (thường bắt đầu bằng 0 và có 10 chữ số)
                    String sdtRegex = "^0\\d{9}$";
                    if (sdt.matches(sdtRegex)) {
                        System.out.println("Số điện thoại hợp lệ.");
                    } else {
                        System.out.println("Số điện thoại không hợp lệ (Phải có 10 số và bắt đầu bằng 0).");
                    }
                    break;

                case 5:
                    // Điều kiện: tối thiểu 8 ký tự, có chữ hoa, chữ thường, số và ký tự đặc biệt
                    String mkRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!^&*])(?=\\S+$).{8,}$";
                    if (matKhau.matches(mkRegex)) {
                        System.out.println("Mật khẩu hợp lệ.");
                    } else {
                        System.out.println("Mật khẩu không hợp lệ (Phải >= 8 ký tự, đủ chữ hoa, thường, số, ký tự đặc biệt).");
                    }
                    break;

                case 6:
                    System.out.println("Chương trình kết thúc.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 6);
        sc.close();
    }

    // Hàm hỗ trợ chuẩn hóa họ tên
    public static String chuanHoaHoTen(String name) {
        name = name.trim().toLowerCase().replaceAll("\\s+", " ");
        String[] words = name.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
              .append(w.substring(1))
              .append(" ");
        }
        return sb.toString().trim();
    }
}