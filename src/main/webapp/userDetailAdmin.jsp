<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*" isELIgnored="false"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>User Details</title>
<style>
#userdetailfield {
	width: 700px;
}

h1 {
	color: yellow;
	font-size: 50px;
}

legend {
	font-size: 30px;
	color: white;
}

#headinval {
	position: absolute;
	font-size: 80px;
	left: 400px;
	top: 200px;
}
body{
background-color: #2F4F4F;
}
</style>
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
		<br>
	</fieldset>
</c:forEach>
</body>
</html>