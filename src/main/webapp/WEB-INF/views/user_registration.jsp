<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

	<h1 class="text-center">Registration Form</h1>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<form:form class="needs-validation" action="team5cab/public/register" modelAttribute="Users">
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label for="validationCustom01">Name</label> <form:input type="text"
								class="form-control" id="validationCustom01" placeholder="Name"
								required="required" path="name" />
							<div class="invalid-feedback">Please provide the name.</div>
						</div>

						<div class="col-md-4 mb-3">

							<label for="validationCustom02">UserID</label> 
							<form:input type="text"
								class="form-control" id="validationCustom02"
								placeholder="UserID" path="userID" required="required" />
							<div class="invalid-feedback">Please provide the UserID.</div>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationCustomUsername">Email</label>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroupPrepend">@</span>
								</div>
								<form:input type="text" class="form-control" id="validationEmail"
									placeholder="Email" aria-describedby="inputGroupPrepend"
									required="required" path="email"/>

								<div class="invalid-feedback">Please provide the email.</div>

							</div>

						</div>

					</div>

					<div class="form-row">
							<div class="col-6 col-md-4 mb-3">
									<label for="validationCustom03">Phone number</label>
									<form:input type="text" class="form-control" id="validationCustom03" 
									placeholder="Phone number" path="phoneNumber" required="required"/>
									<div class="invalid-feedback">
										Please provide a phone number.
									</div>
								</div>
								<div class="col-6 col-md-4 mb-3">
									<label for="validationCustom04">Password</label>
									<form:input type="text" class="form-control" id="validationCustom04" 
									placeholder="Password" required="required" path="password"/>
									<div class="invalid-feedback">
										Please provide a password.
									</div>
								</div>
								<div class="col-6 col-md-4 mb-3">
									<label for="validationCustom05">Confirm Password</label>
									<input type="text" class="form-control" id="validationCustom05" placeholder="Confirm password" required>
									<div class="invalid-feedback">
										Please ensure that this is same as your password.
								</div>
							</div>
					   </div>

					   <div class="form-row">
							<div class=" col-6 col-sm-4 mb-3">
								<label for="validationCustom05">Address</label>
								<form:input type="text" class="form-control" id="validationCustom05" placeholder="Address" 
								required="required" path="address"/>
								<div class="invalid-feedback">
									Please provide the address.
								</div>
							</div>
							<div class="col-6 col-sm-8 mb-3">
								<label for="Regisatration">Date of Birth</label>
								<div class="input-group mb-3 date input-daterange" data-provide="datepicker">
									<form:input type="text" class="form-control" placeholder="Choose Start Date"
									path="dob"/>
									<div id="validation-text" class="mb-3">
									</div>
								</div>
								
							</div>

						</div>

					<div class="form-group">

						<div class="form-check">

							<input class="form-check-input" type="checkbox" value=""
								id="invalidCheck" required> <label
								class="form-check-label" for="invalidCheck"> Agree to
								terms and conditions </label>

							<div class="invalid-feedback">You must agree before
								submitting.</div>

						</div>

					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" />
					</div>
				</form:form>

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
			            <script >
			            function checkPass()
			            {
			                //Store the password field objects into variables ...
			                var pass1 = document.getElementById('pass1');
			                var pass2 = document.getElementById('pass2');
			                //Store the Confimation Message Object ...
			                var message = document.getElementById('confirmMessage');
			           
			                if(pass1.value == pass2.value){
			                    
			                    message.innerHTML = "Passwords Match!"
			                }else{
			                    
			                    message.innerHTML = "Passwords Do Not Match!"
			                }
			            }  				
						</script>
</body>
</html>