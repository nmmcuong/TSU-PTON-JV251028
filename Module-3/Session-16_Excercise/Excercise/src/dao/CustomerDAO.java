package dao;

import config.Jdbc;
import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO{
	
	public void insertCus(Connection conn, String name) throws SQLException {
        String sql = "INSERT INTO customer (name) VALUES (?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }
	
	public List<Customer> findAll(Connection conn) throws SQLException {
        List<Customer> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(new Customer());
        }
        return list;
    }

	
}