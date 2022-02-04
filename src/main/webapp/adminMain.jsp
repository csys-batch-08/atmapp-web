<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
  
<style type="text/css">


#slideImage {
	width: 100%;
	height:470px;
}
  .marquee {
    width: 100%;
line-height: 5px;
	background-color: black;
	color: white;
    white-space: nowrap;
    overflow: hidden;
    box-sizing: border-box;
    position : relative;
    bottom: 0px;
}
.marquee p {
    display: inline-block;
    padding-left: 100%;
    padding-top:15px;
    animation: marquee 30s linear infinite;
}
@keyframes marquee {
    0%   { transform: translate(0, 0); }
    100% { transform: translate(-70%, 0); }
}

#registerUserId{
width : 100%;
height:300px;
position: absolute;
top : 90px;
box-shadow: 5px 5px 10px 2px rgba(0,0,0,.8);
}
#registerId{
position: relative;
top:272px;
left:670px;
height:40px;
width: 200px;
padding: 15px;
font-size: 20px;
background-color: #5B5EA6;
}
#registerUserHead{
position: relative;
top:40px;
left: 30px;
}
body {
  font-family: 'Times New Roman', serif;
}
#userDetailsDiv{
position: absolute;
top: 1100px;
}
#userDetailsHead{
position: relative;
left: 80px;
}
#allUserContainerDiv{
position: absolute;
right: 300px;
top:1200px;
}
#userDetailId{
position: absolute;
top:90px;
}
#inactiveUserId{
position: absolute;
top:170px;
}
#removeUserDiv{
position: absolute;
top: 1700px;
right: 40px;
}
#removeUserId{
border-radius: 10px;
box-shadow: 5px 5px 10px 2px rgba(0,0,0,.8);

}
#makeInactiveUserId{
position: absolute;
left: 0px;
width: 100%;
}
#makeUserInactiveDiv{
position: absolute;
top : 1800px;
left: 200px;
}
#removeUserHead{
position: absolute;
left: -700px;
top:-100px;
}
#loginDetailsDiv{
position: absolute;
top: 2100px;
}
#loginDetailsId{
position: absolute;
width: 500px;
left: 30px;
border-radius: 10px;
}
#allUserId,#userDetailId,#inactiveUserId,#loginDetailsId,#loginDetailstag,#makeUserInactiveTag{
 box-shadow: 5px 5px 10px 2px rgba(0,0,0,.8);
}
#makeUserInactiveId{
#box-shadow: 5px 5px 10px 2px rgba(0,0,0,.8);
}
#loginDetailsHead{
position: relative;
left: 30px;
}
#loginDetailstagDiv{
position: absolute;
top: 2200px;
}
#loginDetailstag{
position: relative;
right: -900px;
top: 100px;
}
</style>
</head>
<body>
<jsp:include page="navBar.jsp"/>
	<div>
		<img src="https://www.onlinesbi.com/sbijava/images/banner36.jpg"
			alt="SBIIMAGE" id="slideImage" class="animate__animated animate__fadeInLeft">
	</div>
	<div class = "animate__animated animate__flash">
<div class="marquee">
	<p><strong> State Bank of India never ask for your user id / password / pin no. through phone call / SMSes / e-mails. Any such phone call / SMSes / e-mails asking you to reveal credential or One Time Password through SMS could be attempt to withdraw money from your account.NEVER share these details to anyone. State Bank of India wants you to be secure. If you come across any such instances please inform us through e-mail to the following address</strong></p>
</div>
</div>

<div data-aos="flip-left"
     data-aos-easing="ease-out-cubic"
     data-aos-duration="2000">
<div id = "registerUserDiv">
<img alt="registerUserImage" src="https://www.onlinesbi.com/sbijava/images/banner3.jpg" id = "registerUserId">
<h1 id = "registerUserHead">Register User :</h1>
<a href="register.jsp" class="badge badge-pill badge-primary" id = "registerId">Register</a>
</div>
</div>

<div id = "userDetailsDiv" data-aos="zoom-in-down">
<h1 id = "userDetailsHead">User Details :</h1>
<img alt="" src="https://www.icicibank.com/html/en/temp/digital-banking-design/images/digital-banking/banking-video-thumb.png">
</div>
<div id = "allUserContainerDiv" data-aos="zoom-in-down">
<div id = "alluserDetailsLinks">
<a href="allUserDetailsServlet" class="btn btn-danger" id = "allUserId">All User Details</a>
</div>
<div>
<a href="Removeduserlistservlet" class="btn btn-danger" id = "userDetailId">User Details By UserName</a>
</div>
<div>
<a href="Removeduserlistservlet" class="btn btn-danger" id = "inactiveUserId">Inactive Users List</a>
</div>
</div>
	

<div id = "removeUserDiv"  data-aos="zoom-in-down">
<h1 id = "removeUserHead">Make User Inactive :</h1>
<img alt="" src="https://media.istockphoto.com/photos/red-danger-alarm-bell-or-emergency-notifications-alert-on-rescue-picture-id1321431683?b=1&k=20&m=1321431683&s=170667a&w=0&h=V2lq2ZmjL7CUo6qy9-DddRS3cHkIoH0MnzWr-lAUgmM=" id = "removeUserId">
<a href="removeAccount.jsp" class="btn btn-danger" id = "makeInactiveUserId">Make User Inactive</a>
</div>
<div id = "makeUserInactiveDiv" data-aos="zoom-in-down">
<a href="removeAccount.jsp" class="btn btn-warning" id = "makeUserInactiveTag">Make User Inactive</a>
</div>
<div id = "loginDetailsDiv" data-aos="zoom-out-up">
<h1 id = "loginDetailsHead">Login Details :</h1>
<img alt="" src="https://cdn.pixabay.com/photo/2021/11/18/11/35/attack-6806140_960_720.png" id = "loginDetailsId">
</div>
<div id ="loginDetailstagDiv" data-aos="zoom-out-up">
<a href="logindetailsservlet" id = "loginDetailstag" class="btn btn-success">Login Details</a>
</div>
<jsp:include page="adminPagination.jsp"></jsp:include>

</body>

<script type="text/javascript">

let sbiImage = document.getElementById("slideImage");
let count = 0;
window.addEventListener('load', () =>{	
	
	 i= setInterval(() => {	 
		 count++;
		 if(count == 0){
				sbiImage.src = "https://www.onlinesbi.com/sbijava/images/banner36.jpg";	
			}
		if(count == 1){
			sbiImage.src = "https://www.onlinesbi.com/sbijava/images/banner27.jpg";	
		}
		if(count == 2){
			sbiImage.src = "https://www.onlinesbi.com/sbijava/images/banner33.jpg";	
		}
		if(count == 3){
			sbiImage.src = "https://www.onlinesbi.com/sbijava/images/banner34.jpg";	
		}
		if(count == 4){
			sbiImage.src = "https://www.onlinesbi.com/sbijava/images/banner11.jpg";	
		}
		if(count == 5){
			sbiImage.src = "https://www.onlinesbi.com/sbijava/images/banner35.jpg";	
			count = -1;
		}
		
		console.log(count);
	},2300);
	
});
</script>
<script>
  AOS.init();
</script>
</html>