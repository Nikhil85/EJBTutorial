<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function msg(){
	
	alert("Do You Want to delete User Record");
	
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>
<!-- Bootstrap CSS -->
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/style.css"/>">	
<style type="text/css">
.myrow-container {
	margin: 20px;
}
</style>
</head>
<body class=".container-fluid">
	<div class="container myrow-container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">
					<div align="left">
						<b>Manage Users</b>
					</div>
					
				</h3>
			</div>
			<div class="panel-body">
				<c:if test="${empty userList}">
                <div align="Left">
						<a href="createUser">Add User</a>
					</div>
            </c:if>
				<c:if test="${not empty userList}">


					<table class="table table-hover table-bordered">
					<div align="Left">
						<a href="createUser">Add User</a>
					</div>
						<thead style="background-color: #BCED91;">
							<tr>
								<th>S.N.</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Sex</th>
								<th>Phone No</th>
								<th>Email Id</th>
								<th>Address</th>
								<th>Update</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="user">
								<tr>
									<th><c:out value="${user.id}" /></th>
									<th><c:out value="${user.firstName}" /></th>
									<th><c:out value="${user.lastName}" /></th>
									<th><c:out value="${user.sex}" /></th>
									<th><c:out value="${user.phoneNo}" /></th>
									<th><c:out value="${user.emailId}" /></th>
									<th><c:out value="${user.address}" /></th>
									<th><a href="editUser?id=<c:out value='${user.id}'/>">Update</a></th>
									<th><a href="deleteUser?id=<c:out value='${user.id}'/>" onclick="msg()" >Delete</a></th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

		<%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>
</body>
</html>