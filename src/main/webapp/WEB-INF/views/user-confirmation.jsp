<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab" %>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Booking Confirmation</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <cab:headImports />
    </head>
    
    <body>
    <cab:nav/>
    
        <!--End of template-->
    
        <h1 style="text-align: center;">Booking Confirmation</h1>
        <hr>
        <div class="container">
            <form action="" method="post" class="col-12 card-body needs-validation" novalidate>
                <p class="text-muted font-italic mb-0 pb-0">User ID</p>
                <h5 class="">Actual User ID</h5>
    
                <p class="text-muted font-italic mb-0 pb-0">Name</p>
                <h5 class="">Actual Name</h5>
    
                <p class="text-muted font-italic mb-0 pb-0">Email</p>
                <h5 class="">Bala@email.com</h5>
    
                <p class="text-muted font-italic mb-0 pb-0">Address</p>
                <h5 class="">NUS ISS</h5>
    
                <p class="text-muted font-italic mb-0 pb-0">Phone Number</p>
                <h5 class="">89028023</h5>

                <p class="text-muted font-italic mb-0 pb-0">Birthday</p>
                <h5 class="">10/07/2001</h5>
    
                <p class="text-muted font-italic mb-0 pb-0">Role</p>
                <h5 class="">Admin</h5>
        
                <div class="text-center">
                    <button type="submit" id='validateDate' class="btn " >Back to Create Users</button>
                    <button type="submit" id='validateDate' class="btn " >Home</button>
                </div>
            </form>
        </div>
    </body>
</html>
