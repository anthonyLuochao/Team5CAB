<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
   <h1 class="text-center">Registration Form</h1>

    <div class="container">

        <div class="card">

            <div class="card-body">

                <form class="needs-validation" novalidate>

                    <div class="form-row">

                        <div class="col-md-4 mb-3">

                            <label for="validationCustom01">Name</label>

                            <input type="text" class="form-control" id="validationCustom01" placeholder="Name" value="Mark" required>

                            <div class="invalid-feedback">

                                Please provide the name.

                            </div>

                        </div>

                        <div class="col-md-4 mb-3">

                            <label for="validationCustom02">UserID</label>

                            <input type="text" class="form-control" id="validationCustom02" placeholder="UserID" value="Otto" required>

                            <div class="invalid-feedback">

                                Please provide the UserID.

                            </div>

                        </div>

                        <div class="col-md-4 mb-3">

                            <label for="validationCustomUsername">Email</label>

                            <div class="input-group">

                                <div class="input-group-prepend">

                                    <span class="input-group-text" id="inputGroupPrepend">@</span>

                                </div>

                                <input type="text" class="form-control" id="validationEmail" placeholder="Email" aria-describedby="inputGroupPrepend" required>

                                <div class="invalid-feedback">

                                    Please provide the email.

                                </div>

                            </div>

                        </div>

                    </div>

                    <div class="form-row">

                        <div class="col-6 col-md-4">

                            <label for="validationCustom03">Phone number</label>

                            <input type="text" class="form-control" id="validationCustom03" placeholder="Phone number" required>

                            <div class="invalid-feedback">

                                Please provide a phone number.

                            </div>

                        </div>

                        <div class="col-6 col-md-4">

                            <label for="validationCustom04">Passward</label>

                            <input type="text" class="form-control" id="validationCustom04" placeholder="passward" required>

                            <div class="invalid-feedback">

                                Please provide a passward.

                            </div>

                        </div>

                        <div class="col-6 col-md-4">

                            <label for="validationCustom05">Confirm passward</label>

                            <input type="text" class="form-control" id="validationCustom05" placeholder="Confirm passward" required>

                            <div class="invalid-feedback">

                                Please write the passward again.

                            </div>

                        </div>

                    </div>

                    <div class="row">

                        <div class="col-sm-4">

                            <label for="validationCustom05">Address</label>

                            <input type="text" class="form-control" id="validationCustom05" placeholder="Address" required>

                            <div class="invalid-feedback">

                                Please provide the address.

                            </div>

                        </div>

                        <div class="col-sm-8">

                            <label for="Regisatration">Registration Date</label>

                            <input id="RegistrationDate" class="form-control" type="date" value="2011-01-13" />

                        </div>

                       



                    </div>

                    <div class="form-group">

                        <div class="form-check">

                            <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>

                            <label class="form-check-label" for="invalidCheck">

                                Agree to terms and conditions

                            </label>

                            <div class="invalid-feedback">

                                You must agree before submitting.

                            </div>

                        </div>

                    </div>

                    <button class="btn btn-primary" type="submit">Submit form</button>

                </form>

            </div>

        </div>

    </div>



                <script>

                    // Example starter JavaScript for disabling form submissions if there are invalid fields

                    (function () {

                        'use strict';

                        window.addEventListener('load', function () {

                            // Fetch all the forms we want to apply custom Bootstrap validation styles to

                            var forms = document.getElementsByClassName('needs-validation');

                            // Loop over them and prevent submission

                            var validation = Array.prototype.filter.call(forms, function (form) {

                                form.addEventListener('submit', function (event) {

                                    if (form.checkValidity() === false) {

                                        event.preventDefault();

                                        event.stopPropagation();

                                    }

                                    form.classList.add('was-validated');

                                }, false);

                            });

                        }, false);

                    })();

                </script>
</body>
</html>