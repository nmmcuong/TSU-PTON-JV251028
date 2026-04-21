package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import service.CustomerService;
import config.Jdbc;
public class Main{
	public static void main(String[] args) throws SQLException {
		try (Connection conn = Jdbc.getConnection()) {
			if (conn != null) {
				System.out.println("Connect Successfull!");
				System.out.println("Database: " + conn.getCatalog());
			}
		}catch (Exception e) {
			System.err.println("Connection failed!");
			e.printStackTrace();
		}
		CustomerService cusservice = new CustomerService();
		Scanner sc = new Scanner(System.in);
		while (true) {
            System.out.println("\n--- QUẢN LÝ ĐƠN HÀNG ---");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem danh sách đơn hàng");
            System.out.println("5. Tính tổng tiền đơn hàng");
            System.out.println("6. Xóa đơn hàng");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch(choice) {
            case 1:
            	System.out.println("Nhap ten khach:");
            	cusservice.addCustomer(sc.nextLine());
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
            	System.out.println("Lựa chọn không hợp lệ.");
            }
		}
	}
}