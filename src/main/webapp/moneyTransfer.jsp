<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="" href="assets/css/moneyTransfer.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<div id="bgBlur"></div>
<title>Money Transfer</title>
</head>
<body>
	<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>

	<fieldset class="animate__animated animate__flash">
		<legend>Money Transfer</legend>
		<form action="moneytransferserv" method="post">
			<label>Enter UserName : </label><br> <input type="text" id = "moneytransfname"
				name="moneytransfname" autofocus required><br> <label>Enter
				UserAccountNo : </label><br> <input type="text" id = "moneytransfaccno" name="moneytransfaccno" pattern = "[0-9]{11}" title = "Enter valid Account no" required><br>
			<label>Enter Amount : </label><br> <input type="text" id = "moneytransfamount"
				name="moneytransfamount" required
			pattern="[1-9][0-9]*[0][0]" minlength = "3" maxlength="7" title="Enter Valid Amount"><br>
			<button type="submit" id="formbt">TRANSFER</button>
		</form>
	</fieldset>
	<form action="welcomePage.jsp">
		<button type="submit" id="homebt" class="btn btn-danger">Home</button>
	</form>
<h1 id = "timehead">00:00</h1>
</body>

<script src="assets/js/timeoutWelcomePageRedirect.js">

</script>
</html>