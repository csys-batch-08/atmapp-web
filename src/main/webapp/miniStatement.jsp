<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"
	import="com.atm.models.*" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<!DOCTYPE html>
<html lang="en">
<div id="bgBlur"></div>
<head>
<meta charset="ISO-8859-1">
<title>Mini Statement</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="style"
	href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: Arial, Helvetica, sans-serif;
}

td {
	color: #EFC050;
	font-weight: bolder;
	text-align: center;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
	`
}

table {
	align: center;
	margin-top: 100px;
}

th {
	color: #FA7A35;
	font-weight: bolder;
	font-size: 30px;
	text-align: center;
}

tr:hover {
	background-color: black;
	color: yellow;
}

td {
	font-size: 20px;
}

body {
	background-color: 	#303030;
	background-repeat: no-repeat;
	background-size: cover;
}

#timehead {
	position: absolute;
	top: -90px;
	left: -100px;
	color: #E15D44;
}

#miniStatementCaption {
	position: absolute;
	font-size: 40px;
	color: white;
	top: -100px;
	left: 420px;
}
#descriptionId{
color: #D2386C;
position: absolute;
left: 250px;
}
a {
	text-decoration: none;
	font-size: 30px;
	position: absolute;
	right: 20px;
	top: 20px;
}
label {
	position: relative;
	float:left;
}
</style>
</head>
<body>
	<c:if test="${user == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>

	<div class="container mt-1">
		<div id="minidiv">
			<div class="animate__animated animate__lightSpeedInLeft">
				<table class="table table-bordered table-sm" id = "myTable">
					<caption id="miniStatementCaption">Mini Statement</caption>
					<thead class="table-dark">
						<tr>
							<th>Transaction_type</th>
							<th id="transamount">Transaction</th>
							<th id="transtime">Transaction Time</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ministatementjspobj}" var="miniStatement">
						<tr>
							<td>${miniStatement.transActionType}</td>
							<td>${miniStatement.transActionAmount} RS</td>
							<td>${miniStatement.transActionAt}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

				<h1 id="timehead">00:00</h1>
			</div>
		</div>
	</div>
	<div id = "descriptionId" class="animate__animated animate__flash animate__delay-2s animate__infinite animate__slow">
		<h1>YOUR'S &ensp; RECENT &ensp;TEN &ensp; TRANSACTIONS</h1>
	</div>
	<a href="welcomePage.jsp" class="btn btn-danger">Home</a>
</body>
<script type="text/javascript">
$(document).ready( function () {
    $('#myTable').DataTable();
} );
</script>
<script src="assets/js/timeoutWelcomePageRedirect.js">
	
</script>
</html>