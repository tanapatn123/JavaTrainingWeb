package th.inet.training.servlet;

import java.io.IOException;
import th.inet.training.object.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;

import th.inet.training.object.UserDB;
import th.inet.training.object.DAO.UserDAO;

@WebServlet("/loginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String PARAM_USERNAME = "username";
	public static final String PARAM_PASSWORD = "password";
	public static final String PARAM_TOKEN = "token";

	public static final String DASHBOARD_URL = "dashboard.jsp";;

	public static final String SESSION_FORM_TOKEN = "formSession";
	public static final String SESSION_USER_OBJECT = "userObject";
	
	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tokenSession = (String) request.getSession().getAttribute(LoginServlet.SESSION_FORM_TOKEN);
		String username = request.getParameter(PARAM_USERNAME);
		String password = request.getParameter(PARAM_PASSWORD);
		String token = request.getParameter(PARAM_TOKEN);
			
		System.out.println("tokenSession : " + tokenSession);
		System.out.println("token : " + token);
		
		if(tokenSession == null){
			LogoutServlet.doLogout(request, response, "Session time out,please login again");
			System.out.println("token null");
			return;
		}
		
		if (!tokenSession.equals(token)) {
			request.getSession().removeAttribute(LoginServlet.SESSION_FORM_TOKEN);
			LogoutServlet.doLogout(request, response, "Session Invalid,please login again");
			System.out.println("token invalid");
			return;
		} else {
			request.getSession().removeAttribute(LoginServlet.SESSION_FORM_TOKEN);		
			System.out.println("token check success");
		}
		
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			System.out.println("username or password null");
			LogoutServlet.doLogout(request, response, "Username or Password Invalid!!");
		}
		
		UserDB checkLogin = new UserDAO().getUser(username, password);
		System.out.println(checkLogin);
		if(checkLogin.getuID() > 0) {
			System.out.println("Login Success!");
			
			request.getSession().setAttribute(SESSION_USER_OBJECT, checkLogin);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}else {
			System.out.println("in else");
			LogoutServlet.doLogout(request, response, "Username or Password Invalid!!");
		}
			
	}		
}