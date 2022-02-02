<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" type="" href="Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>User Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
#homeTag{
text-decoration: none;
font-size: 30px;
position: absolute;
right: 20px;
top :20px;
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
		url("https://techcrunch.com/wp-content/uploads/2018/09/GettyImages-465790437.jpg?w=430&h=230&crop=1");
	background-repeat: no-repeat;
	background-size: cover;
}
a{
	text-decoration: none;
	font-size: 50px;
}
#allUserDetailsId{
position: absolute;
	top: 110px;
	border-radius: 10px;
	background-color: rgba(255, 255, 255, 0.7);
	border-color: white;
	left:500px;
}
#userDetailsId{
position: absolute;
	top: 250px;
	border-radius: 10px;
	background-color: rgba(255, 255, 255, 0.7);
	border-color: white;
	left:350px;
}
#removedUserListId{
position: absolute;
	top: 380px;
	border-radius: 10px;
	background-color: rgba(255, 255, 255, 0.7);
	border-color: white;
	left:480px;
}
#allUserDetailsId:hover {
	transform: translateX(10px);
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
	background-color: orange;
}
#userDetailsId:hover{
	transform: translateX(10px);
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
	background-color: orange;
}
#removedUserListId:hover{
	transform: translateX(10px);
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
	background-color: orange;
}
</style>
</head>
<body>
<div id="bgBlur"></div>
<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<div class = "atag" id = "allUserDetailsId">
<a href="allUserDetailsServlet">All User Details</a>
</div>
<div class = "atag" id = "userDetailsId">
<a href="userDetailsAdminGetUser.jsp">Get User Detail By UserName</a>
</div>
<div class = "atag">
<a href="Removeduserlistservlet" id = "removedUserListId">Inactive Users List</a>
</div>
<a href="admin.jsp" class="btn btn-danger" id = "homeTag">Home</a>
</body>
</html>