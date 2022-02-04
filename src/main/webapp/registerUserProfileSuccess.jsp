<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="" href="assets/css/registerUserProfileSuccess.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<div id="bgBlur"></div>
<title>Registered Successfully!!</title>
</head>
<body>
	<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<input type="text" value='<c:out value="${reguser}"></c:out>' id = "regUserId" >
<label id = "timehead">00:00</label>
</body>
<script src="assets/js/timeoutAdminRedirect.js">

</script>
<script>
window.addEventListener('load', () =>{
	let userName =  document.getElementById("regUserId").value;
	console.log(userName);
localStorage.setItem('sweetAlertLocal', userName);
window.location.assign("register.jsp");
});
</script>
</html>