<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<div id="bgBlur"></div>
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/atmRefillNotNeeded.css">
<meta charset="ISO-8859-1">
<title>Atm Refill</title>
</head>
<body>
<c:if test="${agent == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
<h1 id = "reghead">No Need To Refill</h1>
<h1 id = "timehead">00:00</h1>
</body>
<script>
let th = document.getElementById("timehead");
let time = 5;
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
			window.location.assign("Agent.jsp");
		}
	},1000);
	
});



</script>
</html>