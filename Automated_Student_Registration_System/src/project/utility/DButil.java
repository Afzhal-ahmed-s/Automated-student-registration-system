package project.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/automatedStudentRegistration";
		
		try {
			conn = DriverManager.getConnection(url, "root", "netflix123");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}

}
