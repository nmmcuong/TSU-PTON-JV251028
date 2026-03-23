package Ex6;
public class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    // Trả về thông tin chi tiết của sách
    public String getDetails() {
        return String.format("Tiêu đề: %-20s | Tác giả: %-15s | ISBN: %-10s | Năm: %d", 
                             title, author, isbn, year);
    }

    // Trả về mã ISBN
    public String getIsbn() {
        return isbn;
    }
}
