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
<div id="bgBlur"></div>
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
	<h1 id="invalpin">Invalid Pin</h1>
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

<script>
localStorage.removeItem("invalmax");
let th = document.getElementById("timehead");
let time = 30;
let i;
window.addEventListener('load', () =>{
	
	 i= setInterval(() => {
		if(time > 0){
			if(time >= 10){
			
		th.innerHTML = "00 : " + time--;
		
			}else{
				th.style.color = "red";
				th.innerHTML = "00 : 0" + time--;
			}
		}else{
			clearInterval(i);
			window.location.assign("logOut.jsp");
		}
	},1000);
	
});

</script>
</html>
