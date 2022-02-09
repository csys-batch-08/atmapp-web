<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.css"
	rel="stylesheet" />
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"
	integrity=""></script>
<style type="text/css">
#cardImageId {
	position: relative;
	left: 150px;
}

#registerContainer {
	position: relative;
	top: 50px;
}

#navBar {
	position: relative;
}

#roleImg {
	position: relative;
	width: 30px;
}
</style>
</head>
<body>
	<div id="navBar">
		<jsp:include page="adminNavBar.jsp" />
	</div>
	<div id="registerContainer">
		<section class="vh-100" style="background-color: #eee;">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-lg-12 col-xl-11">
						<div class="card text-black" style="border-radius: 25px;">
							<div class="card-body p-md-5">
								<div class="row justify-content-center">
									<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

										<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Register</p>

										<form class="mx-1 mx-md-4" action="registersucc" method="post"
											onsubmit="return cnfpass()">

											<div class="d-flex flex-row align-items-center mb-4">
												<em class="fas fa-user fa-lg me-3 fa-fw"></em>
												<div class="form-outline flex-fill mb-0">
													<input type="text" class="form-control" name="userreg"
														onkeyup="userNameCheck()" pattern="[A-Z][a-zA-Z]{3,20}"
														title="Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character"
														required="required" id="userRegistration" /> <label
														class="form-label" for="form3Example1c">User Name</label>
												</div>
											</div>

											<div class="d-flex flex-row align-items-center mb-4">
												<em class="fas fa-envelope fa-lg me-3 fa-fw"></em>
												<div class="form-outline flex-fill mb-0">
													<input type="text" id="form3Example3c" class="form-control"
														name="mobnoreg" pattern="[6-9][0-9]{9}"
														title="Enter 10 digit mobile number" required="required" />
													<label class="form-label" for="form3Example3c">Mobile
														Number</label>
												</div>
											</div>

											<div class="d-flex flex-row align-items-center mb-4">
												<em class="fas fa-lock fa-lg me-3 fa-fw"></em>
												<div class="form-outline flex-fill mb-0">
													<input type="password" class="form-control" name="passreg"
														pattern="[A-Za-z0-9!@#$%^&*_+=-~`/|\]{6,20}" minlength="6"
														title="minimum 6 character and special characters allowed"
														required="required" id="passid" /> <label
														class="form-label" for="form3Example4c">Password</label>
												</div>
											</div>

											<div class="d-flex flex-row align-items-center mb-4">
												<em class="fas fa-key fa-lg me-3 fa-fw"></em>
												<div class="form-outline flex-fill mb-0">
													<input type="password" class="form-control"
														name="cnfpassreg"
														pattern="[A-Za-z0-9!@#$%^&*_+=-~`/|\]{6,20}" minlength="6"
														title="minimum 6 character and special characters allowed"
														required="required" id="cnfpassid" /> <label
														class="form-label" for="form3Example4cd">Repeat
														your password</label>
												</div>
											</div>

											<div class="d-flex flex-row align-items-center mb-4">
												<img alt="" src="assets/images/businessman.png" id="roleImg">
												<div class="form-outline flex-fill mb-0">
													<input type="password" id="form3Example4cd"
														class="form-control" name="rolereg" pattern="[a-z]{4,5}"
														title="use a-z for role" required="required" /> <label
														class="form-label" for="form3Example4cd" id='roleInput'>Role</label>
												</div>
											</div>

											<div class="form-check d-flex justify-content-center mb-5">
												<input class="form-check-input me-2" type="checkbox"
													value="" id="form2Example3c" /> <label
													class="form-check-label" for="form2Example3"> I
													agree all statements in <a href="#!">Terms of service</a>
												</label>
											</div>

											<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
												<button type="submit" class="btn btn-primary btn-lg">Register</button>
											</div>
										</form>
									</div>
									<div
										class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
										<img
											src="https://www.sbicard.com/sbi-card-en/assets/media/images/personal/credit-cards/lifestyle/card-faces/sbi-card-elite.png"
											alt="sry" id="cardImageId">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"
	integrity=""></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11" integrity=""></script>
<script>
	let pass1 = document.getElementById("passid");
	let pass2 = document.getElementById("cnfpassid");
	function cnfpass() {
		if (pass1.value != pass2.value) {
			console.log(pass1.value);
			Swal.fire('Password Must Be Same!!', '', 'question')
			return false;
		}
		return true;
	}
</script>

<script>
	function userNameCheck() {

		let user = document.getElementById("userRegistration").value;
		$.ajax({
			type : 'POST',
			url : 'userNameExistCheckServlet',
			type : 'POST',
			data : 'userName=' + user,
			cache : false,
			success : function(response) {
				if (response != "") {
					Swal.fire({
						icon : 'error',
						title : 'Oops...',
						text : response,
						footer : 'Try Another UserName'
					})
				} else {
					return true;
				}

			}
		});
	}
</script>
</html>