<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "eng">
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>User Details</title>
<style>
#userdetailfield {
	width: 700px;
}

h1 {
	color: #F5DF4D;
	font-size: 50px;
}

legend {
	font-size: 30px;
	color:white;
} 	
</style>
</head>
<body bgcolor="#2F4F4F">
	<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>


<c:forEach items="${userprofilelistobjuser}" var = "userProfile">
	<fieldset id="userdetailfield">
		<legend>User Details</legend>
		 <h1>UserName : ${userProfile.username}</h1><br>
		<h1>User Account No : ${userProfile.useraccno}</h1><br>
		<h1>Balance : ${userProfile.balance}</h1><br>
		<h1>Mobile No : ${userProfile.mobno}</h1><br>
		<br>
	</fieldset>
	</c:forEach>
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
			window.location.assign("Logout.jsp");
		}
	},1000);
	
});



</script>
</html>