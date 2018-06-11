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
<title>Search Facility</title>
</head>
<body>
	<cab:nav />
	<h1 style="text-align: center;">Search Facility</h1>
    <hr>
    <div class="container">
        <card class="card mt-5">
            <form action="" method="post" class="col-12 card-body needs-validate" novalidate>

                <div class="input-group mb-3">
                    <select required id="facility-type" class="form-control">
                        <option value="" selected disabled>Select your facility type</option>
                        <option value="Type1">Type1</option>
                        <option value="Type2">Type2</option>
                    </select>
                    <label class="form-check-label">

                </div>

                <div class="input-group mb-3 date input-daterange" data-provide="datepicker">
                    <input type="text" class="form-control" placeholder="Choose Start Date">
                    <div class="input-group-addon">to</div>
                    <input type="text" class="form-control" placeholder="Choose Start Date">
                </div>
                <div class="form-check mb-3">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" value=""> Search for unusable facilities
                    </label>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary mb-3" onclick="">Search</button>
                </div>
            </form>
        </card>

        <table id="search-facility-table" class="table table-hover" style="margin-top: 100px;">
            <thead>
                <tr>
                    <th>Facility ID</th>
                    <th>Facility Name</th>
                    <th>Facility Type</th>
                    <th>Unusable</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="align-middle">BB-1</td>
                    <td class="align-middle">Basketball Court</td>
                    <td class="align-middle">Basketball</td>
                    <td class="align-middle">false</td>
                    <td class="align-middle">
                        <button type="button" class="btn btn-primary">Book</button>
                        <button type="button" class="btn btn-secondary">Edit</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td class="align-middle">FB-1</td>
                    <td class="align-middle">Football Court</td>
                    <td class="align-middle">Football</td>
                    <td class="align-middle">true</td>
                    <td class="align-middle">
                        <button type="button" class="btn btn-primary">Book</button>
                        <button type="button" class="btn btn-secondary">Edit</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td class="align-middle">T-1</td>
                    <td class="align-middle">Tennis Court</td>
                    <td class="align-middle">Tennis</td>
                    <td class="align-middle">false</td>
                    <td class="align-middle">
                        <button type="button" class="btn btn-primary">Book</button>
                        <button type="button" class="btn btn-secondary">Edit</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>
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
                    <p>Facility deleted</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
</body>
</html>