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

<script>
let pass1 = document.getElementById("pininpid");
let pass2 = document.getElementById("pininpid1");
let reglab = document.getElementById("reglab");
function cnfpass() {
	if (pass1.value != pass2.value) {
		pass1.style.borderBlockColor = "red";
		pass2.style.borderBlockColor = "red";
		reglab.style.color = "red";
		reglab.style.visibility = "visible";
		return false;
	}
	return true;
}

//hiding lab function:
	function invalabfn() {
		let invallab = document.getElementById("reglab");
		pass1.style.borderBlockColor = "black";
		pass2.style.borderBlockColor = "black";
		invallab.style.visibility = "hidden";
	}
	
	//timeout function:
	let th = document.getElementById("timehead");
let time = 70;
let i;
window.addEventListener('load', () =>{
	
	 i= setInterval(() => {
		if(time > 0){
			if(time >= 10){
				
		th.innerHTML = "00 : " + time--;
		
			}else{
				th.style.color = "red";
				th.innerHTML = "00 : 0" + time--;
			}
		}else{
			clearInterval(i);
			window.location.assign("logOut.jsp");
		}
	},1000);
	
});

</script>
</html>