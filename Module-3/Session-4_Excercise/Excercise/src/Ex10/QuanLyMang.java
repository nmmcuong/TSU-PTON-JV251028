package Ex10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyMang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> danhSach = new ArrayList<>();
        int luaChon;

        while (true) {
            System.out.println("\n----- QUẢN LÝ MẢNG SỐ NGUYÊN -----");
            System.out.println("1. Thêm phần tử vào mảng");
            System.out.println("2. Xóa phần tử theo chỉ số (index)");
            System.out.println("3. Hiển thị mảng");
            System.out.println("4. Sắp xếp mảng giảm dần");
            System.out.println("5. Tìm kiếm phần tử");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số nguyên cần thêm: ");
                    int giaTri = sc.nextInt();
                    danhSach.add(giaTri);
                    System.out.println("Đã thêm thành công.");
                    break;

                case 2:
                    System.out.print("Nhập chỉ số (index) cần xóa: ");
                    int index = sc.nextInt();
                    if (index >= 0 && index < danhSach.size()) {
                        danhSach.remove(index);
                        System.out.println("Đã xóa phần tử tại vị trí " + index);
                    } else {
                        System.out.println("Chỉ số không hợp lệ!");
                    }
                    break;

                case 3:
                    System.out.println("Mảng hiện tại: " + danhSach);
                    break;

                case 4:
                    // Sắp xếp giảm dần
                    Collections.sort(danhSach, Collections.reverseOrder());
                    System.out.println("Đã sắp xếp giảm dần: " + danhSach);
                    break;

                case 5:
                    System.out.print("Nhập số cần tìm: ");
                    int soTim = sc.nextInt();
                    if (danhSach.contains(soTim)) {
                        System.out.println("Tìm thấy số " + soTim + " tại vị trí (đầu tiên): " + danhSach.indexOf(soTim));
                    } else {
                        System.out.println("Không tìm thấy số " + soTim + " trong mảng.");
                    }
                    break;

                case 6:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}