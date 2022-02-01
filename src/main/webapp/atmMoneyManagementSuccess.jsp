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
<title>Money Deposited!!</title>
<style>
h1 {
	font-size: 50px;
	color: yellow;
	position: absolute;
	top: 200px;
	left: 150px;
}

#timehead {
	position: absolute;
	top: 0px;
	left: 0px;
	color: black;
}
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}
#bgBlur {
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}
body {
	background-image:
		url("https://resize.indiatvnews.com/en/resize/newbucket/715_-/2020/03/sbi-atm-card-1584194515.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
<div id="bgBlur"></div>
	<c:if test="${agent == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>


	<h1>You Have Successfully Deposited ${agentdepamount} ${agent}</h1>
	<h1 id="timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 4;
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
			window.location.assign("agent.jsp");
		}
	},1000);
	
});

</script>
</html>