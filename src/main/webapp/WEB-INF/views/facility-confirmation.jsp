<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Confirm Facility Create</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <cab:headImports />
</head>

<body>
    <cab:nav/>

    <!--End of template-->

    <h1 style="text-align: center;">Facility Create Confirmation</h1>
    <hr>
    <div class="container">
        <form:form action="team5cab/facility/create/confirmation" method="post" class="col-12 card-body needs-validation" validate="novalidate" modelAttribute="Facility">
            <p class="text-muted font-italic mb-0 pb-0">Facility ID</p>
            <h5 class="">${facility.facilityID}</h5>

            <p class="text-muted font-italic mb-0 pb-0">Facility Type</p>
            <h5 class="">${facility.facilityType}</h5>

            <p class="text-muted font-italic mb-0 pb-0">Facility Name</p>
            <h5 class="">${facility.facilityName}</h5>

            <p class="text-muted font-italic mb-0 pb-0">Address</p>
            <h5 class="">${facility.address}</h5>

            <p class="text-muted font-italic mb-0 pb-0">Address</p>
            <h5 class="mb-5">${facility.description}</h5>
                <div class="text-center">
                    <button type="submit" id='validateDate' class="btn " onclick="window.location.href='team5cab/facility/create'">Back to Create Facility</button>
                    <button type="submit" id='validateDate' class="btn " onclick="window.location.href='team5cab/welcome'">Home</button>
                </div>
        </form:form>
    </div>
</body>
</html>
