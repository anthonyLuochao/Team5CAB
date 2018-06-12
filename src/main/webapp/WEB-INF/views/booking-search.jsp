<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search Booking</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<cab:headImports />

</head>

<body>
	<cab:nav />

	<!--End of template-->

	<h1 style="text-align: center;">Search Booking</h1>
    <hr>
    <div class="container">
        <card class="card mt-5">
            <form action="POST" method="post" class="col-12 card-body needs-validation" novalidate>

                <div class="input-group mb-3">
                    <form:select path= "listOfFacilityType" required="required" id="facility-type" class="form-control">
                        <option value="" selected disabled>Select your facility Type</option>
                        <form:options items="${listOfFacilityType}" />
                       
                    </form:select>
                    <div class="invalid-feedback">
                        Please select Facility Type
                    </div>
                </div>
                <div class="input-group mb-3 date input-daterange" data-provide="datepicker">
                    <input type="text" class="form-control" placeholder="Choose Start Date" >
                    <div class="input-group-addon">to</div>
                    <input type="text" class="form-control" placeholder="Choose Start Date" >

                    <div id="validation-text" class="mb-3">
                    </div>
                </div>
                <div class="input-group mb-3" hidden>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="InputGroup-sizing-default" placeholder="Username"
                    />
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary" onclick="">Search</button>
                </div>
            </form>
        </card>

        <table id="search-booking-table" class="table table-hover" style="margin-top: 100px; display: none">
            <thead>
                <tr>
                    <th>Facility Name</th>
                    <th>Booking Start</th>
                    <th>Booking End</th>
                    <th>Username</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="align-middle">Basketball Court</td>
                    <td class="align-middle">18-Jun-2018</td>
                    <td class="align-middle">18-Jun-2018</td>
                    <td class="align-middle">Hello</td>
                    <td class="align-middle">
                        <button type="button" class="btn btn-secondary">Edit</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td class="align-middle">Football Court</td>
                    <td class="align-middle">21-Jun-2018</td>
                    <td class="align-middle">23-Jun-2018</td>
                    <td class="align-middle">World</td>
                    <td class="align-middle">
                        <button type="button" class="btn btn-secondary">Edit</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td class="align-middle">Tennis Court</td>
                    <td class="align-middle">22-Jun-2018</td>
                    <td class="align-middle">25-Jun-2018</td>
                    <td class="align-middle">!</td>
                    <td class="align-middle">
                        <button type="button" class="btn btn-secondary">Edit</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="deleteModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Confirm Delete</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Booking deleted</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

    <nav class="mt-5">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#">Previous</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">1</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">2</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">3</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </nav>
</body>