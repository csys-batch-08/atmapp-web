<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" type="" href="assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/atmOutOfCash.css">
<meta charset="ISO-8859-1">
<title>Atm out of Cash</title>
</head>
<body>
	<c:if test="${user == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<h1>Sorry!&#128531;</h1>
	<h2>ATM OUT OF CASH</h2>
	<label id="timehead">00:00</label>
</body>
<script src="assets/js/timeoutIndexRedirect.js">
	
</script>
</html>