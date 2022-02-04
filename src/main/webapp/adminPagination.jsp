<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
 #pagenation {
	position: relative;
	top: 1900px;
}
  </style>
</head>
<body>
<div id = "pagenation">
<ul class="breadcrumb">
  <li><a href="register.jsp">Register</a></li>
  <li><a href="allUserDetailsServlet">All User Detail</a></li>
  <li><a href="removeAccount.jsp">Remove Account</a></li>
  <li><a href="logindetailsservlet">Login Details</a></li>
  <li class="active">Vacation</li>
</ul>
</div>
</body>
</html>