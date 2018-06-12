<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<cab:headImports />
	<title>Update Facility</title>
</head>
<body>
	<cab:nav />
	<h1 style="text-align: center;">Update Facility</h1>
	<hr>
	<div class="container">
		<card class="card mt-5" >
			<form:form action="team5cab/facility/update/" method="post" class="col-12 card-body needs-validation" validation="novalidate" modelAttribute="Facility">
				<div class="row">
					<div class="col-4">
						<img src="https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350" id="facilityImg" class="rounded img-fluid mb-3"
							alt="Facility Image"
							 >
						<div class="text-center">
							<button type="button" class="btn" onclick="chooseImg()">Change Image</button>
						</div>
						<form:input path="" type="file" id="my_file" hidden="hidden"
							onchange="document.getElementById('facility-img').src = window.URL.createObjectURL(this.files[0])"/>
					</div>
					<div class="col-8">
						<div class="input-group mb-3">
							<input type="text" class="form-control" aria-label="FacilityID" aria-describedby="InputGroup-sizing-default" placeholder="FacilityID-autogenerated"
								disabled />
						</div>
						<div class="input-group mb-3">
							<select required id="facility-type" class="form-control">
								<option value="facility-type" selected disabled>Facility Type</option>
								<option value="Type1">type 1</option>
								<option value="Type2">type 2</option>
							</select>
						</div>
						<div class="input-group mb-3">
							<input type="text" class="form-control" aria-label="facility-name" aria-describedby="InputGroup-sizing-default" placeholder="Facility Name"
							/>
						</div>
						<div class="input-group mb-3">
							<input type="text" class="form-control" aria-label="facility-address" aria-describedby="InputGroup-sizing-default" placeholder="Facility Address"
							/>
						</div>
						<div class="input-group mb-3">
							<textarea class="form-control" rows="3" id="facility-description" placeholder="Facility Description" required></textarea>
						</div>

						<div class="input-group mb-3">
							<textarea class="form-control" rows="3" id="damage-report" placeholder="Damage Report"></textarea>
						</div>

						<div class="form-check mb-3">
							<label class="form-check-label">
								<input class="form-check-input" id="facility-unusable" type="checkbox" value=""> Facility is unusable
							</label>
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-primary mb-3" onclick="">Update</button>
						</div>
					</div>
					</row>
			</form:form>
		</card>

	</div>
</body>
<script>
        function chooseImg() {
            $('#my_file').trigger("click");
        }
    </script>
</html>