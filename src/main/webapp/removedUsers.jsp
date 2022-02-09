<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<meta charset="ISO-8859-1">
<head>
<link rel="stylesheet" type="" href="assets/css/removedUsers.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
  <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Removed Users</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: Arial, Helvetica, sans-serif;
}

td {
	color: yellow;
	font-weight: bolder;
	text-align: center;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
}

table {
	align: center;
	margin-top: 100px;
}

th {
	color: white;
	font-weight: bolder;
	font-size: 30px;
	text-align: center;
}

	tr:hover {
		background-color: black;
		color: yellow;
	}

td {
	font-size: 20px;
}

body {
	background-color: #363945;
	background-repeat: no-repeat;
	background-size: cover;
}
a{
text-decoration: none;
font-size: 30px;
position: absolute;
right: 20px;
top :20px;
}
#removedUsersCaption{
position: absolute;
top : 40px;
left : 540px;
font-size: 40px;
color: red;
}
</style>
</head>
<body>
<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	
	<div class="container mt-1">
		<div id="minidiv">
			<table class="table table-bordered table-sm">
	<caption id = "removedUsersCaption">Inactive Users</caption>
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>UserAccount Number</th>
			<th>UserName</th>
			<th>LastBalance</th>
			<th>Mobile no</th>
			<th>UserPin</th>
			<th>Account removed At</th>
		</tr>
		</thead>
		<c:forEach items="${removeduserslist}" var = "removedUsers">
		<tr>
		<td>${removedUsers.id}</td>
		<td>${removedUsers.userAccountNo}</td>
		<td>${removedUsers.userName}</td>
		<td>${removedUsers.lastBalance}</td>
		<td>${removedUsers.mobileNo}</td>
		<td>${removedUsers.userPin}</td>
		<td>${removedUsers.accountRemovedTime}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
	<a href="adminMain.jsp" class="btn btn-danger">Home</a>
</body>
</html>