<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignInMenu</title>
</head>
<body>
	Message: ${msg}
	<form:form action="usrLogin" modelAttribute="usrl" method="post">
		<table>
				
			<tr>
				<td>User Email :</td>
				<td><form:input path="uemail" /></td>
			</tr>
			<tr>
				<td>User Password :</td>
				<td><form:input path="upassword" /></td>
			</tr>
						<tr>
				<td><input type="submit" value="SignIn"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form:form>
	<a href="viewUsers">ViewAllUsers</a>
	
</body>
</html>