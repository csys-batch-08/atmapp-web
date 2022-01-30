<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>Login Details!!</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}
th{
color:yellow;
font-weight:bolder;
font-size:30px;
}
td{
font-size:20px;
}
table{
background-color: rgba(255,255,255,0.2);
width: 80%;
margin-left: 100px;
}
#loginCaption{
font-size:40px;
}
</style>
</head>
<body bgcolor=" #363945">
<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<table>
	<caption id = "loginCaption">Login Details</caption>
		<tr>
			<th>Id</th>
			<th>UserName</th>
			<th>Logged at</th>
			<th>Role</th>
		</tr>
		
		<c:forEach items="${logindetailsobj}" var="loginDetails">
		<tr>
			<td>${loginDetails.id}</td>
			<td>${loginDetails.userName}</td>
			<td>${loginDetails.loggedTime}</td>
			<td>${loginDetails.role}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>