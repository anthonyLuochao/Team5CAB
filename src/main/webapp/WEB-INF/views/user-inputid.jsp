<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<cab:headImports />
<title>Forgot Password</title>
</head>
<body>
	<cab:nav />
    <form:form id="form1" action="team5cab/public/forgetpassword" modelAttribute="Users">
        <div class="container">
            <div class="page-header text-center">
                <h1>CAB</h1>
            </div>
            <div class="row justify-content-center">
                <div class="col-lg-4">
                    <div class="card">
                        <div class="card-header">
                            <strong>Forgot Password</strong>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="user">UserID:</label> 
                                <form:input type="text" class="form-control"
                                    id="user" path="userID" required="required"  />
                            </div>
                           
                           
                            <div class="form-group text-center">                                                 
                               
                                <input type="submit" value="Change Password" class="btn btn-primary">
                            </div>                           
                        </div>
                    </div>
                    <p class="text-muted font-italic mb-3 pb-0">Don't have an account? Sign up now!</p>
			        <div class="form-group text-center">                                                 
                    	 <a href="/team5cab/public/register" class="btn btn-primary">Register</a>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</body>
</html>