<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab"%>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<cab:headImports />
<title>Registration</title>
</head>
<body>
	<cab:nav />
	<div class="container">
		<div class="card">
			<div class="card-header">Registration Form</div>
			<div class="card-body">
				<form class="needs-validation" novalidate>
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="validationCustom01">Name</label> <input type="text"
								class="form-control" id="validationCustom01" placeholder="Name"
								value="" required>
							<div class="invalid-feedback">Please provide the name.</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustom02">UserID</label> <input type="text"
								class="form-control" id="validationCustom02" placeholder="UserID"
								value="" required>
							<div class="invalid-feedback">Please provide the UserID.</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomUsername">Email</label>
							<div class="input-group">
								<input type="text" class="form-control" id="validationEmail"
									placeholder="Email" aria-describedby="inputGroupPrepend" required>
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroupPrepend">@eg.com</span>
								</div>
								<div class="invalid-feedback">Please provide the email.</div>
							</div>
						</div>
					</div>
					<div class="form-row">
						<div class="col-6 col-md-4">
							<label for="validationCustom03">Phone number</label> <input type="text"
								class="form-control" id="validationCustom03" placeholder="Phone number"
								required>
							<div class="invalid-feedback">Please provide a phone number.</div>
						</div>
						<div class="col-6 col-md-4">
							<label for="validationCustom04">Password</label> <input type="text"
								class="form-control" id="validationCustom04" placeholder="password"
								required>
							<div class="invalid-feedback">Please provide a password.</div>
						</div>
						<div class="col-6 col-md-4">
							<label for="validationCustom05">Confirm password</label> <input
								type="text" class="form-control" id="validationCustom05"
								placeholder="Confirm password" required>
							<div class="invalid-feedback">Please write the password again.</div>
						</div>
					</div>
					<div class="form-row mt-3">
						<div class="col-sm-8 col-8">
							<label for="validationCustom05">Address</label> <input type="text"
								class="form-control" id="validationCustom05" placeholder="Address"
								required>
							<div class="invalid-feedback">Please provide the address.</div>
						</div>
						<div class="col-sm-4 col-4">
							<label for="validationCustom06">Date of Birth</label> <input
								class="form-control" type="date" id="validationCustom06" required/>
							<div class="invalid-feedback">Please provide your birthday.</div>
						</div>
					</div>
					<div class="form-row my-3 ml-1">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value=""
								id="invalidCheck" required> <label class="form-check-label"
								for="invalidCheck"> I agree to the terms and conditions </label>
							<div class="invalid-feedback">You must agree before submitting.</div>
						</div>
					</div>
					<button class="btn btn-primary" type="submit">Submit form</button>
				</form>
			</div>
		</div>
	</div>

	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Fetch all the forms we want to apply custom Bootstrap validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');
						// Loop over them and prevent submission
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();
	</script>
</body>
</html>