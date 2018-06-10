<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

</head>
<body>
    <nav class="navbar navbar-expand-lg">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="justify-content-end collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="facilityDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                    <a class="nav-link dropdown-toggle" href="#" id="bookingDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                    <a class="nav-link dropdown-toggle" href="#" id="usersDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                <li class="nav-item"><a class="nav-link" href="">Login</a></li> 
                <li class="nav-item"><a class="nav-link" href="">Register</a></li> 
                </ul>
            </div>
    </nav>

    <div class="container text-left">
        <h1 class="text-center">Edit user</h1>
        <div class="card mt-5">        
            <form action="" method="post" class="col-12 card-body justify-content-center">
                <p class="text-muted font-italic mb-0 pb-0">User ID</p>
                <h5 class="">Actual User ID</h5>

                <p class="text-muted font-italic mb-0 pb-0">Name</p>
                <h5 class="mb-3">Actual Name</h5>

                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="User ID" aria-describedby="inputGroup-sizing-default" placeholder="User ID">
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Name">
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Email">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">@example.com</span>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Address">
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Phone Number">
                </div>
                <p class="text-muted font-italic mb-0 pb-0">Birthday</p>
                <h5 class="mb-3">03/05/1943</h5>
                <div class="input-group mb-3">
                    <select name="role" id="role" class="form-control">
                        <option selected disabled>Role</option>
                        <option value="1">Member</option>
                        <option value="2">Administrator</option>
                    </select>
                </div>
                <input type="button" class="btn btn-secondary" value="Cancel">
                <input type="button" class="btn btn-primary" value="Add user">
            </form>
        </div>
    </div>    
</body>
</html>