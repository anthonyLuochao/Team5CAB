<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab" %>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<cab:headImports />
</head>

<body>
	<cab:nav /> 
    <!--End of template-->

    <h1 style="text-align: center;">Create Booking</h1>
    <hr>
    <div class="container">
        <div class="card mt-5">
            <form action="" method="post" class="col-12 card-body">

                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="Facility Name" aria-describedby="InputGroup-sizing-default" placeholder="Facility Name"
                        disabled />
                    <label class="form-check-label ml-5 pt-1" hidden>
                        <input type="checkbox" class="form-check-input" value="">For Maintenance
                    </label>
                </div>
                <div class="input-group date input-daterange mb-3" data-provide="datepicker">
                    <input type="text" class="form-control" id="booking-start" placeholder="Choose Start Date">
                    <div class="input-group-addon">to</div>
                    <input type="text" class="form-control" id="booking-end" placeholder="Choose Start Date">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary mb-3" onclick="">Book</button>
                </div>
            </form>
        </div>

    </div>
</body>
