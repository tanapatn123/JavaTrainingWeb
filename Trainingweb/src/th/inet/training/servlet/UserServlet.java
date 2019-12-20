package th.inet.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import jdk.nashorn.internal.ir.RuntimeNode.Request;
import th.inet.training.object.UserDB;
import th.inet.training.object.DAO.UserDAO;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8517281490814342741L;
	public static final String PARAM_USER_ID = "userID" ;
	public static final String PARAM_USER_NAME = "userName";
	public static final String PARAM_USER_ADDRESS = "userAddress";
	public static final String PARAM_USER_TEL = "userTel";
	public static final String PARAM_USER_USERNAME = "username";
	public static final String PARAM_USER_PASSWORD = "password";
	
	public static final String PARAM_USER_ACTION = "action";
	
	public static final String PARAM_ADD = "add";
	public static final String PARAM_EDIT = "edit";
	public static final String PARAM_REMOVE = "remove";
	
	
	
	
	public UserServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		super.doGet(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uId = req.getParameter(PARAM_USER_ID);
		String uName = req.getParameter(PARAM_USER_NAME);
		String uAddress = req.getParameter(PARAM_USER_ADDRESS);
		String uTel = req.getParameter(PARAM_USER_TEL);
		String username = req.getParameter(PARAM_USER_USERNAME);
		String password = req.getParameter(PARAM_USER_PASSWORD);
		String action = req.getParameter(PARAM_USER_ACTION);
		
		
		UserDB userDB = new UserDB();
		UserDAO userDAO = new UserDAO();
		
		switch(action) {
			case PARAM_ADD :
				userDB.setuName(uName);
				userDB.setuAddress(uAddress);
				userDB.setuTe(uTel);
				userDB.setUsername(username);
				userDB.setPassword(password);
				boolean checkAdd = userDAO.insertUser(userDB);
				if(checkAdd) {
					System.out.println("Add Complete");
				} else {
					System.out.println("Add Fail !!!");
					req.getSession().removeAttribute(PARAM_USER_NAME);
					//req.getRequestDispatcher("bootstrap.jsp").forward(req,resp);			
				}
				req.getSession().removeAttribute(PARAM_USER_NAME);
				req.getRequestDispatcher("dashboard.jsp").forward(req,resp);	
				break;
			
			case PARAM_EDIT :
				userDB.setuID(Integer.parseInt(uId));
				userDB.setuName(uName);
				userDB.setuAddress(uAddress);
				userDB.setuTe(uTel);
				userDB.setUsername(username);
				userDB.setPassword(password);
				boolean checkEdit = userDAO.updateUser(userDB);
				if(checkEdit) {
					System.out.println("Edit Complete");
				} 
				req.getSession().removeAttribute(PARAM_USER_NAME);
				req.getRequestDispatcher("dashboard.jsp").forward(req,resp);	
				break;
				
			case PARAM_REMOVE :
				int userRemove = Integer.parseInt(uId);
				boolean checkRemove = userDAO.deleteUser(userRemove);
				if(checkRemove) {
					System.out.println("Remove Complete");
				} 
				req.getSession().removeAttribute(PARAM_USER_NAME);
				req.getRequestDispatcher("dashboard.jsp").forward(req,resp);	
				break;
			default :
				System.err.println("ERROR Complete XXXXX");
				break;
			
		}
		
					
                
	}
}
