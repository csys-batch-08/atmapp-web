<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/enterPinDeposit.css">
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Enter Pin</title>
</head>
<body>
<%int depositAmount = Integer.parseInt(request.getParameter("inpdep"));
session.setAttribute("depamount", depositAmount);%>
<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<h1 class="animate__animated animate__bounceInDown">Enter Pin</h1>
	<form action="Enterpindepservlet">
		<input type="password" name="deppin" id="withpinid" pattern = "[0-9]{4}" title = "enter your pin 0-9 in length of four" class="animate__animated animate__heartBeat" required autofocus>
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