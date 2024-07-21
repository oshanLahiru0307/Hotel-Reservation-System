<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>

    <html>

    <head>

        <meta charset="ISO-8859-1">
        <title>Customer Booking</title>
        <link rel="stylesheet" href="css/registration.css">

    </head>

    <body>


        <div class="container">

            <h1>Customer Registration</h1>

            <form action="register" method="post">


                <p>Name</p>
                <input type="text" placeholder="Enter your Name" name="name" required>



                <p>Mobile Number</p>
                <input type="text" placeholder="Enter your Moblie Number" name="mobile" pattern="\d{10}" title="Phone number must be exactly 10 digits" required>



                <p>Email</p>
                <input type="email" placeholder="Enter your Email" name="email" required>



                <p>User Name</p>
                <input type="text" placeholder="Enter your User Name" name="UserName" required>



                <p>Password</p>
                <input id="password" type="Password" placeholder="Enter your Password" name="Password" required>



                <p>Re-Enter Password</p>
                <input id="confirmPassword" type="Password" placeholder="Enter your Password" name="Password" required>



                <button type="submit" name="submit">Submit</button>

            </form>

        </div>

        <script>
            function validateForm() {

                var password = document.getElementById("password").value;
                var confirmPassword = document.getElementById("confirmPassword").value;

                if (password !== confirmPassword) {
                    alert("Passwords do not match!");
                    return false;
                }

                return true;
            }
        </script>


    </body>

    </html>