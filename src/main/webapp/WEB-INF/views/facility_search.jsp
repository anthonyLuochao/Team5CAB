<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"

        crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"

        crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"

        crossorigin="anonymous"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"

        crossorigin="anonymous"></script>

    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>



    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"

    />



    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">



    <script src="jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center;">Search Facility</h1>

    <hr>

    <div class="container">

        <card class="card mt-5">

            <form action="" method="post" class="col-12 card-body">



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



                <button type="submit" class="btn btn-primary mb-3" onclick="">Search</button>

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

                        <button type="button" class="btn btn-primay">Book</button>

                        <button type="button" class="btn btn-secondary">Edit</button>

                        <button type="button" class="btn btn-danger">Delete</button>

                    </td>

                </tr>

                <tr>

                    <td class="align-middle">FB-1</td>

                    <td class="align-middle">Football Court</td>

                    <td class="align-middle">Football</td>

                    <td class="align-middle">true</td>

                    <td class="align-middle">

                        <button type="button" class="btn btn-primay">Book</button>

                        <button type="button" class="btn btn-secondary">Edit</button>

                        <button type="button" class="btn btn-danger">Delete</button>

                    </td>

                </tr>

                <tr>

                    <td class="align-middle">T-1</td>

                    <td class="align-middle">Tennis Court</td>

                    <td class="align-middle">Tennis</td>

                    <td class="align-middle">false</td>

                    <td class="align-middle">

                        <button type="button" class="btn btn-primay">Book</button>

                        <button type="button" class="btn btn-secondary">Edit</button>

                        <button type="button" class="btn btn-danger">Delete</button>

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
</body>
</html>