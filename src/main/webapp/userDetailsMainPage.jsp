<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="" href="assets/css/userDetailsMainPage.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>User Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
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