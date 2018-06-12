<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
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
                <p class="text-muted font-italic mb-0 pb-0">User ID</p>
                
                <h5 ><c:out value="${Users.userID}"/></h5>
    
                <p class="text-muted font-italic mb-0 pb-0">Name</p>
               
                <h5 class=""><c:out value="${Users.name}"/></h5>
    
                <p class="text-muted font-italic mb-0 pb-0">Email</p>
                <h5 class=""><c:out value="${Users.email}"/></h5>
    
                <p class="text-muted font-italic mb-0 pb-0">Address</p>
                <h5 class=""><c:out value="${Users.address }"/></h5>
    
                <p class="text-muted font-italic mb-0 pb-0">Phone Number</p>
                <h5 class=""><c:out value="${Users.phoneNumber}"/></h5>

                <p class="text-muted font-italic mb-0 pb-0">Birthday</p>
                <h5 class=""><fmt:formatDate value="${Users.dob}" pattern="MM/dd/yyyy" /></h5>
    
                <p class="text-muted font-italic mb-0 pb-0">Role</p>
                <h5 class=""><c:out value="${Users.role}"/></h5>
        
                <div class="text-center">
                    <button type="submit" id='validateDate' class="btn " >Back to Create Users</button>
                    <button type="submit" id='validateDate' class="btn " >Home</button>
                </div>
        </div>
    </body>
</html>
