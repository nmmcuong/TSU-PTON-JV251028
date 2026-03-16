package Ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyDiemSV {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> danhSachDiem = new ArrayList<>();
        int luaChon;

        do {
            System.out.println("\n*******************QUẢN LÝ ĐIỂM SV*******************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Mời bạn chọn chức năng (1-8): ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
                        danhSachDiem.add(sc.nextDouble());
                    }
                    break;

                case 2:
                    System.out.println("Danh sách điểm: " + danhSachDiem);
                    break;

                case 3:
                    if (danhSachDiem.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        double tong = 0;
                        for (double d : danhSachDiem) tong += d;
                        System.out.printf("Điểm trung bình: %.2f\n", (tong / danhSachDiem.size()));
                    }
                    break;

                case 4:
                    if (!danhSachDiem.isEmpty()) {
                        System.out.println("Điểm cao nhất: " + Collections.max(danhSachDiem));
                        System.out.println("Điểm thấp nhất: " + Collections.min(danhSachDiem));
                    }
                    break;

                case 5:
                    int dat = 0, truot = 0;
                    for (double d : danhSachDiem) {
                        if (d >= 5) dat++; // Sinh viên đạt khi điểm >= 5
                        else truot++;      // Sinh viên trượt khi điểm < 5
                    }
                    System.out.println("Số SV Đạt: " + dat + ", Số SV Trượt: " + truot);
                    break;

                case 6:
                    Collections.sort(danhSachDiem);
                    System.out.println("Đã sắp xếp tăng dần: " + danhSachDiem);
                    break;

                case 7:
                    int gioiXuatSac = 0;
                    for (double d : danhSachDiem) {
                        if (d >= 8) gioiXuatSac++; // Giỏi/Xuất sắc khi điểm >= 8
                    }
                    System.out.println("Số lượng sinh viên Giỏi và Xuất sắc: " + gioiXuatSac);
                    break;

                case 8:
                    System.out.println("Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 8);

        sc.close();
    }
}