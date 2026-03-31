package Ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySinhVien {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<SinhVien> danhSach = new ArrayList<>();
        String tiepTuc;

        do {
            String ten = nhapTen();
            int tuoi = nhapTuoi();
            double diem = nhapDiem();

            danhSach.add(new SinhVien(ten, tuoi, diem));

            System.out.print("Bạn có muốn thêm sinh viên khác? (y/n): ");
            tiepTuc = sc.nextLine();
        } while (tiepTuc.equalsIgnoreCase("y"));

        System.out.println("\nDanh sách sinh viên:");
        for (SinhVien sv : danhSach) {
            System.out.println(sv);
        }
    }

    // Hàm nhập tên và kiểm tra trống
    private static String nhapTen() {
        while (true) {
            System.out.println("Nhập tên sinh viên:");
            String ten = sc.nextLine().trim();
            if (ten.isEmpty()) {
                System.out.println("Vui lòng ko để trống !");
                continue;
            }
            return ten;
        }
    }

    // Hàm nhập tuổi với try-catch
    private static int nhapTuoi() {
        while (true) {
            System.out.println("Nhập tuổi sinh viên:");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Vui lòng ko bỏ trống !");
                continue;
            }
            try {
                int tuoi = Integer.parseInt(input);
                if (tuoi < 0) throw new Exception();
                return tuoi;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên >= 0 !");
            }
        }
    }

    // Hàm nhập điểm với try-catch
    private static double nhapDiem() {
        while (true) {
            System.out.println("Nhập điểm trung bình sinh viên:");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Vui lòng ko bỏ trống !");
                continue;
            }
            try {
                double diem = Double.parseDouble(input);
                if (diem < 0) throw new Exception();
                return diem;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số thực >= 0 !");
            }
        }
    }
}