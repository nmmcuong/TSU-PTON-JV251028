package database5;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Thay đổi user và password theo máy của bạn
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
