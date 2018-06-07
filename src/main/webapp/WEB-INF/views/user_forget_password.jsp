<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-4 text-center">
                <div class="card">
                    <div class="card-header">
                        Forget Password
                    </div>
                    <div class="card-body">
                        <form method="post" enctype="multipart/form-data" action="Your_Action_Page.php">
                          <div>
                            <p>Password:</p>
                            <input name="password" required="required" type="password" id="password" />
                            
                           </div>
                           <div>
                            <p>
                                Confirm Password:
                            </p>
                            <input name="password_confirm" required="required" type="password" id="password_confirm" oninput="check(this)" />
                            </div>
                            <script language='javascript' type='text/javascript'>
                                function check(input) {
                                    if (input.value != document.getElementById('password').value) {
                                        input.setCustomValidity('Password Must be Matching.');
                                    } else {
                                        // input is valid -- reset the error message
                                        input.setCustomValidity('');
                                    }
                                }
                            </script>
                            <br /><br />
                            <input type="submit" />
                            <button type="button" id="button_cancel" class="btn">Cancel</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>