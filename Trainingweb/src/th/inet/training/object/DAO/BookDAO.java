package th.inet.training.object.DAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import th.inet.training.object.BookDB;
import training.ConnectDB;



public class BookDAO {

	
	ConnectDB connect = new ConnectDB();
	
	Connection conn = connect.connect();	
	
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	

	public boolean insertUser(BookDB user) {
		
		String sqlInsertUser = "INSERT INTO book VALUES (NULL,?,?,?)";
		boolean checkInsert = false;
		
		try {
			pst = conn.prepareStatement(sqlInsertUser);
			
			//-----------------------------------------------
			pst.setString(1, user.getName());
			pst.setString(2, user.getAuthor());
			pst.setInt(3, user.getPrice());
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
//	BookDAO bookDAO = new BookDAO();
//	BookDB bookDB = new BookDB();
//	bookDB.setName("tanapat");
//	bookDB.setAuthor("INET TH HDY");
//	bookDB.setPrice(99);
//	boolean check = bookDAO.insertUser(bookDB);
//	
//	System.out.println(check);
//	
//}


public boolean updateUser(BookDB user) {
	
	String sqlUpdateUser = "UPDATE book SET name = ?, author = ?, price = ? WHERE id = ?";
	boolean checkUpdate = false;
	
	try {
		pst = conn.prepareStatement(sqlUpdateUser);
		
		pst.setString(1, user.getName());
		pst.setString(2, user.getAuthor());
		pst.setInt(3, user.getPrice());
		pst.setInt(4, user.getId());
		
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
//	BookDAO bookDAO = new BookDAO();
//	BookDB bookDB = new BookDB();
//	
//	
//	bookDB.setName("¸¹ÀÑ·Ã");
//	bookDB.setAuthor("INET TH HDY");
//	bookDB.setPrice(55);
//	bookDB.setId(1);
//	boolean check = bookDAO.updateUser(bookDB);
//	
//	System.out.println(check);
//	
//}

public boolean deleteUser(int bookID) {
	
	String sqlDeleteUser = "DELETE FROM book WHERE id = ?";
	boolean checkDelete = false;
	
	try {
		pst = conn.prepareStatement(sqlDeleteUser);
		
		pst.setInt(1, bookID);
		
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

public List<BookDB>listUser() {
	
	String sqlListAll = "SELECT * FROM book";
	List<BookDB> userList = new ArrayList<BookDB>();
	
	try {
		pst = conn.prepareStatement(sqlListAll);
		rs = pst.executeQuery();
		while (rs.next()) {
			BookDB user = new BookDB();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAuthor(rs.getString("author"));
			user.setPrice(rs.getInt("price"));
			userList.add(user);
		}
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return userList;
}
//public static void main(String[] args) {
//	BookDAO bookDAO = new BookDAO();
//	List<BookDB> userList = bookDAO.listUser();
//	int id=0;
//	
//	for (BookDB userDB2 : userList) {
//		System.out.println("------------ROW : " + ++id + " -------------"); // id = id + 1  ||  id +1 = id
//		System.out.println("ID : " + userDB2.getId());
//		System.out.println("Name : " + userDB2.getName());
//		System.out.println("Author : " + userDB2.getAuthor());
//		System.out.println("Price : " + userDB2.getPrice());
//		
//	}
//}




	
}
