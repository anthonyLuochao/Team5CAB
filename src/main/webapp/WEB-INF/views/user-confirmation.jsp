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
        <h1 style="text-align: center;">User Details Confirmation</h1>
        <hr>
        <div class="container">
			<p class="text-muted font-italic mb-0 pb-0">User ID</p>
			<h5 class="">${User.userID}</h5>

			<p class="text-muted font-italic mb-0 pb-0">Name</p>
			<h5 class="">${User.name}</h5>

			<p class="text-muted font-italic mb-0 pb-0">Email</p>
			<h5 class="">${User.email}</h5>

			<p class="text-muted font-italic mb-0 pb-0">Address</p>
			<h5 class="">${User.address}</h5>

			<p class="text-muted font-italic mb-0 pb-0">Phone Number</p>
			<h5 class="">${User.phoneNumber}</h5>

			<p class="text-muted font-italic mb-0 pb-0">Birthday</p>
			<h5 class=""><fmt:formatDate value="${User.dob}" pattern="MM/dd/yyyy" /></h5>

			<p class="text-muted font-italic mb-0 pb-0">Role</p>
			<h5 class="">${User.role}</h5>
	
			<div class="text-center">
				<c:if test="${sessionScope.role==admin}">
					<a href="/team5cab/admin/users/search" class="btn btn-secondary">Back to Search Users</a>
				</c:if>
				<a href="/team5cab/welcome" class="btn btn-secondary">Home</a>
			</div>
        </div>
    </body>
</html>
