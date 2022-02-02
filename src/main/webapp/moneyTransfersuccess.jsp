<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="" href="assets/css/moneyTransfersuccess.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<div id="bgBlur"></div>
<title>Money Transfer Success!!</title>
</head>
<body>
<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>

<h1 id = "succhead" class="animate__animated animate__bounce">You Have Successfully Transfered ${moneytransfamount} to ${moneytransfname}</h1>
<label class="animate__animated animate__bounce">Your Balance is ${userbalint}</label>
<form action = "welcomePage.jsp">
<button type = "submit">Home</button>
</form>
<h1 id = "timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 8;
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