<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Hotels</title>
    <link rel="stylesheet" href="css/payment.css">
    <script>
        window.onload = function() {
            var today = new Date().toISOString().split('T')[0];
            document.getElementsByName("exdate")[0].setAttribute('min', today);
        };
    </script>
</head>
<body>
    <div class="container">
        <h1>Card Details</h1>
        <form action="payment" method="post">
            <p>First Name</p>
            <input type="text" placeholder="Enter First Name" name="fname" required>

            <p>Last Name</p>
            <input type="text" placeholder="Enter Last Name" name="lname" required>

            <p>Card Number</p>
            <input type="text" placeholder="xxxx-xxxx-xxxx-xxxx" name="cardnum" required>

            <p>Expiry Date</p>
            <input type="date" placeholder="Enter Card Expiry Date" name="exdate" required>

            <p>CVC</p>
            <input type="text" placeholder="Enter CVC Number" name="cvc" pattern="\d{3}" title="CVC number must be exactly 3 digits" required>

            <button type="submit" name="submit">Submit</button>
        </form>
    </div>
</body>
</html>
