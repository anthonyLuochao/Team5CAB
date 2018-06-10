<head>
    <title>Search Booking</title>
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


    <script>
        $(document).ready(function () {
            var date_input = $('input[name="date"]'); //our date input has the name "date"
            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
            date_input.datepicker({
                format: 'dd/mm/yyyy',
                container: container,
                todayHighlight: true,
                autoclose: true,
            })
            $.fn.datepicker.defaults.format = "dd/mm/yyyy";
        })
    </script>

    <script>
        function search() {
            document.getElementById('search-booking-table').style.display = "";
        }
    </script>
</head>

<body>
    <nav class="navbar navbar-expand-lg">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="justify-content-end collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="facilityDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false">
                        Facility
                    </a>
                    <div class="dropdown-menu" aria-labelledby="facilityDropdown">
                        <a class="dropdown-item" href="#">Add Facility</a>
                        <a class="dropdown-item" href="#">Search Facility</a>
                        <a class="dropdown-item" href="#">Update Facility</a>
                        <a class="dropdown-item" href="#">Delete Facility</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="bookingDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false">
                        Booking
                    </a>
                    <div class="dropdown-menu" aria-labelledby="bookingDropdown">
                        <a class="dropdown-item" href="#">Add Booking</a>
                        <a class="dropdown-item" href="#">Search Booking</a>
                        <a class="dropdown-item" href="#">Update Booking</a>
                        <a class="dropdown-item" href="#">Delete Booking</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="usersDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false">
                        Users
                    </a>
                    <div class="dropdown-menu" aria-labelledby="usersDropdown">
                        <a class="dropdown-item" href="#">Add User</a>
                        <a class="dropdown-item" href="#">Search User</a>
                        <a class="dropdown-item" href="#">Update User</a>
                        <a class="dropdown-item" href="#">Delete User</a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Register</a>
                </li>
            </ul>
        </div>
    </nav>

    <!--End of template-->

    <h1 style="text-align: center;">Search Booking</h1>
    <hr>
    <div class="container">
        <card class="card mt-5">
            <form action="POST" method="post" class="col-12 card-body">

                <div class="input-group mb-3">
                    <select required id="facility-type" class="form-control">
                        <option value="" selected disabled>Select your facility Type</option>
                        <option value="Facility1">Facility Type 1</option>
                        <option value="Facility2">Facility Type 2</option>
                    </select>
                </div>
                <div class="input-group mb-3 date input-daterange" data-provide="datepicker">
                    <input type="text" class="form-control" placeholder="Choose Start Date">
                    <div class="input-group-addon">to</div>
                    <input type="text" class="form-control" placeholder="Choose Start Date">
                </div>
                <div class="input-group mb-3" hidden>
                    <input type="text" class="form-control" aria-label="Username" aria-describedby="InputGroup-sizing-default" placeholder="Username"
                    />
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary" onclick="search()">Search</button>
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