<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<!DOCTYPE html>
<html lang = "en">
<head>
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<link rel="icon" type="" href="assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/balance.css">
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"> </script>
<div id="bgBlur">
	<title>Balance</title>
</head>
<body>

	<c:if test="${user == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>

	<h1 id="headbal">Welcome ${user}</h1>
	<h1 id="headbal1" class="animate__animated animate__bounceInLeft">Your Balance :</h1>
	<br>

	<label id="ballab" class="animate__animated animate__bounceInRight">${balanceInt}</label>
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