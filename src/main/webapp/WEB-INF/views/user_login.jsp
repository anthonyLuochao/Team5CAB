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
<title>Login</title>
</head>
<body>
	<cab:nav />
	<form id="form1" runat="server">
		<div class="container">
			<div class="page-header text-center">
				<h1>CAB</h1>
			</div>
			<div class="row justify-content-center">
				<div class="col-lg-4">
					<div class="card">
						<div class="card-header">
							Login
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="usr">Name:</label> <input type="text" class="form-control"
									id="usr">
							</div>
							<div class="form-group">
								<label for="pwd">Password:</label> <input type="password"
									class="form-control" id="pwd">
							</div>
							<div class="checkbox">
								<input type="checkbox" value=""> <label class="form-check-label"
									for="exampleCheck1">Remember me next time</label>
							</div>
							<button type="button" id="button_signup" class="btn">Sign up</button>
							<button type="button" id="button_login1" class="btn">Log in</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>