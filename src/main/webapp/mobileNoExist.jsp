<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h1{
color:yellow;
position : absolute;
top : 200px;
left :370px;
font-size :60px;
}

#timehead{
position: absolute;
top: 0px;
left : 0px;
}

</style>
</head>
<body bgcolor = "navy">

<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
<h1>Mobile No Already Exist!!</h1>
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
			clearInterval(i);
			window.location.assign("register.jsp");
		}
	},1000);
	
});

</script>

</html>