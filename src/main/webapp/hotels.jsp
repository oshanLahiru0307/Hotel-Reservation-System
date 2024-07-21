<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Hotels</title>
    <link rel="stylesheet" href="css/hotelform.css">
</head>
<body>
    <div class="container">
        <h1>Hotels Registration</h1>
        <form action="hotels" method="post">
            <p>Name</p>
            <input type="text" placeholder="Enter Hotel Name" name="name" required>
            
            <p>Location</p>
            <input type="text" placeholder="Enter location" name="location" required>
            
            <p>Country</p>
            <input type="text" placeholder="Enter Country" name="country" required>
            
            <p>Phone</p>
            <input type="text" placeholder="Enter Hotel Phone number" name="phone" pattern="\d{10}" title="Phone number must be exactly 10 digits" required>
            
            <p>Email</p>
            <input type="email" placeholder="Enter Hotel Email" name="email" required>
            
            <button type="submit" name="submit">Submit</button>
        </form>
    </div>
</body>
</html>
