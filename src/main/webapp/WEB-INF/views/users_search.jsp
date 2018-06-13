<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cab" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<cab:headImports />
</head>
<body>
<cab:nav />
    <div class="container text-center">
        <h1>User search</h1>
        <form:form action="/team5cab/admin/user/search" method="POST" class="my-5" modelAttribute="searchTerm">
            <div class="form-group">
                <form:input path="name" class="form-control" type="text" name="search" id="user_search" placeholder="Enter a username or a person's name" />
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form:form>

        <table class="table mt-5">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>UserID</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th></th>
                </tr>
            </thead>
			<c:forEach var="user" items="${Users}">
            <tr>
                <td class="align-middle"><c:out value="${user.name}" /></td>
                <td class="align-middle"><c:out value="${user.userID}"/></td>
                <td class="align-middle"><c:out value="${user.email}" /></td>
                <td class="align-middle"><c:out value="${user.phoneNumber}" /></td>
                <td class="align-middle">
                    <a href="<c:url value="team5cab/admin/user/edit/${user.userID}" />" class="btn btn-secondary">Edit</a>
                    <a href="<c:url value="team5cab/admin/user/delete/${user.userID}" />" class="btn btn-danger">Delete</a>
               </td>
            </tr>
            </c:forEach>
       </table>
    </div>

    <nav class="mt-5">    
        <ul class="pagination justify-content-center">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>

</body>
</html>