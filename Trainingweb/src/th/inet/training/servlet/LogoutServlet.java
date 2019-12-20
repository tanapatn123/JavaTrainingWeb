package th.inet.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String LOGOUT_URL = "index.jsp";
	public static final String PARAM_REQUEST_LOGOUT_MSG = "logout_msg"; 
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doLogout(request, response, "Logout successful");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doLogout(request, response, "Logout successful");
	}

	public static void doLogout (HttpServletRequest request, HttpServletResponse response, String logoutMsg) throws ServletException, IOException {
		request.getSession().removeAttribute(LoginServlet.SESSION_USER_OBJECT);
		request.setAttribute(PARAM_REQUEST_LOGOUT_MSG, logoutMsg);
		request.getRequestDispatcher(LOGOUT_URL).forward(request, response);
	}
	
}