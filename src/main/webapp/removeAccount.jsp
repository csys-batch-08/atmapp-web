<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<link rel="stylesheet" type="" href="assets/css/removeAccount.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Remove Account</title>
<style type="text/css">
@charset "ISO-8859-1";

*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
h2{
   color:#f1f1f1;
}

fieldset {
	position: absolute;
	top: 200px;
	width: 300px;
	height: 250px;
	left: 500px;
}

label {
	font-size: 20px;
	color: white;
	padding: 10px;
}
legend{
color : white;
}
input {
	position: absolute;
	left: 90px;
	width:200px;
	height:30px;
}

button {
	position: absolute;
	left: 200px;
	top: 100px;
}

form
{
  border:3px solid #f1f1f1;
  padding:10px;
  height:260px;
  width:350px;
}

body {
	background-image:
		url("https://scontent.fmaa12-2.fna.fbcdn.net/v/t31.18172-8/22051279_1623705757680216_2725610580980024577_o.jpg?_nc_cat=111&ccb=1-5&_nc_sid=9267fe&_nc_ohc=rQNE9RPtZRwAX-mhcc2&_nc_ht=scontent.fmaa12-2.fna&oh=00_AT8DZmZcWuSx5EuS6yKVIyni07maX40Fdj558GuUd-6Ayg&oe=61FBF9C7");
	background-repeat: no-repeat;
	background-size: cover;
}
#bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}

.form-control
{
  width:240px;
}

button {
	position: relative;
	left: 10px;
	width: 90px;
	height: 40px;
	top: 50px;
}

button:hover {
	background-color: black;
	color: white;
}
input:hover {
	background-color: black;
	color:white;
}
input:hover{
	box-shadow: 0 0 20px blue;
	transition-duration: 0.2s;
}
button:hover{
	box-shadow: 0 0 20px blue;
	transition-duration: 0.2s;
}
a{
text-decoration: none;
font-size: 30px;
position: absolute;
right: 20px;
top :20px;
}
</style>
</head>
<body>
<div id = "navBar">

</div>
	<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<fieldset>
		<legend>Remove User : </legend>
		<form action="removeaccserv" method="post">
			<label class="form-label">Enter User : </label><br> <input type="text"
				name="remusername" class="form-control" pattern="[A-Z][a-zA-Z]{3,20}"
				title="Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character" autofocus="autofocus"> <br/><label class="form-label" required>Enter user id :</label><br> <input type="text"
				name="remuserid" class="form-control" pattern="[0-9]{1,5}" title="Enter Valid User Id" required>
			<button type="submit" class="btn btn-primary">Remove</button>
		</form>
	</fieldset>
	<a href="adminMain.jsp" class="btn btn-danger">Home</a>
</body>
</html>