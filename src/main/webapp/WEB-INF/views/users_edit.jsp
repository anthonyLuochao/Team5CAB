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
<title>Edit user details</title>
</head>
<body>
<cab:nav />
<div class="container text-left">
        <h1 class="text-center">Edit user</h1>
        <div class="card mt-5">
            <form action="" method="post" class="col-12 card-body justify-content-center needs-validation" novalidate>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="User ID" aria-describedby="inputGroup-sizing-default" placeholder="User ID"
                        required>
                    <div class="invalid-feedback mb-3">
                        Please provide UserID.
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Name"
                        required>
                    <div class="invalid-feedback mb-3">
                        Please provide Name.
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Email"
                        required>
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">@example.com</span>
                    </div>
                    <div class="invalid-feedback mb-3">
                        Please provide email.
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Address"
                        required>
                    <div class="invalid-feedback mb-3">
                        Please provide Address.
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Phone Number"
                        required>
                    <div class="invalid-feedback mb-3">
                        Please provide Phone number.
                    </div>
                </div>
                <p class="text-muted font-italic mb-0 pb-0">Birthday</p>
                <h5 class="mb-3">03/05/1943</h5>
                <div class="input-group mb-3">
                    <select name="role" id="role" class="form-control" required>
                        <option value="" selected disabled>Role</option>
                        <option value="1">Member</option>
                        <option value="2">Administrator</option>
                    </select>
                    <div class="invalid-feedback mb-3">
                        Please provide Role.
                    </div>
                </div>

                <div class="text-center">
                    <input type="submit" class="btn btn-secondary" value="Cancel">
                    <input type="submit" class="btn btn-primary" value="Add user">
                </div>
            </form>
        </div>
    </div>
</body>
</html>