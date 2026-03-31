package Ex8;

import java.util.*;

public class LibraryManagement {
    public static void main(String[] args) {
        // Sử dụng Set để đảm bảo không trùng ID
        Set<Book> library = new HashSet<>();

        // 1. Thêm sách vào bộ sưu tập
        library.add(new Book("B01", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 1941));
        library.add(new Book("B02", "Lão Hạc", "Nam Cao", 1943));
        library.add(new Book("B03", "Số Đỏ", "Vũ Trọng Phụng", 1936));
        library.add(new Book("B04", "Tắt Đèn", "Ngô Tất Tố", 1937));
        library.add(new Book("B01", "Trùng ID", "Unknown", 2024)); // Sẽ bị HashSet loại bỏ

        System.out.println("--- Danh sách gốc trong thư viện (HashSet): ---");
        library.forEach(System.out::println);

        // 2. Lọc sách xuất bản sau một năm nhất định (ví dụ: sau năm 1940)
        int targetYear = 1940;
        List<Book> filteredList = new ArrayList<>();
        for (Book b : library) {
            if (b.getYear() > targetYear) {
                filteredList.add(b);
            }
        }

        // 3. Sắp xếp các sách đã lọc theo tên bằng Collections.sort
        Collections.sort(filteredList, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });

        // Cách viết ngắn gọn bằng Lambda (Java 8+):
        // filteredList.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        // 4. In kết quả cuối cùng
        System.out.println("\n--- Sách xuất bản sau năm " + targetYear + " (Sắp xếp theo tên): ---");
        if (filteredList.isEmpty()) {
            System.out.println("Không có sách nào thỏa mãn.");
        } else {
            for (Book b : filteredList) {
                System.out.println(b);
            }
        }
    }
}