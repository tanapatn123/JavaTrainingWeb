package th.inet.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UtilityServlet
 */
@WebServlet("/UtilityServlet")
public class UtilityServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String LOGOUT_URL = "index.jsp";
	
	public static final String PARAM_PAGE = "reqp";
	public static final String PARAM_PAGE_USER = "user";
	public static final String PAGE_DASHBOARD = "dashboard";
	public static final String PARAM_PAGE_PRODUCT = "product";
	
	public static final String PARAM_ACTION = "reqa";	
	public static final String ACECPT_RULE = "1";

    public UtilityServlet() {
        super();
        
    }

    public static final String getRequestScopeObject (HttpServletRequest request, String parameter) {
    	
    	String reqObject = "";	
    	Object reqAttrObj = request.getAttribute(parameter);
    	if (reqAttrObj != null && reqAttrObj instanceof String) {
    		reqObject = (String) reqAttrObj;
    		request.getSession().removeAttribute(parameter);
    	} else {
    		reqObject = request.getParameter(parameter);
    		reqObject = (reqObject==null)?"":reqObject;
    	}
    	
    	return reqObject;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("hi");
		String accept_rule = (String)request.getParameter("accept_rule");
		request.getSession().setAttribute("AcceptRule", accept_rule);
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

}