<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/agentHistory.css">
<meta charset="ISO-8859-1">
<title>Agent History</title>
</head>

	<body>
	<c:if test="${agent == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<table style="width: 80%; margin-left: 100px;">
	<caption id = "agentCaption">Agent History</caption>
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
			<td>${agentHistory.moneyDeposited}</td>
			<td>${agentHistory.moneyBalance}</td>
			<td>${agentHistory.depositedTime}</td>
			<td>${agentHistory.agentName}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>