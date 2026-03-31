package Ex5;

import java.util.Scanner;


public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static InvoiceManager manager = new InvoiceManager();

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n***************** MENU QUẢN LÝ HÓA ĐƠN *****************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: handleAdd(); break;
                    case 2: handleUpdate(); break;
                    case 3: handleDelete(); break;
                    case 4: manager.display(); break;
                    case 5: break;
                    default: System.out.println("Vui lòng chọn 1-5!");
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        } while (choice != 5);
    }

    private static String inputMaHD(String msg) {
        while (true) {
            System.out.println(msg);
            String ma = sc.nextLine().trim();
            if (ma.isEmpty()) {
                System.out.println("Vui lòng ko để trống !");
                continue;
            }
            return ma;
        }
    }

    private static double inputSoTien(String msg) {
        while (true) {
            System.out.println(msg);
            try {
                double tien = Double.parseDouble(sc.nextLine());
                if (tien < 0) {
                    System.out.println("Vui lòng nhập số thực >= 0 !");
                    continue;
                }
                return tien;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số thực hợp lệ!");
            }
        }
    }

    private static void handleAdd() {
        String ma = inputMaHD("Nhập mã hóa đơn:");
        double tien = inputSoTien("Nhập số tiền:");
        manager.add(new Invoice(ma, tien));
    }

    private static void handleUpdate() {
        manager.display();
        System.out.print("Nhập id hóa đơn cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        String ma = inputMaHD("Nhập mã hóa đơn mới:");
        double tien = inputSoTien("Nhập số tiền mới:");
        manager.update(id, new Invoice(ma, tien));
    }

    private static void handleDelete() {
        manager.display();
        System.out.print("Nhập id hóa đơn cần xóa: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            manager.delete(id);
        } catch (Exception e) {
            System.out.println("ID không hợp lệ!");
        }
    }
}