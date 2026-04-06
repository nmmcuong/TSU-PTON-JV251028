package Ex5;

import java.sql.*;

import database5.DBConnection;

public class MovieManagement {
    public void addMovie(String title, String director, int year) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{call add_movie(?,?,?)}")) {
            cs.setString(1, title);
            cs.setString(2, director);
            cs.setInt(3, year);
            cs.executeUpdate();
            System.out.println("Thêm phim thành công!");
        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }

    public void listMovies() {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{call list_movies()}");
             ResultSet rs = cs.executeQuery()) {
            System.out.println("\n--- DANH SÁCH PHIM ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Phim: %-20s | Đạo diễn: %-15s | Năm: %d\n",
                        rs.getInt("id"), rs.getString("title"), rs.getString("director"), rs.getInt("release_year"));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }

    public void updateMovie(int id, String title, String director, int year) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{call update_movie(?,?,?,?)}")) {
            cs.setInt(1, id);
            cs.setString(2, title);
            cs.setString(3, director);
            cs.setInt(4, year);
            int row = cs.executeUpdate();
            if (row > 0) System.out.println("Cập nhật thành công!");
        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }

    public void deleteMovie(int id) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{call delete_movie(?)}")) {
            cs.setInt(1, id);
            cs.executeUpdate();
            System.out.println("Xóa thành công!");
        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
