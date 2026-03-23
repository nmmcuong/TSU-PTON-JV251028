package Ex2;


public class Book {
    // Các thuộc tính private để đảm bảo tính bao đóng
    private String title;
    private String author;
    private double price;

    // --- Phương thức Getter và Setter cho title ---
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // --- Phương thức Getter và Setter cho author ---
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // --- Phương thức Getter và Setter cho price ---
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // Kiểm tra điều kiện: giá không được âm
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Lỗi: Giá sách không được nhỏ hơn 0!");
        }
    }
}
