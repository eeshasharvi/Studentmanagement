package dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;

public class studentdb {
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/student";
	private static String username="root";
	private static String password="root@123";
	private static Connection conn;
	
	public static Connection getconnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
			

}
