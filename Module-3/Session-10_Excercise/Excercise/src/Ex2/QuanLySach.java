package Ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Book> listBooks = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n***************** MENU QUẢN LÝ SÁCH *****************");
            System.out.println("1. Thêm sách");
            System.out.println("2. Tìm kiếm sách");
            System.out.println("3. Hiển thị danh sách sách");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn:\n");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: addBook(); break;
                    case 2: searchBook(); break;
                    case 3: showAllBooks(); break;
                    case 4: System.out.println("Tạm biệt!"); break;
                    default: System.out.println("Vui lòng chọn từ 1 đến 4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số để chọn menu!");
            }
        } while (choice != 4);
    }

    // Chức năng 1: Thêm mới
    private static void addBook() {
        String title, author;
        int year;

        // Nhập tên sách
        while (true) {
            System.out.println("Nhập tên sách:");
            title = sc.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Vui lòng ko để trống !");
                continue;
            }
            break;
        }

        // Nhập tác giả
        System.out.println("Nhập tác giả:");
        author = sc.nextLine().trim();

        // Nhập năm xuất bản với try-catch
        while (true) {
            System.out.println("Nhập năm xuất bản:");
            try {
                year = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập năm là một số nguyên!");
            }
        }

        listBooks.add(new Book(title, author, year));
        System.out.println("Sách đã được thêm thành công.");
    }

    // Chức năng 2: Tìm kiếm theo tên
    private static void searchBook() {
        System.out.print("Nhập tên sách để tìm kiếm: ");
        String keyword = sc.nextLine().trim();
        boolean found = false;

        for (Book b : listBooks) {
            // Tìm kiếm không phân biệt hoa thường
            if (b.getTitle().equalsIgnoreCase(keyword)) {
                System.out.println("Thông tin sách tìm thấy: " + b);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách có tên: " + keyword);
        }
    }

    // Chức năng 3: Hiển thị danh sách
    private static void showAllBooks() {
        if (listBooks.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            System.out.println("\nDanh sách sách:");
            for (Book b : listBooks) {
                System.out.println(b);
            }
        }
    }
}