package dao;

import entity.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    // 5.3: Thêm đơn hàng và lấy ID vừa tạo
    public int insertOrder(Connection conn, int customerId) throws SQLException {
        String sql = "INSERT INTO orders (customer_id) VALUES (?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, customerId);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    // 5.4: Lấy danh sách đơn hàng kèm tên khách hàng
    public List<Orders> findAll(Connection conn) throws SQLException {
        String sql = "SELECT o.*, c.name FROM orders o JOIN customer c ON o.customer_id = c.id";
        List<Orders> orders = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Orders o = new Orders();
                o.setId(rs.getInt("id"));
                o.setCustomerName(rs.getString("name"));
                o.setCreatedAt(rs.getTimestamp("created_at").toString());
                orders.add(o);
            }
        }
        return orders;
    }

    // 5.6: Xóa đơn hàng
    public void delete(Connection conn, int orderId) throws SQLException {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ps.executeUpdate();
        }
    }
}