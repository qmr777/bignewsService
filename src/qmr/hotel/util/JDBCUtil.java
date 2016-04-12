package qmr.hotel.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	
	public static String driver = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://127.0.0.1:3306/hotel";
	private static String username = "root";
	private static String password = "root";
	
	public static Connection connection(){	
		Connection connection = null;
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}
}
