<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab"%>
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

    <h1 style="text-align: center;">Facility Create Confirmation</h1>
    <hr>
    <div class="container">
        <form action="" method="post" class="col-12 card-body needs-validation" novalidate>
            <p class="text-muted font-italic mb-0 pb-0">Facility ID</p>
            <h5 class="">000001</h5>

            <p class="text-muted font-italic mb-0 pb-0">Facility Type</p>
            <h5 class="">Actual Facility Type</h5>

            <p class="text-muted font-italic mb-0 pb-0">Facility Name</p>
            <h5 class="">Actual Facility Name</h5>

            <p class="text-muted font-italic mb-0 pb-0">Address</p>
            <h5 class="">NUS ISS</h5>

            <p class="text-muted font-italic mb-0 pb-0">Address</p>
            <h5 class="mb-5">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Aspernatur aliquid unde repudiandae culpa eos tempore eligendi aut.
                Sapiente facere debitis laboriosam quo nobis saepe odio voluptates ad hic, aspernatur maiores! Ullam, eaque
                vero id animi alias enim porro molestiae quod quam fugit saepe! Esse cupiditate quos earum eos, nobis fugiat
                dignissimos suscipit nesciunt neque ipsa quis, voluptatem sapiente aliquam amet. Atque, enim adipisci molestias
                est quo voluptas fugiat aperiam ex nam vitae, saepe dolor reiciendis ipsam quam harum nisi ducimus quos reprehenderit
                quasi consectetur recusandae? Sunt illum alias facilis debitis?</h5>

                <div class="text-center">
                    <button type="submit" id='validateDate' class="btn " >Back to Create Facility</button>
                    <button type="submit" id='validateDate' class="btn " >Home</button>
                </div>
        </form>
    </div>
</body>
</html>
