<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" type="" href="Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>Withdraw</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<div id="bgBlur"></div>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

#headwith {
	position: absolute;
	left: 530px;
	font-size: 45px;
	color: #D2386C;
}

#labwith {
	color: white;
	font-size: 70px;
	position: absolute;
	top: 150px;
	left: 320px;
	font-weight: bolder;
}

#invallab {
	position: relative;
	color: #FF6347;
	font-size: 60px;
	top: 250px;
	left: 540px;
}

input {
	height: 90px;
	width: 300px;
	background-color: rgba(255, 255, 255, 0.7);
	font-size: 60px;
	position: relative;
	right: -25px;
}

form {
	position: absolute;
	top: 300px;
	left: 530px;
}

button {
	position: relative;
	width: 80px;
	height: 50px;
	background-color: red;
	right: -700px;
	border-radius: 10px;
	top: -280px;
}

body {
	background-image:
		url("https://resize.indiatvnews.com/en/resize/newbucket/715_-/2020/03/sbi-atm-card-1584194515.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

#withinp:hover {
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
}

#bgBlur {
	position: absolute;
	background-color: rgba(11, 11, 11, 0.7);
	height: 625px;
	width: 1366px;
}

#amountexceed {
	position: absolute;
	color: #FF6347;
	top: 450px;
	left: 420px;
}

#remainingWithdraw {
	position: absolute;
	color: #FF6347;
	top: 450px;
	left: 350px;
}

#timehead {
	color: #F5DF4D;
	position: absolute;
}
</style>
</head>
<body>
	<c:if test="${user == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<h1 id="headwith">Welcome ${user}</h1>
	<label id="labwith" class="animate__animated animate__fadeInDown">Enter
		Amount To Withdraw</label>
	<form action="enterPinWithdraw.jsp" id="formwith" autocomplete="off">
		<br> <input type="text" name="inpwith" id="withinp" required
			pattern="[1-9][0-9]*[0][0]" minlength="3" maxlength="7"
			title="Enter multiples of 100"
			class="animate__animated animate__tada" autofocus>
	</form>
	<form action="welcomePage.jsp">
		<button type="submit" class="btn btn-danger">Home</button>
	</form>
	<h1 id="timehead">00:00</h1>
</body>

<script>

let th = document.getElementById("timehead");
let time = 20;
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