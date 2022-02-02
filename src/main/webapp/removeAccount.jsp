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
</head>
<body>
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
	<a href="admin.jsp" class="btn btn-danger">Home</a>
</body>
</html>