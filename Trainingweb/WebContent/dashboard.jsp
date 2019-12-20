<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="th.inet.training.servlet.UserServlet" %>  
  <%@ page import="th.inet.training.servlet.UtilityServlet" %> 
<%@ page import="th.inet.training.object.UserDB" %>  
<%@ page import="th.inet.training.object.DAO.UserDAO" %>  
<%@ page import="java.util.*" %> 
   <%@page import="th.inet.training.servlet.LoginServlet"%>
   <%@page import="th.inet.training.servlet.LogoutServlet"%>

<%
	UserDB userObj = (UserDB) request.getSession().getAttribute(LoginServlet.SESSION_USER_OBJECT);
	if(userObj == null){
		LogoutServlet.doLogout(request, response, "Session timee out plest login");
	}
	List<UserDB> listUser = new UserDAO().listUser();
	if(listUser == null){
		
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>


<%
	String requestPage = UtilityServlet.getRequestScopeObject(request, UtilityServlet.PARAM_PAGE);
	switch(requestPage){
		case UtilityServlet.PAGE_DASHBOARD:
		default:
%>
			<jsp:include page="bootstrap.jsp" />
<%
	break;
		case UtilityServlet.PARAM_PAGE_USER:
%>
			<jsp:include page="bootstrap.jsp" />
<%
	break;
	}
%>

<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
 

</body>
</html>