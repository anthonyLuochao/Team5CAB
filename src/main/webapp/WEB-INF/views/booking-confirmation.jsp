<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        	<form:form action="team5cab/admin/booking/create/confirmation" method="post" class="col-12 card-body" modelAttribute="booking">
                <p class="text-muted font-italic mb-0 pb-0">User ID</p>
                
                <form:label path="users.userID"></form:label>
                <p>${booking.users.userID}</p>
    
                <p class="text-muted font-italic mb-0 pb-0">Facility Name</p>
                <p>${booking.facility.facilityName}</p>
                   
                <p class="text-muted font-italic mb-0 pb-0">Start Date</p>
                <fmt:formatDate value="${booking.startDate}" pattern="MM-dd-yyyy" />
 
    			
                <p class="text-muted font-italic mb-0 pb-0">End Date</p>
                <fmt:formatDate value="${booking.endDate}" pattern="MM-dd-yyyy" />
   
    		
                <div class="text-center">
                	<a href="/team5cab/admin/booking/create/${booking.facility.facilityID}" class="btn btn-secondary">Back to Create Booking</a>
                	<a href="/team5cab/${sessionScope.role}/welcome" class="btn btn-secondary">Home</a>
                	<!-- 
                    <button type="submit" id='validateDate' class="btn " >Back to Create Booking</button>
                    <button type="submit" id='validateDate' class="btn " >Home</button>
                     -->
                </div>
                </form:form>
        </div>
    </body>
</html>
