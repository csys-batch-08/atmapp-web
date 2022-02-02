<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<div id="bgBlur"></div>
<title>Agent</title>
<link rel="stylesheet" type="" href="assets/css/agent.css">
</head>
<body>
	<c:if test="${agent == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<h1 id = "agenthead">welcome :
	${agent}</h1>
<a href = "depositAgent.jsp" id = "depagent">Deposit Money To ATM</a><br>
<a href = "agenthistoryservlet" id = "historyagent">View History</a>
<a href="logOutAgent.jsp" id="logout" class="atag">Logout</a>
<h1 id = "timehead">00:00</h1>
</body>
<script>
let th = document.getElementById("timehead");
let time = 50;
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
			window.location.assign("logOutAgent.jsp");
		}
	},1000);
	
});



</script>
</html>