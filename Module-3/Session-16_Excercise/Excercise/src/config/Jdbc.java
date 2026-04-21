package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc{
	public static Connection getConnection() throws SQLException {
	    return DriverManager.getConnection(
	    		"jdbc:mysql://localhost:3306/Orde"
	    		+ "Management"
	    		, "root"
	    		, "123456");
	}

}