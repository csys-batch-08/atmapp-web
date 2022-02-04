<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel="stylesheet" type="" href="assets/css/userDetails.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">

<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>


<c:forEach items="${userprofilelistobjuser}" var = "userProfile">
	<fieldset id="userdetailfield">
		<legend>User Details</legend>
		 <h1>UserName : ${userProfile.userName}</h1><br>
		<h1>User Account No : ${userProfile.userAccountNo}</h1><br>
		<h1>Balance : ${userProfile.balance}</h1><br>
		<h1>Mobile No : ${userProfile.mobileNo}</h1><br>
		<br>
	</fieldset>
	</c:forEach>
<h1 id = "timehead">00:00</h1>
<a href="welcomePage.jsp" class="btn btn-danger">Home</a>
</body>

<script src="assets/js/timeoutWelcomePageRedirect.js">

</script>
</html>