<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Withdraw Success</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
#withsucclab {
	font-size: 45px;
	position: absolute;
	top: 180px;
	left: 240px;
	color : white;
	font-weight:bolder;
}

#succhead {
	font-size: 60px;
	color: yellow;
	position: absolute;
	top: 300px;
	left: 480px;
}
body{
background-image: url("https://resize.indiatvnews.com/en/resize/newbucket/715_-/2020/03/sbi-atm-card-1584194515.jpg");
background-repeat: no-repeat;
background-size: cover;
}

 #bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.7);
	height: 625px;
	width: 1366px;
} 
#timehead{
color: #EFC050;
position: absolute;
}
a{
text-decoration: none;
font-size: 30px;
position: absolute;
right: 20px;
top :20px;
}
</style>
</head>
<body>
	<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<label id="withsucclab" class="animate__animated animate__flash">You have successfully withdraw amount
		${withamount}</label>
	<h1 id="succhead" class="animate__animated animate__flash">
		BALANCE:${withbal}</h1>
	
<h1 id = "timehead">00:00</h1>
<a href="welcomePage.jsp" class="btn btn-danger">Home</a>
</body>

<script>

let th = document.getElementById("timehead");
let time = 10;
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
			window.location.assign("welcomePage.jsp");
		}
	},1000);
	
});


</script>
</html>