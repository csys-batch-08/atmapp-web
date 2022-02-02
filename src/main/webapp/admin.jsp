<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.* "%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" type="" href="assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/admin.css">
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<div id="bgBlur"></div>
<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<title>Welcome ${admin}</title>
</head>
<body>

	<label id="adminlab">welcome : ${admin}</label>
	<a href="register.jsp" id="adminregus">Register New User</a>
	<br>
	<br>
	<a href="removeAccount.jsp" id="adminremuser">Make User InActive</a>
	<br>
	<br>
	<a href="userDetailsMainPage.jsp" id="adminuserdet">User Details</a>
	<a href="logOutAdmin.jsp" id="logoutatag" class="btn btn-danger"
		class="left">LogOut</a>
	<br>
	<a href="logindetailsservlet" id="logindetails" class="left">Login
		Details</a>
	<h1 id="timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 100;
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
			window.location.assign("index.jsp");
		}
	},1000);
	
});
</script>

</html>