<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="" href="assets/css/refillNotNeeded.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<div id="bgBlur"></div>
<title>Insert title here</title>
</head>
<body>
<c:if test="${agent == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>

<h1>No Need to Refill</h1>


</body>
<h2 id = "timehead">00:00</h2>


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
			window.location.assign("logOut.jsp");
		}
	},1000);
	
});



</script>
</html>