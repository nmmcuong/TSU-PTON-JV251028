package service;

import dao.CustomerDAO;
import java.sql.*;

import config.Jdbc;

public class CustomerService{
	private final CustomerDAO customerDAO = new CustomerDAO();
	
	public void addCustomer(String ten) throws SQLException {
		if (ten == null || ten.trim().isEmpty()) {
			System.out.println("Lỗi: Tên khách hàng không được để trống!");
			return;
		}
		try (Connection conn = Jdbc.getConnection()) {
            customerDAO.insertCus(conn, ten);
        } catch (SQLException e) 
		{ e.printStackTrace(); }
		
		
		
	}
}