package Ex2;

import java.util.Scanner;

public class QuanLyDiem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        
        // Các biến lưu trữ thống kê
        int soHocVien = 0;
        double tongDiem = 0;
        double diemCaoNhat = -1; 
        double diemThapNhat = 11;

        while (true) {
            System.out.println("\n***************MENU NHẬP ĐIỂM***************");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    while (true) {
                        System.out.print("Nhập điểm (Nhập -1 để dừng): ");
                        double diem = sc.nextDouble();

                        if (diem == -1) {
                            break; // Kết thúc nhập
                        }

                        if (diem < 0 || diem > 10) {
                            System.out.println("Cảnh báo: Điểm không hợp lệ (0-10). Vui lòng nhập lại!");
                            continue;
                        }

                        // Xếp loại học lực
                        String xepLoai = "";
                        if (diem < 5) xepLoai = "Yếu";
                        else if (diem < 7) xepLoai = "Trung Bình";
                        else if (diem < 8) xepLoai = "Khá";
                        else if (diem < 9) xepLoai = "Giỏi";
                        else xepLoai = "Xuất sắc";
                        
                        System.out.println("Xếp loại: " + xepLoai);

                        // Cập nhật thống kê
                        soHocVien++;
                        tongDiem += diem;
                        if (diem > diemCaoNhat) diemCaoNhat = diem;
                        if (diem < diemThapNhat) diemThapNhat = diem;
                    }
                    break;

                case 2:
                    System.out.println("\n--- THỐNG KÊ ---");
                    if (soHocVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.println("Số học viên đã nhập: " + soHocVien);
                        System.out.println("Điểm trung bình: " + (tongDiem / soHocVien));
                        System.out.println("Điểm cao nhất: " + diemCaoNhat);
                        System.out.println("Điểm thấp nhất: " + diemThapNhat);
                    }
                    break;

                case 3:
                    System.out.println("Đang thoát chương trình...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
}