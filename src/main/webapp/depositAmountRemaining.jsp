<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/depositAmountRemaining.css">
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Deposit Amount Remaining</title>
</head>
<body>
<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
<!-- amount exceed than 20000 -->
<h1 id = "remainingDeposit">Your Remaining deposit Limit is ${remainingDeposit}</h1>
	<h1 id="timehead">00:00</h1>
</body>

<script src="assets/js/timeoutWelcomePageRedirect.js"  >

</script>
</html>