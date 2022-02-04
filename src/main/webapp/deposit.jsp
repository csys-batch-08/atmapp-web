<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel="icon" type="" href="assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/deposit.css">
<meta charset="ISO-8859-1">
<title>Deposit</title>
 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
input{
	font-size: 60px;
	}
	</style>
</head>
<body>
<div id="bgBlur"></div>
	<c:if test="${user == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>

	<h1 id="headwith">Welcome ${user}</h1>
	<label id="labwith" class = "animate__animated animate__bounceInDown">Enter Amount To Deposit</label>
	<form action="enterPinDeposit.jsp" id="formwith" autocomplete="off">
		<br> <input type="text" name="inpdep" id="withinp" required
			pattern="[1-9][0-9]*[0][0]" minlength="3" maxlength="7"
			title="Enter Valid Amount" onclick="invalabfn()"
			onmouseover="amountexceed()" onmouseenter="remainingamount()" class = "animate__animated animate__tada"
			autofocus>
	</form>
	<form action="welcomePage.jsp">
		<button type="submit" class="btn btn-danger">Home</button>
	</form>
	<h1 id="timehead">00:00</h1>
</body>

<script src="assets/js/timeoutIndexRedirect.js">

</script>
</html>