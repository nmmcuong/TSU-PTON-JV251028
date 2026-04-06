package Ex5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieManagement manager = new MovieManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- QUẢN LÝ PHIM ---");
            System.out.println("1. Thêm phim\n2. Liệt kê phim\n3. Sửa phim\n4. Xóa phim\n5. Thoát");
            System.out.print("Chọn: ");
            
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Tiêu đề: "); String t = sc.nextLine();
                        System.out.print("Đạo diễn: "); String d = sc.nextLine();
                        System.out.print("Năm phát hành: "); int y = Integer.parseInt(sc.nextLine());
                        if(t.isEmpty()) throw new Exception("Tên phim không được để trống!");
                        manager.addMovie(t, d, y);
                        break;
                    case 2:
                        manager.listMovies();
                        break;
                    case 3:
                        System.out.print("Nhập ID cần sửa: "); int idU = Integer.parseInt(sc.nextLine());
                        System.out.print("Tiêu đề mới: "); String tU = sc.nextLine();
                        System.out.print("Đạo diễn mới: "); String dU = sc.nextLine();
                        System.out.print("Năm mới: "); int yU = Integer.parseInt(sc.nextLine());
                        manager.updateMovie(idU, tU, dU, yU);
                        break;
                    case 4:
                        System.out.print("Nhập ID cần xóa: "); int idD = Integer.parseInt(sc.nextLine());
                        manager.deleteMovie(idD);
                        break;
                    case 5:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Dữ liệu nhập vào không hợp lệ: " + e.getMessage());
            }
        }
    }
}
