<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "eng">
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>Removed Users!!</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
}
td{
font-size:30px;
}
th{
color:#F5DF4D;
font-size:30px;
}

</style>
</head>
<body bgcolor="#2F4F4F">
<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	
	<table style="width: 80%; margin-left: 100px;">
	<thead>
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
		<td>${removedUsers.useraccno}</td>
		<td>${removedUsers.username}</td>
		<td>${removedUsers.lastbalance}</td>
		<td>${removedUsers.mobno}</td>
		<td>${removedUsers.userpin}</td>
		<td>${removedUsers.accremovedat}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>