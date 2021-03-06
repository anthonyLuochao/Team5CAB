<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<cab:headImports />
<title>Account Logout</title>
</head>
<body>
	<cab:nav />
	<form:form id="form2" action="team5cab/public/logout" modelAttribute="Users">
	<div class="container">
	
		<div class="row justify-content-center">
			<div class="col-lg-4 text-center">
				<div class="card">
					<h5 class="card-header">Log out</h5>
					<div class="card-body">
						<p class="text-center">Hi there!</p>
						<p class="text-center">You have now logged out. Click below to log in again.</p>
						<p class="text-center">
						<a href="team5cab/public/login" class="btn btn-primary">Log In</a>
					</div>
				</div>
			</div>
	
		</div>
	</div>
	</form:form>
</body>
</html>