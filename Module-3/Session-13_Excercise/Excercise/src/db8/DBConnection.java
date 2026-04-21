package db8;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Thay đổi user/pass theo cấu hình máy bạn
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_db", "root", "123456");
        } catch (Exception e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
            return null;
        }
    }
}
