<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Enter Pin</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
h1 {
	position: absolute;
	color: #BC243C;
	font-size: 90px;
	left: 500px;
	top:100px;
}

form {
	position: absolute;
	top: 300px;
	left: 500px;
}
input {
	height: 90px;
	width: 300px;
	background-color: rgba(255,255,255,0.7);
	font-size: 60px;
	position : relative;
	left : 50px;
} 
#timehead{
position : absolute;
left : 0px;
color : #EFC050;
font-size:40px;
top: 0px;
}
body{
background-image: url("https://resize.indiatvnews.com/en/resize/newbucket/715_-/2020/03/sbi-atm-card-1584194515.jpg");
background-repeat: no-repeat;
background-size: cover;
}
#withpinid:hover{
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
}
 #bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.7);
	height: 625px;
	width: 1366px;
} 
</style>
</head>
<body>
<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<%int amount = Integer.parseInt(request.getParameter("inpwith"));
	session.setAttribute("withamount", amount);%>
	<h1 class="animate__animated animate__bounceInDown">Enter Pin</h1>
	<form action="Enterpinservlet">
		<input type="password" name="withpin" id="withpinid" pattern="[0-9]{4}" title = "enter your pin 0-9 in length of four" class="animate__animated animate__heartBeat" required autofocus>

	</form>
<h1 id = "timehead">00:00</h1>
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