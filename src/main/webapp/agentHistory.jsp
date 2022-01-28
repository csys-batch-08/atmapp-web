<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*" import = "com.atm.controller.*"%>
 <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "eng">
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>Agent History</title>
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
body{
background-color: #0072B5;
}
</style>
</head>

	<body bgcolor="blue">
	<c:if test="${agent == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<table style="width: 80%; margin-left: 100px;">
		<tr>
			<th>Id</th>
			<th>Money Filled</th>
			<th>Current Balance</th>
			<th>Filled At</th>
			<th>Agent Name</th>		
		</tr>
		<c:forEach items="${agenthistoryobj}" var="agentHistory">
		<tr>
			<td>${agentHistory.id}</td>
			<td>${agentHistory.moneydeposited}</td>
			<td>${agentHistory.moneybalance}</td>
			<td>${agentHistory.depositedat}</td>
			<td>${agentHistory.agentname}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</body>
</html>