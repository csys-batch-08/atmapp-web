<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link rel="stylesheet" type="" href="assets/css/invalidPinMax.css">
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Insert title here</title>
</head>
<body>
<h1>Account Is Locked Try After 2 Minutes!!</h1>
<h2>Contact Branch</h2>
<h1 id = "timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 4;
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
			if(localStorage.getItem("invalmax") == null){
			localStorage.removeItem("invalmax");
			localStorage.setItem("invalmax",1);
			clearInterval(i);
			window.location.assign("logOut.jsp");
			}else{
				clearInterval(i);
				window.location.assign("index.jsp");
			}
		}
	},1000);
	
});

</script>
</html>