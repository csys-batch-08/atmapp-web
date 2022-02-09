<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
ul {
	list-style: none;
	background-color: black;
	margin: 0;
	color: black;
	width: 136.3%;
}

li {
	display: inline-block;
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	font-size: 17px;
}

li a {
	text-decoration: none;
	color: white;
	display: block;
	padding-right: 40px;
	padding-left: 60px;
}

li a:hover {
	opacity: 0.7;
	color: #F5DF4D;
	font-weight: bold;
}

.set1 {
	margin-right: 10px;
}
</style>
</head>
<body>
	<div class="nav">
		<ul>
			<li><a href="adminMain.jsp" class="set1">Home</a></li>
			<li><a href="registerRe.jsp">Register</a></li>
			<li><a href="allUserDetailsServlet">User Details</a></li>
			<li><a href="removeAccount.jsp">Make user Inactive</a>
			<li>
			<li><a href="logindetailsservlet">Login Details</a></li>
		</ul>
	</div>
</body>
</html>