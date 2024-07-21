<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Log in Page</title>
        <link rel="stylesheet" type="text/css" href="css/login_style.css">
    </head>


        <body>

            <div class="login">

                <img src="images\login-icon.png" class="user">

                <h1>LogIn</h1>

                <form action="log" method="post">

                    <p>User Name</p>

                    <input type="text" name="UserName" placeholder="Enter Username">

                    <p>password</p>

                    <input type="text" name="Password" placeholder="Enter password">

                    <input type="submit" name="submit" value="Login">


                    <a href="#">Forgot Password?</a><br>

                </form>



            </div>

            <script>

                function loginFunction() {
                    alert("Login Successful!!");
                }
            </script>


        </body>

    </html>