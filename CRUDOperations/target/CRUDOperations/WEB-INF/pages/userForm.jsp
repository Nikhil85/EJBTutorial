<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>

<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		function submitUserForm() {

			// getting the user form values
			var firstName = $('#firstName').val().trim();
			var lastName = $('#lastName').val();
			var emailId = $('#emailId').val();
			if (firstName.length == 0) {
				alert('Please enter name');
				$('#firstName').focus();
				return false;
			}

			if (lastName.length == 0) {
				alert('Please enter proper Last Name');
				$('#lastName').focus();
				return false;
			}

			if (emailId.length == 0) {
				alert('Please enter proper Email Id');
				$('#emailId').focus();
				return false;
			}
			return true;
		};
	</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Information</title>
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
				<h3 class="panel-title">Add User</h3>
			</div>
			<div class="panel-body">
				<form:form id="userRegisterForm" cssClass="form-horizontal"
					modelAttribute="user" method="post" action="saveUser">

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="firstName">First Name</form:label>
						</div>
						<div class="col-xs-6">
							<form:hidden path="id" value="${userObject.id}" />
							<form:input cssClass="form-control" path="firstName"
								value="${userObject.firstName}" />
						</div>
					</div>

					<div class="form-group">
						<form:label path="lastName" cssClass="control-label col-xs-3">Last Name</form:label>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="lastName"
								value="${userObject.lastName}" />
						</div>
					</div>

					<div class="form-group">
						<form:label path="sex" cssClass="control-label col-xs-3">Sex</form:label>
						<div class="col-xs-6">
							<%-- <form:ra cssClass="form-control" path="lastName"
								value="${userObject.lastName}" /> --%>

							<c:choose>
								<c:when test="${userObject.sex=='Male'}">
									<form:radiobutton path="sex" value="Male" checked="checked" />
							Male
							<form:radiobutton path="sex" value="Female" />
							Female
							</c:when>
								<c:otherwise>
									<form:radiobutton path="sex" value="Male" />
							Male
							<form:radiobutton path="sex" value="Female" checked="checked" />
							Female</c:otherwise>
							</c:choose>

						</div>
					</div>

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="phoneNo">Phone No</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="phoneNo"
								value="${userObject.phoneNo}" />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="emailId">Email Id</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="emailId"
								value="${userObject.emailId}" />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="address">Address</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="address"
								value="${userObject.address}" />
						</div>
					</div>


					<div class="form-group">
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4">
								<input type="submit" id="saveUser" value="Submit"
									onclick="return submitUserForm();" />
									
									<input type="Reset"  value="Reset"/>
									
									<input type="button"  value="Cancel"/>
							</div>
							<div class="col-xs-4"></div>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>

	
</body>
</html>