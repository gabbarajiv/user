<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https:code.jquery.com/jquery-3.6.0.js">
</script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<link
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script>
$(document).ready( function () { $('#userab').DataTable(); } );
</script>
</head>
<body>
	<H3>View All Users</H3>
	<a href="loadForm">Add new User</a>
	<table border="2" id="userab">
		<thead>
			<tr>
				<th>User Number</th>
				<th>User name</th>
				<th>User Email</th>
				<th>User Password</th>
				<th>User Address</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="u">
				<tr>
					<td>${u.uno}</td>
					<td>${u.uname}</td>
					<td>${u.uemail}</td>
					<td>${u.upassword}</td>
					<td>${u.uaddress}</td>
					<td><a href="editusr?id=${u.uno}">Edit</a></td>
					<td><a href="deleteusr?id=${u.uno}" onclick="deleteConfirm()">Delete</a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>