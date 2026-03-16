package Ex3;

import java.util.Scanner;

public class QuanLyLuong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Khởi tạo các biến thống kê
        int tongNhanVien = 0;
        double tongLuong = 0;
        double luongCaoNhat = -1;
        double luongThapNhat = 500000001; // Lớn hơn mức tối đa để so sánh lần đầu
        double tongTienThuong = 0;

        while (true) {
            System.out.println("\n***************MENU QUẢN LÝ LƯƠNG***************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            
            int luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    while (true) {
                        System.out.print("Nhập lương nhân viên (Nhập -1 để dừng): ");
                        double luong = sc.nextDouble();

                        if (luong == -1) break;

                        if (luong < 0 || luong > 500000000) {
                            System.out.println("Lương không hợp lệ! (Phải từ 0 đến 500 triệu).");
                            continue;
                        }

                        // Phân loại thu nhập
                        if (luong < 5000000) {
                            System.out.println("Phân loại: Thu nhập thấp");
                        } else if (luong <= 15000000) {
                            System.out.println("Phân loại: Thu nhập trung bình");
                        } else if (luong <= 50000000) {
                            System.out.println("Phân loại: Thu nhập khá");
                        } else {
                            System.out.println("Phân loại: Thu nhập cao");
                        }

                        // Tính tiền thưởng cho nhân viên này
                        double thuong = 0;
                        if (luong <= 5000000) thuong = luong * 0.05;
                        else if (luong <= 15000000) thuong = luong * 0.10;
                        else if (luong <= 50000000) thuong = luong * 0.15;
                        else if (luong <= 100000000) thuong = luong * 0.20;
                        else thuong = luong * 0.25;

                        // Cập nhật dữ liệu tổng quát
                        tongNhanVien++;
                        tongLuong += luong;
                        tongTienThuong += thuong;
                        if (luong > luongCaoNhat) luongCaoNhat = luong;
                        if (luong < luongThapNhat) luongThapNhat = luong;
                    }
                    break;

                case 2:
                    System.out.println("\n--- BÁO CÁO THỐNG KÊ ---");
                    if (tongNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.printf("Số nhân viên đã nhập: %d\n", tongNhanVien);
                        System.out.printf("Lương trung bình: %,.2f\n", (tongLuong / tongNhanVien));
                        System.out.printf("Lương cao nhất: %,.2f\n", luongCaoNhat);
                        System.out.printf("Lương thấp nhất: %,.2f\n", luongThapNhat);
                        System.out.printf("Tổng tiền lương: %,.2f\n", tongLuong);
                    }
                    break;

                case 3:
                    System.out.println("\n--- TỔNG TIỀN THƯỞNG ---");
                    if (tongNhanVien == 0) {
                        System.out.println("Chưa có nhân viên để tính thưởng.");
                    } else {
                        System.out.printf("Tổng số tiền thưởng cho tất cả nhân viên: %,.2f VNĐ\n", tongTienThuong);
                    }
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình. Tạm biệt!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}