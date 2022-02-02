<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*" isELIgnored="false"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel="stylesheet" type="" href="assets/css/userDetailAdmin.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">

<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
<c:forEach items="${userdetailslistobj}" var = "userProfile">
	<fieldset id="userdetailfield">
		<legend>User Details</legend>
		<h1>User Id : ${userProfile.id}</h1><br>
		 <h1>UserName : ${userProfile.userName}</h1><br>
		<h1>User Account No : ${userProfile.userAccountNo}</h1><br>
		<h1>Balance : ${userProfile.balance}</h1><br>
		<h1>Mobile No : ${userProfile.mobileNo}</h1><br>
		<h1>User Pin : ${userProfile.userPin}</h1><br/>
		<h1>Account Opened DateTime :<br/> ${userProfile.accountCreatedTime} </h1>
		<br>
	</fieldset>
</c:forEach>
<a href="admin.jsp" class="btn btn-danger">Home</a>
</body>
</html>