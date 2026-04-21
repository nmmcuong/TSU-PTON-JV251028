package Ex7;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private Connection getConnection() throws SQLException {
        // Thay đổi user/pass theo máy của bạn
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "123456");
    }

    // 1. Thêm sách
    public void addBook(Book book) {
        String checkSql = "SELECT COUNT(*) FROM Book WHERE title = ? AND author = ?";
        String insertSql = "INSERT INTO Book (title, author, published_year, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection()) {
            // Kiểm tra tồn tại
            PreparedStatement checkSt = conn.prepareStatement(checkSql);
            checkSt.setString(1, book.getTitle());
            checkSt.setString(2, book.getAuthor());
            ResultSet rs = checkSt.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.err.println("Lỗi: Sách này đã tồn tại (trùng tên và tác giả)!");
                return;
            }

            // Thêm mới
            PreparedStatement insertSt = conn.prepareStatement(insertSql);
            insertSt.setString(1, book.getTitle());
            insertSt.setString(2, book.getAuthor());
            insertSt.setInt(3, book.getPublishedYear());
            insertSt.setDouble(4, book.getPrice());
            insertSt.executeUpdate();
            System.out.println("Thêm sách thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. Cập nhật sách
    public void updateBook(int id, Book book) {
        String updateSql = "UPDATE Book SET title=?, author=?, published_year=?, price=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(updateSql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublishedYear());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, id);
            
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Cập nhật thành công!");
            else System.err.println("Không tìm thấy sách có ID: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Xóa sách
    public void deleteBook(int id) {
        String deleteSql = "DELETE FROM Book WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(deleteSql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Xóa thành công!");
            else System.err.println("Không tìm thấy sách có ID: " + id + " để xóa.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. Tìm kiếm theo tác giả
    public void findBooksByAuthor(String author) {
        String sql = "SELECT * FROM Book WHERE author LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + author + "%");
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                System.out.println(new Book(rs.getString("title"), rs.getString("author"), 
                                   rs.getInt("published_year"), rs.getDouble("price")));
                found = true;
            }
            if (!found) System.out.println("Không tìm thấy sách của tác giả: " + author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5. Hiển thị tất cả
    public void listAllBooks() {
        String sql = "SELECT * FROM Book";
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Book b = new Book(rs.getString("title"), rs.getString("author"), 
                                  rs.getInt("published_year"), rs.getDouble("price"));
                b.setId(rs.getInt("id"));
                System.out.println(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
