<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" type="" href="assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/loginDetails.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
	<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Login Details!!</title>
</head>
<body>
	<c:if test="${admin == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>

	<div class="container mt-1">
		<div id="minidiv">
			<table class="table table-bordered table-sm">
				<caption id="loginDetailsCaption">Login Details</caption>
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>UserName</th>
						<th>Logged at</th>
						<th>Role</th>
					</tr>

					<c:forEach items="${logindetailsobj}" var="loginDetails">
						<tr>
							<td data-aos="fade-up">${loginDetails.id}</td>
							<td data-aos="fade-up">${loginDetails.userName}</td>
							<td data-aos="fade-up">${loginDetails.loggedTime}</td>
							<td data-aos="fade-up">${loginDetails.role}</td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
	<a href="admin.jsp" class="btn btn-danger">Home</a>
</body>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
  AOS.init();
</script>
</html>