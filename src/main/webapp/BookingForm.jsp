<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer Booking</title>
    <link rel="stylesheet" href="css/BookingForm.css">
    <script>
        window.onload = function() {
            var today = new Date().toISOString().split('T')[0];
            document.getElementsByName("from_date")[0].setAttribute('min', today);

            document.getElementsByName("from_date")[0].addEventListener('change', function() {
                validateToDate();
            });

            function validateToDate() {
                var fromDate = document.getElementsByName("from_date")[0].value;
                document.getElementsByName("to_date")[0].setAttribute('min', fromDate);
            }
        };
    </script>
</head>
<body>
    <div class="container">
        <h1>Customer Booking</h1>
        <form name="bookingForm" action="booking" method="post">
            <p>Name</p>
            <input type="text" placeholder="Enter your Name" name="name" required>

            <p>Mobile Number</p>
            <input type="text" placeholder="Enter your Mobile Number" name="mobile" pattern="\d{10}" title="Phone number must be exactly 10 digits" required>

            <p>Email</p>
            <input type="email" placeholder="Enter your Email" name="email" required>

            <p>From</p>
            <input type="date" name="from_date" required>

            <p>To</p>
            <input type="date" name="to_date" required>

            <p>Hotel ID</p>
            <input type="text" placeholder="Enter Hotel ID" name="hotel_id" required>

            <p>Persons</p>
            <input type="number" placeholder="Enter Number of persons" name="Num_of_pers" required>

            <input type="hidden" value="pending" name="status">

            <button type="submit" name="submit">Submit</button>
        </form>
    </div>
</body>
</html>
