package th.inet.training.object.DAO;

//import java.sql.SQLException;
//
//import com.mysql.jdbc.Connection;
//import java.sql.PreparedStatement;
//import com.mysql.jdbc.ResultSet;
//import com.mysql.jdbc.Statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import th.inet.training.object.UserDB;
import training.ConnectDB;


public class UserDAO {
	
	ConnectDB connect = new ConnectDB();
	
	Connection conn = connect.connect();	
	
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	

	public boolean insertUser(UserDB user) {
		
		String sqlInsertUser = "INSERT INTO user VALUES (NULL,?,?,?,?,?)";
		boolean checkInsert = false;
		
		try {
			pst = conn.prepareStatement(sqlInsertUser);
			
			//-----------------------------------------------
			pst.setString(1, user.getuName());
			pst.setString(2, user.getuAddress());
			pst.setString(3, user.getuTe());
			pst.setString(4, user.getUsername());
			pst.setString(5, user.getPassword());
			//------------------------------------------------
			
			int count = pst.executeUpdate();
			
			if (count > 0) {
				System.out.println("Insert Complete");
				conn.close();
				checkInsert = true;
			} else {
				System.out.println("Insert Fail !!");
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return checkInsert;
	
	}
//	à¾ÔèÁ
//public static void main(String[] args) {
//	UserDAO userDAO = new UserDAO();
//	UserDB userDB = new UserDB();
//	userDB.setuName("tanapat");
//	userDB.setuAddress("INET TH HDY");
//	userDB.setuTe("08884575");
//	boolean check = userDAO.insertUser(userDB);
//	
//	System.out.println(check);
//	
//}


public boolean updateUser(UserDB user) {
	
	String sqlUpdateUser = "UPDATE user SET uName = ?, uAddress = ?, uTel = ? WHERE uID = ?";
	boolean checkUpdate = false;
	
	try {
		pst = conn.prepareStatement(sqlUpdateUser);
		
		pst.setString(1, user.getuName());
		pst.setString(2, user.getuAddress());
		pst.setString(3, user.getuTe());
		pst.setInt(4, user.getuID());
		
		int count = pst.executeUpdate();
		
		if (count > 0) {
			System.out.println("Update Complete");
			conn.close();
			checkUpdate = true;
		} else {
			System.out.println("Update Fail !!");
			conn.close();
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return checkUpdate;
}
// ÍÑ¾à´·
//public static void main(String[] args) {
//	UserDAO userDAO = new UserDAO();
//	UserDB userDB = new UserDB();
//	
//	
//	userDB.setuName("¸¹ÀÑ·Ã");
//	userDB.setuAddress("INET TH HDY");
//	userDB.setuTe("555555556");
//	userDB.setuID(6);
//	boolean check = userDAO.updateUser(userDB);
//	
//	System.out.println(check);
//	
//}

public boolean deleteUser(int userID) {
	
	String sqlDeleteUser = "DELETE FROM user WHERE uID = ?";
	boolean checkDelete = false;
	
	try {
		pst = conn.prepareStatement(sqlDeleteUser);
		
		pst.setInt(1, userID);
		
		int count = pst.executeUpdate();
		
		if (count > 0) {
			System.out.println("Delete Complete");
			conn.close();
			checkDelete = true;
		} else {
			System.out.println("Delete Fail !!");
			conn.close();
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return checkDelete;
}
//Åº
//public static void main(String[] args) {
//UserDAO userDAO = new UserDAO();
//
//boolean check = userDAO.deleteUser(5);
//
//System.out.println(check);
//
//}

public List<UserDB> listUser() {
	
	String sqlListAll = "SELECT * FROM user";
	List<UserDB> userList = new ArrayList<UserDB>();
	
	try {
		pst = conn.prepareStatement(sqlListAll);
		rs = pst.executeQuery();
		while (rs.next()) {
			UserDB user = new UserDB();
			user.setuID(rs.getInt("uID"));
			user.setuName(rs.getString("uName"));
			user.setuAddress(rs.getString("uAddress"));
			user.setuTe(rs.getString("uTel"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			userList.add(user);
		}
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return userList;
}
//public static void main(String[] args) {
//	UserDAO userDAO = new UserDAO();
//	List<UserDB> userList = userDAO.listUser();
//	int id=0;
//	
//	for (UserDB userDB2 : userList) {
//		System.out.println("------------ROW : " + ++id + " -------------"); // id = id + 1  ||  id +1 = id
//		System.out.println("ID : " + userDB2.getuID());
//		System.out.println("Name : " + userDB2.getuName());
//		System.out.println("Address : " + userDB2.getuAddress());
//		System.out.println("Tel : " + userDB2.getuTe());
//		System.out.println("Username : " + userDB2.getUsername());
//		System.out.println("Password : " + userDB2.getPassword());
//		
//	}
//}


public UserDB getUser(String username, String password) {
	  String sqlGetuser = "SELECT * FROM user WHERE username = ? "
	    + "AND password = ?";
	  UserDB userObj = new UserDB();
	  try {
	   pst = conn.prepareStatement(sqlGetuser);
	   pst.setString(1, username);
	   pst.setString(2, password);
	   rs = pst.executeQuery();
	   while(rs.next()) {
		   userObj.setuID(rs.getInt("uID"));
		   	userObj.setuName(rs.getString("uName"));
			userObj.setuAddress(rs.getString("uAddress"));
			userObj.setuTe(rs.getString("uTel"));
			userObj.setUsername(rs.getString("username"));
		   	userObj.setPassword(rs.getString("password"));
	    
	   }
	  }catch (SQLException e) {
		e.printStackTrace();
	  }
	return userObj;
	  
	 }



//public static void main(String[] args) {
//	UserDAO userDAO = new UserDAO();
//	UserDB userlist = userDAO.getUser("user2", "222");
//	  System.out.println(userlist);
//	  
//	  System.out.println("ID: " + userlist.getuID());
//      System.out.println("Name: " + userlist.getuName());
//      System.out.println("Address: " + userlist.getuAddress());
//      System.out.println("Tel: " + userlist.getuTe());
//      System.out.println("Username: " + userlist.getUsername());
//      System.out.println("Password: " + userlist.getPassword());
//}



}

