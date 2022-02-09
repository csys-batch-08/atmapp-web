<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:400,500,500i,700,800i"
	rel="stylesheet">
<style type="text/css">
.social-part .fa {
	padding-right: 20px;
}

ul li a {
	margin-right: 20px;
}

nav {
	height: 100px;
	width:100%;
}
i{
float: right;
position: relative;
top: 20px;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-sm   navbar-light bg-light">
	

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="registerRe.jsp">Register <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="#userDetailsDiv">User Details</a></li>
			
				<li class="nav-item"><a class="nav-link" href="#removeUserDiv">Make User Inactive
						</a></li>
				<li class="nav-item"><a class="nav-link" href="logindetailsservlet">Login Details</a></li>
				<li class="nav-item"><a class="nav-link" href="logOutAdmin.jsp">LogOut</a></li>
			</ul>
			<div class="social-part">
				<i class="fa fa-facebook" aria-hidden="true"></i> <i
					class="fa fa-twitter" aria-hidden="true"></i> <i
					class="fa fa-instagram" aria-hidden="true"></i>
			</div>
		</div>
	</nav>
</body>
</html>