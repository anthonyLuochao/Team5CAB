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
<script>
	$('.datepicker').datepicker({
		format : 'mm/dd/yyyy',
		startDate : '-3d'
	});
</script>
<title>Add new user</title>

</head>
<body>
<cab:nav />
	<div class="container text-left">
		<h1 class="text-center">Add new user</h1>
		<div class="card mt-5">
			<form action="" method="post" class="col-12 card-body justify-content-center">
				<div class="input-group mb-3">
					<input type="text" class="form-control" aria-label="User ID"
						aria-describedby="inputGroup-sizing-default" placeholder="User ID">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" aria-label="Default"
						aria-describedby="inputGroup-sizing-default" placeholder="Name">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" aria-label="Default"
						aria-describedby="inputGroup-sizing-default" placeholder="Email">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-default">@example.com</span>
					</div>
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" aria-label="Default"
						aria-describedby="inputGroup-sizing-default" placeholder="Address">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" aria-label="Default"
						aria-describedby="inputGroup-sizing-default" placeholder="Phone Number">
				</div>
				<div class="input-group date mb-3" data-provide="datepicker">
					<input id="birthday" name="birthday" placeholder="DD/MM/YYYY" type="text"
						class="datepicker form-control" data-date-format="dd/mm/yyyy">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-th"></span>
					</div>
				</div>
				<div class="input-group mb-3">
					<select name="role" id="role" class="form-control">
						<option selected disabled>Role</option>
						<option value="1">Member</option>
						<option value="2">Administrator</option>
					</select>
				</div>
				<input type="button" class="btn btn-secondary" value="Cancel"> <input
					type="button" class="btn btn-primary" value="Add user">
			</form>
		</div>
	</div>
</body>
</html>