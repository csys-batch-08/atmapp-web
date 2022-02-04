<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<div id="bgBlur"></div>
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/atmRefillNotNeeded.css">
<meta charset="ISO-8859-1">
<title>Atm Refill</title>
</head>
<body>
<c:if test="${agent == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
<h1 id = "reghead">No Need To Refill</h1>
<h1 id = "timehead">00:00</h1>
</body>
<script src="assets/js/timeoutAgentRedirect.js">


</script>
</html>