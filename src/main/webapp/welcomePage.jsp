<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="" href="assets/css/welcomePage.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<div id="bgBlur" onmousemove="invalidPinDisable()"></div>
<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
<title>Welcome ${user}</title>
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<link rel="stylesheet" href="welcomeuser.css">
</head>
<body>
	<c:if test="${invalidhomepin != null}">
	<h1 id="invalpin" class="animate__animated animate__bounceInDown">Invalid Pin</h1>
	<c:remove var="invalidhomepin" scope="session"/>
	</c:if>
	<div class="marquee">
	<p><strong>STATE BANK OF INDIA</strong></p>
</div>
<hr>
<div class="animate__animated animate__fadeInDown">
	<a href="withdraw.jsp" id="withdraw" class="atag">Withdraw</a>
	<a href="deposit.jsp" id="deposit" class="atag">Deposit</a>
	<a href="enterPinBalance.jsp" id="balance" class="atag">Balance</a>
	<a href="enterPinUserDetail.jsp" id="userdetails" class="atag">User
		Details</a>
	<a href="enterPinMoneyTransfer.jsp" id="moneytransfer" class="atag">Money
		Transfer</a>
	<a href="enterPinMiniStatement.jsp" id="ministatement" class="atag">Mini
		Statement</a>
	<a href="pinChangeEnterPin.jsp" id="pinchange" class="atag">Pin Change</a>
	<a href="logOut.jsp" id="logout" class="atag">Logout</a>
	<h1 id="timehead">00:00</h1>
	</div>
	
</body>

<script src="assets/js/welcomePage.js">

</script>
<script type="text/javascript">
if(sessionStorage.getItem("invalidhomepin") != null){
	console.log("hi dude");
sessionStorage.removeItem("invalidhomepin");
}
</script>
</html>
