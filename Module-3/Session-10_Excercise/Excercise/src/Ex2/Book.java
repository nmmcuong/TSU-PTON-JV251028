package Ex2;

class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Tên sách: " + title + ", Tác giả: " + author + ", Năm xuất bản: " + year;
    }
}