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
<title>Forget Password</title>
</head>
<body>
	<cab:nav />
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-4">
				<div class="card">
					<div class="card-header">Forget Password</div>
					<div class="card-body">
						<form method="post" enctype="multipart/form-data"
							action="Your_Action_Page.php">
							<p>Password:</p>
							<input class="form-control" name="password" required type="password" id="password" />
							<p>Confirm Password:</p>
							<input class="form-control mb-3" name="password_confirm" required type="password"
								id="password_confirm" oninput="check(this)" />
							<script language='javascript' type='text/javascript'>
								function check(input) {
									if (input.value != document
											.getElementById('password').value) {
										input.setCustomValidity('Password Must be Matching.');
									} else {
										// input is valid -- reset the error message
										input.setCustomValidity('');
									}
								}
							</script>
							<div class="row">
								<button type="button" id="button_cancel" class="btn btn-secondary mx-3">Cancel</button>
								<input class="btn btn-primary mx-3" value="Ok" type="submit" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>