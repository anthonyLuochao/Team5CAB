<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create Booking</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<cab:headImports />
</head>

<body>
	<cab:nav /> 
    <!--End of template-->

    <h1 style="text-align: center;">Create Booking</h1>
    <hr>
    <div class="container">
        <div class="card mt-5">
            <c:if test="${bookingWarning}">
            <div class="alert alert-danger" role="alert">
			 	Sorry! The dates you selected have an existing booking.Please try for other dates!
			</div>
			</c:if>
            <form:form action="team5cab/admin/booking/create/{facility.facilityID}" method="post" class="col-12 card-body" modelAttribute="booking">
                <div class="input-group mb-3">
                    <form:hidden path="facility.facilityID" />
                    <input type="text" class="form-control" name="facilityName" value="${booking.facility.facilityName}" disabled />
                    <form:hidden path="users.userID" />
                    <c:if test="${sessionScope.role ==\"admin\"}" >
                     	 <label class="form-check-label ml-5 pt-1">
                        <form:checkbox path="isUnderMaintenance" class="form-check-input" value=""/>For Maintenance
                    	</label>	
                    </c:if>
                </div>
                <div class="input-group date input-daterange mb-3" data-provide="datepicker">
                    <form:input type="text" class="form-control" id="booking-start" placeholder="Choose Start Date" path="startDate"/>
                    <div class="input-group-addon">to</div>
                    <form:input type="text" class="form-control" id="booking-end" placeholder="Choose End Date" path="endDate" />
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary mb-3">Book</button>
                </div>
                <div class="text-center">             
                </div> 
            </form:form>
 			
 			
        </div>

    </div>
</body>

<script>
var dateToday = new Date();
var dates = $("#booking-start, #booking-start").datepicker({
    defaultDate: "+1w",
    changeMonth: true,
    numberOfMonths: 3,
    minDate: dateToday,
    onSelect: function(selectedDate) {
        var option = this.id == "from" ? "minDate" : "maxDate",
            instance = $(this).data("datepicker"),
            date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
        dates.not(this).datepicker("option", option, date);
    }
});
</script>
