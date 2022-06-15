<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignupMenu</title>
</head>
<body>
	Message: ${msg}
	<form:form action="usrInsert" modelAttribute="usr" method="post">
		<table>
				<tr>
				<td>User Name :</td>
				<td><form:input path="uname" /></td>
			</tr>
			<tr>
				<td>User Email :</td>
				<td><form:input path="uemail" /></td>
			</tr>
			<tr>
				<td>User Password :</td>
				<td><form:input path="upassword" /></td>
			</tr>
			<tr>
				<td>User Address :</td>
				<td><form:input path="uaddress" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Signup"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form:form>
	<a href="loginForm">Login?</a>
	
</body>
</html>