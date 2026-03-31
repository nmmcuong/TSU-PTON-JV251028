package Ex8;

import java.util.Objects;

class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getYear() { return year; }

    // Ghi đè equals để so sánh dựa trên ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    // Ghi đè hashCode để đảm bảo tính nhất quán với equals
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("ID: %-5s | Tên: %-20s | TG: %-15s | Năm: %d", 
                              id, title, author, year);
    }
}