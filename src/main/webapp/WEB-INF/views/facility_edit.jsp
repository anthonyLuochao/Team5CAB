<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<cab:headImports />
	<title>Edit Facility</title>
</head>
<body>
	<cab:nav />
	<h1 style="text-align: center;">Edit Facility</h1>
	<hr>
	<div class="container">

		<div class="card mt-5">
		 <form:form	action="/team5cab/facility/update" method="post" class="col-12 card-body needs-validate" modelAttribute="Facility">
		<!-- 	<form action="" method="post" class="col-12 card-body needs-validation" > -->
				<div class="row">
					<div class="col-4">
						<img src="https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350" id="facilityImg" class="rounded img-fluid mb-3"
							alt="Facility Image"
							 >
						<div class="text-center">
							<!-- <button type="button" class="btn" onclick="chooseImg()">Change Image</button>  -->
						</div>

						<!-- <form:input path="facilityID" type="file" id="my_file" required="required"/> -->
					</div>
					<div class="col-8">
						
						<div class="input-group mb-3">
							<form:hidden path="facilityID" />
							<form:hidden path="facilityType.typeID" />
							<form:hidden path="facilityType.typeName" />
							<input value="${Facility.facilityType.typeName}" disabled class="form-control" />				
						</div>
						<div class="input-group mb-3">
							<form:input type="text" path="facilityName" class="form-control" aria-label="facility-name" aria-describedby="InputGroup-sizing-default" placeholder="Facility Name"/>
						</div>
						
						<div class="input-group mb-3">
							<form:input type="text" class="form-control" path="address" aria-label="facility-address" aria-describedby="InputGroup-sizing-default" placeholder="Facility Address"
							/>
						</div>
						<div class="input-group mb-3">
							<form:textarea class="form-control" path="description" rows="3" cols="50" aria-label="facility-description" aria-describedby="InputGroup-sizing-default" placeholder="Facility Desription"/>
						</div>

						<div class="input-group mb-3">
							<form:textarea class="form-control" path="damageReason" rows="3" aria-label="Damage Reason" aria-describedby="InputGroup-sizing-default"  placeholder="Damage Report"/>
						</div>

						<div class="form-check mb-3">
							<label class="form-check-label">
								<form:checkbox class="form-check-input" value="Facility is unusable" path="isDamaged" id="facility-unusable" />Facility is unusable
							</label>
						</div>
						<div class="text-center">
							<input type="submit" value="Update" class="btn btn-primary"/>
						</div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</body>
</html>