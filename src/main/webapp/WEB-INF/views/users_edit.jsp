<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
                 
            <form:form action="team5cab/admin/user/edit" method="post" modelAttribute="User" class="col-12 card-body justify-content-center needs-validation">
            	<p class="text-muted font-italic mb-0 pb-0">UserID</p>
            	<div class="form-group">
					<input type="text" class="form-control" value="${User.userID}" disabled >
				</div>
				<p class="text-muted font-italic mb-0 pb-0">UserName</p>
				<div class="form-group">
					<input type="text" class="form-control" value="${User.name}" disabled>
				</div>
				<form:hidden path="userID"/>
				<form:hidden path="name"/>
				<p class="text-muted font-italic mb-0 pb-0">Email</p>
                <div class="input-group mb-3">
                    <form:input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Email"
                        required="required" path="email" />
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">@example.com</span>
                    </div>
                    <div class="invalid-feedback mb-3">
                        Please provide email.
                    </div>
                </div>
                <p class="text-muted font-italic mb-0 pb-0">Address</p>
                <div class="input-group mb-3">
                    <form:input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Address"
                        required="required" path="address" />
                    <div class="invalid-feedback mb-3">
                        Please provide Address.
                    </div>
                </div>
                <p class="text-muted font-italic mb-0 pb-0">PhoneNumber</p>
                <div class="input-group mb-3">
                    <form:input type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" placeholder="Phone Number"
                        required="required" path="phoneNumber" maxlength="8" pattern="[8-9][0-9]{7}"/>
                    <div class="invalid-feedback mb-3">
                        Please provide Phone number.
                    </div>
                </div>
                <p class="text-muted font-italic mb-0 pb-0">Birthday</p>
                <fmt:formatDate value="${User.dob}" pattern="dd/MM/YYY" var="dob"/>
                <form:hidden path="dob" value="${dob}" />
				<div class="form-group">
					<input type="text" class="form-control" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${User.dob}"/>" disabled="disabled" >
                </div>
                <p class="text-muted font-italic mb-0 pb-0">Role</p>
				<div class="form-group">
                  <div class="input-group mb-3">
                    <form:select name="role" id="role" class="form-control" path="role" required="required">
						<form:options items="${roleList}"/>
                    </form:select>
                    <div class="invalid-feedback mb-3">
                        Please provide Role.
                    </div>
                </div>
                </div>

                <div class="text-center">
                    <a href="/team5cab/admin/user/search"  class="btn btn-secondary" >Cancel</a>
                    <input type="submit" class="btn btn-primary" value="Update user">
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>