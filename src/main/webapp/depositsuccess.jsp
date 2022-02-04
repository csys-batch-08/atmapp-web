<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/depositsuccess.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<div id="bgBlur">
	<title>Deposit Success</title>
</head>
<body>
	
<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	
	<label id="withsucclab" class="animate__animated animate__flash">You have successfully Deposited amount ${depsuccamount}</label>
	<h1 id="succhead" class="animate__animated animate__flash"> BALANCE : ${depsuccbal}</h1>


<h1 id = "timehead">00:00</h1>
<a href="welcomePage.jsp" class="btn btn-danger">Home</a>
</body>

<script src="assets/js/timeoutWelcomePageRedirect.js">

</script>
</html>