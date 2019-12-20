package training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
	
	public static void main(String[] args) {
		ConnectDB con = new ConnectDB();
		con.connect();
	}

public Connection connect() {
	Connection conn = null;
	String driver = "com.mysql.jdbc.Driver";
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection("jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=UTF-8", "root", "");
		if(conn != null) {
			System.out.println("Connect Database Complete");
		} else {
			System.out.println("Connect Fail !!!");
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	return conn;

	}


}
