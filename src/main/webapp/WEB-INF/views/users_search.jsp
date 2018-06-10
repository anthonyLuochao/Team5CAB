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
</head>
<body>
<cab:nav />
    <div class="container text-center">
        <h1>User search</h1>
        <form action="POST" class="my-5">
            <div class="form-group">
                <input class="form-control" type="text" name="search" id="user_search" placeholder="Enter a username or a person's name">
            </div>
            <input type="button"  class="btn btn-primary" value="Search">
        </form>

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
            <tr>
                <td class="align-middle">Meiting</td>
                <td class="align-middle">IAmMeiting</td>
                <td class="align-middle">MyEmailIsMeiting@gmail.com</td>
                <td class="align-middle">91234532</td>
                <td class="align-middle">
                    <button class="btn btn-secondary">Edit</button>
                    <button class="btn btn-danger">Delete</button>
               </td>
            </tr>
            <tr>
                <td class="align-middle">Meiting</td>
                <td class="align-middle">IAmMeiting</td>
                <td class="align-middle">MyEmailIsMeiting@gmail.com</td>
                <td class="align-middle">91234532</td>
                <td class="align-middle">
                    <button class="btn btn-secondary">Edit</button>
                    <button class="btn btn-danger">Delete</button>
               </td>
            </tr>
            <tr>
                <td class="align-middle">Meiting</td>
                <td class="align-middle">IAmMeiting</td>
                <td class="align-middle">MyEmailIsMeiting@gmail.com</td>
                <td class="align-middle">91234532</td>
                <td class="align-middle">
                    <button class="btn btn-secondary">Edit</button>
                    <button class="btn btn-danger">Delete</button>
               </td>
            </tr>
            <tr>
                <td class="align-middle">Meiting</td>
                <td class="align-middle">IAmMeiting</td>
                <td class="align-middle">MyEmailIsMeiting@gmail.com</td>
                <td class="align-middle">91234532</td>
                <td class="align-middle">
                    <button class="btn btn-secondary">Edit</button>
                    <button class="btn btn-danger">Delete</button>
               </td>
            </tr>
            <tr>
                <td class="align-middle">Meiting</td>
                <td class="align-middle">IAmMeiting</td>
                <td class="align-middle">MyEmailIsMeiting@gmail.com</td>
                <td class="align-middle">91234532</td>
                <td class="align-middle">
                    <button class="btn btn-secondary">Edit</button>
                    <button class="btn btn-danger">Delete</button>
               </td>
            </tr>
            <tr>
                <td class="align-middle">Meiting</td>
                <td class="align-middle">IAmMeiting</td>
                <td class="align-middle">MyEmailIsMeiting@gmail.com</td>
                <td class="align-middle">91234532</td>
                <td class="align-middle">
                    <button class="btn btn-secondary">Edit</button>
                    <button class="btn btn-danger">Delete</button>
               </td>
            </tr>
            <tr>
                <td class="align-middle">Meiting</td>
                <td class="align-middle">IAmMeiting</td>
                <td class="align-middle">MyEmailIsMeiting@gmail.com</td>
                <td class="align-middle">91234532</td>
                <td class="align-middle">
                    <button class="btn btn-secondary">Edit</button>
                    <button class="btn btn-danger">Delete</button>
               </td>
            </tr>
            <tr>
                <td class="align-middle">Meiting</td>
                <td class="align-middle">IAmMeiting</td>
                <td class="align-middle">MyEmailIsMeiting@gmail.com</td>
                <td class="align-middle">91234532</td>
                <td class="align-middle">
                    <button class="btn btn-secondary">Edit</button>
                    <button class="btn btn-danger">Delete</button>
               </td>
            </tr>
            <tr>
                <td class="align-middle">Meiting</td>
                <td class="align-middle">IAmMeiting</td>
                <td class="align-middle">MyEmailIsMeiting@gmail.com</td>
                <td class="align-middle">91234532</td>
                <td class="align-middle">
                    <button class="btn btn-secondary">Edit</button>
                    <button class="btn btn-danger">Delete</button>
               </td>
            </tr>
            <tr>
                <td class="align-middle">Meiting</td>
                <td class="align-middle">IAmMeiting</td>
                <td class="align-middle">MyEmailIsMeiting@gmail.com</td>
                <td class="align-middle">91234532</td>
                <td class="align-middle">
                    <button class="btn btn-secondary">Edit</button>
                    <button class="btn btn-danger">Delete</button>
               </td>
            </tr>
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