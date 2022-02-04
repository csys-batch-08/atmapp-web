<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="" href="assets/css/pinChange.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<div id="bgBlur"></div>
<title>Pin change</title>
</head>
<body>
	<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<h1 id="pinchangehead">
		Welcome ${user}
</h1>
	<fieldset>
		<legend>Generate New Pin</legend>
		<h1 id="pinchangehead1">Enter The New Pin:</h1>
		<form action="pinchangeserv" method="post" autocomplete = "off" onsubmit="return cnfpass()">
			<input type="password" name="pininp" id="pininpid"
				pattern="[0-9]{4}" 
				title="enter new pin number 0-9 in length of four" autofocus required onclick = "invalabfn()">
			<br>
			<h1 id = "cnfpin">Confirm New Pin :</h1><br>
			<input type="password" name="pininp" id="pininpid1"
				pattern="[0-9]{4}" 
				title="enter new pin number 0-9 in length of four" autofocus required><br>
			<button type="submit" id = "subbt" >Generate</button><br>
		</form>
		<h1 id = "reglab">Pin Must Match!!</h1>
	</fieldset>
<h1 id = "timehead">00:00</h1>
<form action="welcomePage.jsp">
		<button type="submit" id = "homebt">Home</button>
	</form>
</body>

<script src="assets/js/pinChange.js">

</script>
</html>