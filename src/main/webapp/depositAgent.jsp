<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/depositAgent.css">
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Deposit Agent</title>
</head>
<body>
<c:if test="${agent == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<h1>welcome : ${agent}</h1>
	<fieldset>
	<legend>REFILL</legend>
	<form action = "depagentserv" method = "post">
	<label>Enter Amount To Refill : </label><br>
	<input type = "text" name= "depagentamount" pattern="[1-9][0-9]+[0][0]" maxlength="7" title = "Enter Amount Greater Than 2000 And Less Than 50000" required="required" autofocus="autofocus"><br>
	<button type = "submit">Deposit</button>
	</form>
	</fieldset>
<h2 id = "timehead">00:00</h2>
</body>
<script src="assets/js/timeoutAgentRedirect.js">

</script>
</html>