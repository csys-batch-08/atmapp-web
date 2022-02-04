<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/enterPinMoneyTransfer.css">
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Enter Pin</title>
</head>
<body>
	<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<h1 class="animate__animated animate__bounceInDown">Enter Pin</h1>
	<form action="Enterpinmoneytransfserv" method = "post">
		<input type="password" name="moneytransfpin" id="withpinid" pattern="[0-9]{4}" title = "enter your pin 0-9 in length of four" class="animate__animated animate__heartBeat" required autofocus>

	</form>
<h1 id = "timehead">00:00</h1>
</body>

<script src="assets/js/timeoutWelcomePageRedirect.js">

</script>
</html>