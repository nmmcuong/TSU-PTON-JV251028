package Ex7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- QUẢN LÝ THƯ VIỆN ---");
            System.out.println("1. Thêm sách\n2. Cập nhật\n3. Xóa\n4. Tìm theo tác giả\n5. Hiển thị tất cả\n6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Tiêu đề: "); String t = sc.nextLine();
                    System.out.print("Tác giả: "); String a = sc.nextLine();
                    System.out.print("Năm: "); int y = Integer.parseInt(sc.nextLine());
                    System.out.print("Giá: "); double p = Double.parseDouble(sc.nextLine());
                    manager.addBook(new Book(t, a, y, p));
                    break;
                case 2:
                    System.out.print("ID cần sửa: "); int idU = Integer.parseInt(sc.nextLine());
                    System.out.print("Tiêu đề mới: "); String tU = sc.nextLine();
                    System.out.print("Tác giả mới: "); String aU = sc.nextLine();
                    System.out.print("Năm mới: "); int yU = Integer.parseInt(sc.nextLine());
                    System.out.print("Giá mới: "); double pU = Double.parseDouble(sc.nextLine());
                    manager.updateBook(idU, new Book(tU, aU, yU, pU));
                    break;
                case 3:
                    System.out.print("ID cần xóa: ");
                    manager.deleteBook(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Nhập tên tác giả: ");
                    manager.findBooksByAuthor(sc.nextLine());
                    break;
                case 5:
                    manager.listAllBooks();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
