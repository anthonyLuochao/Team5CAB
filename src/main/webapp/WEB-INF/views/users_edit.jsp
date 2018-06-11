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
            <form action="" method="post" class="col-12 card-body justify-content-center">
                <p class="text-muted font-italic mb-0 pb-0">User ID</p>
                <h5 class="">User ID</h5>

                <p class="text-muted font-italic mb-0 pb-0">Name</p>
                <h5 class="mb-3">Name</h5>

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