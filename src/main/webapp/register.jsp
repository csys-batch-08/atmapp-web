<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="" href="assets/css/register.css">
<link rel = "icon" type = "" href = "assets/images/sbi-logo-33234.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<div id="bgBlur"></div>
<title>Register User</title>
</head>
<body>
	<c:if test="${admin == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<div class="container mt-1">
		<fieldset id="fieldreg">
			<legend>Register User</legend>

			<form action="registersucc" method="post" id="regform"
				onsubmit="return cnfpass()" autocomplete="off" class="was-validated">
				<label class="form-label">Enter User Name : </label><br> <input
					type="text" name="userreg" placeholder="Abcd9" class="form-control"
					pattern="[A-Z][a-zA-Z]{3,20}"
					title="Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character"
					id="userid" required autofocus="autofocus"> <label class="form-label">Enter
					Password : </label><br> <input type="password" class="form-control"
					name="passreg" placeholder="abcd@89"
					pattern="[A-Za-z0-9!@#$%^&*_+=-~`/|\]{6,20}" minlength="6"
					onclick="invalabfn()"
					title="minimum 6 character and special characters allowed"
					id="passid" required> <label class="form-label">Confirm
					Password : </label><br> <input type="password" class="form-control"
					name="cnfpassreg" placeholder="abcd@89"
					pattern="[A-Za-z0-9!@#$%^&*_+=-~`/|\]{6,20}" minlength="6"
					onclick="invalabfn()"
					title="minimum 6 character and special characters allowed"
					id="cnfpassid" required><label class="form-label">Role
					: </label><br> <input type="text" name="rolereg" class="form-control"
					id="roleregid" placeholder="user,admin,agent" pattern="[a-z]{4,5}"
					title="use a-z for role" required> <label
					class="form-label">Mob_no : </label><br> <input type="text"
					name="mobnoreg" id="mobnoregid" placeholder="mobile number"
					class="form-control" pattern="[6-9][0-9]{9}"
					title="Enter 10 digit mobile number" required><br> <br>
				<br> <label id="reglab">Password Must Be Same</label>
				<button id="regbt" type="submit" class="btn btn-primary">Register</button>
				&ensp;&ensp;&ensp;&ensp;
				<button id="resbt" type="reset" class="btn btn-primary">Reset</button>
			</form>
		</fieldset>
	</div>
	<a href="admin.jsp" class="btn btn-danger" id = "homeTag">Home</a>
</body>
<script src="assets/js/register.js">
	
</script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js" integrity = "">

</script>
<script type="text/javascript">
if(localStorage.getItem("sweetAlertLocal") != null){
	swal({
		  title: "User " + localStorage.getItem("sweetAlertLocal"),
		  text: "Registered Successfully!!",
		  icon: "success",
		  button: "ok",
		});
	localStorage.removeItem("sweetAlertLocal");
}

</script>
</html>