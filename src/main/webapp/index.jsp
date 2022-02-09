<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<div id="bgBlur"></div>
<title>State Bank Of India</title>
<link rel="stylesheet" href="Bank.css">
<link rel="stylesheet" type="" href="assets/css/index.css">
</head>
<body >
<div class = "animate__animated animate__flash">
<div class="marquee">
	<p><strong> State Bank of India never ask for your user id / password / pin no. through phone call / SMSes / e-mails. Any such phone call / SMSes / e-mails asking you to reveal credential or One Time Password through SMS could be attempt to withdraw money from your account.NEVER share these details to anyone. State Bank of India wants you to be secure. If you come across any such instances please inform us through e-mail to the following address</strong></p>
</div>
</div>
<div class="fullbody">
<div class="one">
<div class="animate__animated animate__bounce">
	<fieldset>
		<legend id="logger" class="form-label">LOGIN</legend>
		
		<form action="loginval" id="formlogin" autocomplete="off" method="post" class = "was-validated">

			<label id="userlab" class="form-label">User Name:</label><br> <input type="text"
				name="username" class="form-control" required id="user" pattern="[A-Z][a-zA-Z]{3,20}"
				title="Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character" autofocus><br>
			<label id="passlab" class="form-label">Password:</label><br> <input type="password"
				name="password" required id="pass" class="form-control"
				pattern="[A-Za-z0-9!@#$%^&*_+=-~`/|\]{6,20}" minlength="6"
				title="minimum 6 character and special characters allowed"><br>
			<button id="sub" type="submit" class="btn btn-success">Submit</button>
			&ensp;&ensp;
			<button type="reset" id="res" class="btn btn-danger">Reset</button>
		</form>
	</fieldset>
	</div>
	</div>
	

<div id = "logintxt" class = "animate__animated animate__fadeInLeft">
<h3 id = "logintLeftText">Be aware of fraudulent emails offering free gifts and rewards. Scammers send these emails to extract money from your account via your personal details. Do not share your bank details with anyone. SBI never asks for your UPI PIN or Card Details.</h3>
</div>
</div>
</body>
<script type="text/javascript">


</script>


</html>