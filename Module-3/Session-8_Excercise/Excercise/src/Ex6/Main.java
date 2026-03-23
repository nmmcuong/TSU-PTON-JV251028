package Ex6;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== HỆ THỐNG QUẢN LÝ SÁCH =====");
            System.out.println("1. Thêm quyển sách mới");
            System.out.println("2. Hiển thị tất cả sách");
            System.out.println("3. Xóa sách theo mã ISBN");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tiêu đề: "); String title = sc.nextLine();
                    System.out.print("Nhập tác giả: "); String author = sc.nextLine();
                    System.out.print("Nhập mã ISBN: "); String isbn = sc.nextLine();
                    System.out.print("Nhập năm xuất bản: "); int year = Integer.parseInt(sc.nextLine());
                    manager.addBook(new Book(title, author, isbn, year));
                    break;
                case 2:
                    manager.displayBooks();
                    break;
                case 3:
                    System.out.print("Nhập mã ISBN cần xóa: ");
                    String isbnToDelete = sc.nextLine();
                    manager.removeBook(isbnToDelete);
                    break;
                case 4:
                    System.out.println("Chương trình kết thúc. Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
