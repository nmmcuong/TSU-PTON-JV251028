package Ex6;
import java.util.ArrayList;
import java.util.List;

public class BookManager implements IBookManager {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Đã thêm sách thành công!");
    }

    @Override
    public void removeBook(String isbn) {
        boolean removed = books.removeIf(b -> b.getIsbn().equals(isbn));
        if (removed) {
            System.out.println("Đã xóa sách có mã ISBN: " + isbn);
        } else {
            System.out.println("Không tìm thấy sách với mã ISBN này.");
        }
    }

    @Override
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách hiện đang trống.");
        } else {
            System.out.println("\n--- DANH SÁCH QUYỂN SÁCH ---");
            for (Book b : books) {
                System.out.println(b.getDetails());
            }
        }
    }
}
