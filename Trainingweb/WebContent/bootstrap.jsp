<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
 <%@ page import="th.inet.training.servlet.UserServlet" %>  
  <%@ page import="th.inet.training.servlet.UtilityServlet" %> 
<%@ page import="th.inet.training.object.UserDB" %>  
<%@ page import="th.inet.training.object.DAO.UserDAO" %>  
<%@ page import="java.util.*" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
   
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
	
    <title>Hello, world!</title>
  </head>
  
  <body>
  
  <h1 >Hello, User !</h1>
  
<!-- Button trigger modal -->

<button type="button" class="btn btn-primary " data-toggle="modal" data-target="#exampleModalCenter" style="
    margin-left: 78rem;
    margin-bottom: 0.5rem;
    display: block;">
  ADD USER
</button>


<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalCenterTitle">ADD USER</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
     <div class="modal-body">
        <form action="userServlet" method="POST" id="addProdFrm" >
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Name:</label>
            <input type="text" class="form-control" name="<%= UserServlet.PARAM_USER_NAME %>" required/>
           
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Address:</label>
            <textarea class="form-control"  name="<%= UserServlet.PARAM_USER_ADDRESS %>" required></textarea>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Telephone:</label>
            <input type="text" class="form-control" name="<%= UserServlet.PARAM_USER_TEL %>" required/>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Username:</label>
            <input type="text" class="form-control" name="<%= UserServlet.PARAM_USER_USERNAME %>" required/>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Password:</label>
            <input type="text" class="form-control" name="<%= UserServlet.PARAM_USER_PASSWORD %>" required/>
            <input type="hidden" name="<%= UserServlet.PARAM_USER_ACTION %>" value="<%= UserServlet.PARAM_ADD %>" required/>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onClick="executeProduct('add')">Submit</button>
      </div>
    </div>
  </div>
</div>
  
  
  

<% List<UserDB> listUser = new UserDAO().listUser(); %>
 
  
  <table class="table" id="myTable">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">Telephone</th>
      <th scope="col">Username</th>
      <th scope="col">Password</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
  
  <% for (UserDB user : listUser) {%>
    <tr>
      <th scope="row"> <%= user.getuID() %> </th>
      <td> <%= user.getuName() %> </td>
      <td> <%= user.getuAddress() %> </td>
      <td> <%= user.getuTe() %> </td>
      <td> <%= user.getUsername() %> </td>
      <td> <%= user.getPassword() %> </td>
      
      
      <td>
      <span style="cursor: pointer;" onClick="openEditModal(
						'<%= user.getuID() %>',
						'<%= user.getuName()  %>',
						'<%= user.getuAddress() %>',
						'<%= user.getuTe() %>',
						'<%= user.getUsername() %>',
						'<%= user.getPassword() %>')">
      
      <button type="button" class="btn btn-success " data-toggle="modal" data-target="#exampleModalCenterEdit">
      EDIT</button>
      </span>
      
or
      
      
      
      
      
      
      
      
      	<span style="cursor: pointer;" onClick="openRemoveModal('<%= user.getuID() %>',
      	'<%= user.getuName()  %>',
      	'<%= user.getuAddress() %>')">
  
	
		<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">DELETED</button>
    	
    	</span>
  		 </td>
	  

  
    	</tr>
 
<% } %>
   
         <!-- Modal -->
<div class="modal fade" id="exampleModalCenterEdit" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitleEdit" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalCenterEditTitle">EDIT USER</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
     <div class="modal-body">
        <form action="userServlet" method="POST" id="editProdFrm" >
        <div class="form-group">
            <label for="recipient-name" class="col-form-label">ID:</label>
            <input style="width:100%; background-color:rgb(223,225,228); cursor:default;" type="text" name="<%= UserServlet.PARAM_USER_ID %>" id="edit_pId" readonly/>
           
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Name:</label>
            <input type="text" class="form-control" name="<%= UserServlet.PARAM_USER_NAME %>" id="edit_pName" required/>
           
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Address:</label>
            <textarea class="form-control"  name="<%= UserServlet.PARAM_USER_ADDRESS %>" id="edit_pAddress" required></textarea>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Telephone:</label>
            <input type="text" class="form-control" name="<%= UserServlet.PARAM_USER_TEL %>" id="edit_pTel" required/>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Username:</label>
            <input type="text" class="form-control" name="<%= UserServlet.PARAM_USER_USERNAME %>" id="edit_pUsername" required/>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Password:</label>
            <input type="text" class="form-control" name="<%= UserServlet.PARAM_USER_PASSWORD %>" id="edit_pPassword" required/>
            <input type="hidden" name="<%= UserServlet.PARAM_USER_ACTION %>" value="<%= UserServlet.PARAM_EDIT %>" required/>
            
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onClick="executeProduct('edit')">Save changes</button>
      </div>
    </div>
  </div>
</div>
   
		  <!-- Modal -->
		  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">DELETED USER</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      
		        <form action="userServlet" method="POST" id="removeProdFrm">
	      			<div class="row">
	      			<div class="col-12">
	      				<span>ID : </span>
	      			</div>
	      			<div class="col-12">
	      				<input style="width:100%; background-color:rgb(223,225,228); cursor:default;" type="text" name="<%= UserServlet.PARAM_USER_ID %>" id="remove_pId" readonly/>
	      			</div>
	      			<div class="col-12">
	      				<span>Name : </span>
	      			</div>
	      			<div class="col-12">
	      				<input style="width:100%; background-color:rgb(223,225,228); cursor:default;" type="text" id="remove_pName" readonly/>
	      			</div>
	      			<div class="col-12">
	      				<span>Address : </span>
	      			</div>
	      			<div class="col-12">
	      				<input style="width:100%; background-color:rgb(223,225,228); cursor:default;" type="text" id="remove_pAddress" readonly/>
	      				<input type="hidden" name="<%= UserServlet.PARAM_USER_ACTION %>" value="<%= UserServlet.PARAM_REMOVE %>" required/>
	      			</div>
	      			</div>			
	      		</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" onClick="executeProduct('remove')">DELETED</button>
		      </div>
		    </div>
		  </div>
		</div>   

   
  </tbody>
</table>
  
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
  

     <script type="text/javascript">
  
  $(document).ready(function() {
		$('#list-product').DataTable();
	});
  
  function executeProduct(action) {
		if (action === 'add') {
			$('#addProdFrm').submit();
		} else if (action === 'edit') {
			$('#editProdFrm').submit(); 
		} else if (action === 'remove') {
			$('#removeProdFrm').submit();
		}	
	}
  
	function openEditModal(uId, uName, uAddress, uTel, username, password){
		$('#edit_pId').val(uId);
		$('#edit_pName').val(uName);
		$('#edit_pAddress').val(uAddress);
		$('#edit_pTel').val(uTel);
		$('#edit_pUsername').val(username);
		$('#edit_pPassword').val(password);
		$('#edit-modal').modal('show');
	}
	
	
	function openRemoveModal(uId, uName, uAddress){
		console.log(uId)
		$('#remove_pId').val(uId);
		$('#remove_pName').val(uName);
		$('#remove_pAddress').val(uAddress);
	
	}
  </script>
  	<!-- Data table -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#myTable').DataTable();
		});
	</script>
  </body>
</html>