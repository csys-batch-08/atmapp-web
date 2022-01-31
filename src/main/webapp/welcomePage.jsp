<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
<title>Welcome ${user}</title>
<link rel="stylesheet" href="welcomeuser.css">
<style>
#invalpin {
	color: #F5DF4D;
	position: absolute;
	font-size: 80px;
	top: 300px;
	left: 500px;
	font-weight: bolder;
}

a {
	display: inline-block;
	box-sizing: border-box;
	cursor: pointer;
	transition: transform 0.7s;
}

a:hover {
	transform: translateY(-10px);
}
  .marquee {
    width: 100%;
line-height: 50px;
	font-size:40px;
	color: white;
    white-space: nowrap;
    overflow: hidden;
    box-sizing: border-box;
}
.marquee p {
    display: inline-block;
    padding-left: 100%;
    animation: marquee 10s linear infinite;
}
@keyframes marquee {
    0%   { transform: translate(0, 0); }
    100% { transform: translate(-70%, 0); }
}
</style>
</head>
<body>
	<c:if test="${invalidhomepin != null}">
	<h1 id="invalpin">Invalid Pin</h1>
	</c:if>
	<div class="marquee">
	<p><strong>STATE BANK OF INDIA</strong></p>
</div>
<hr>
	<a href="withdraw.jsp" id="withdraw" class="atag">Withdraw</a>
	<a href="deposit.jsp" id="deposit" class="atag">Deposit</a>
	<a href="enterPinBalance.jsp" id="balance" class="atag">Balance</a>
	<a href="enterPinUserDetail.jsp" id="userdetails" class="atag">User
		Details</a>
	<a href="enterPinMoneyTransfer.jsp" id="moneytransfer" class="atag">Money
		Transfer</a>
	<a href="enterPinMiniStatement.jsp" id="ministatement" class="atag">Mini
		Statement</a>
	<a href="pinChange.jsp" id="pinchange" class="atag">Pin Change</a>
	<a href="logOut.jsp" id="logout" class="atag">Logout</a>
	<h1 id="timehead">00:00</h1>
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
