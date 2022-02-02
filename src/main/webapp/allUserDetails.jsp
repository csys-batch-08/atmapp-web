<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<link rel="icon" type="" href="assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/allUserDetails.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<c:if test="${admin == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<div class="container mt-1">
		<div id="minidiv">
			<table class="table table-bordered table-sm">
				<caption></caption>
				<thead class="table-dark">
					<tr>
						<th>User Id</th>
						<th>UserName</th>
						<th id="transamount">User Account No</th>
						<th id="transtime">Balance</th>
						<th>Mobile No</th>
						<th>User Pin</th>
						<th>Account Created At</th>
					</tr>
				</thead>
				<c:forEach items="${allUserDetailsList}" var="userProfile">
					<tr>
						<td> ${userProfile.id}</td>
						<td>${userProfile.userName}</td>
						<td>${userProfile.userAccountNo}</td>
						<td>${userProfile.balance}.00Rs</td>
						<td>${userProfile.mobileNo}</td>
						<td>${userProfile.userPin}</td>
						<td>${userProfile.accountCreatedTime}</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
	<a href="admin.jsp" class="btn btn-danger">Home</a>
</body>
</html>