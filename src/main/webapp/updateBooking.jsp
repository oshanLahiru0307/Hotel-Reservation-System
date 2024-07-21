<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="Connect.ConnectionProviderForSql" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer Booking</title>
    <link rel="stylesheet" href="css/BookingForm.css">
    <script>
        // Set the minimum date for the from_date field to today
        window.onload = function() {
            var today = new Date().toISOString().split('T')[0];
            document.getElementsByName("from_date")[0].setAttribute('min', today);
        };

        // Function to ensure the to_date is always after the from_date
        function validateToDate() {
            var fromDate = document.getElementsByName("from_date")[0].value;
            document.getElementsByName("to_date")[0].setAttribute('min', fromDate);
        }
    </script>
</head>
<body>

<%
    String ID = request.getParameter("id");
    try {
        Connection con = ConnectionProviderForSql.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM booking_details WHERE booking_ID='" + ID + "'");

        while (rs.next()) {
%>

<div class="container">
    <h1>Update Booking</h1>
    <form action="bookingUpdate" method="post">

        <input type="hidden" value="<%= rs.getString(1) %>" name="id" required>

        <p>Name</p>
        <input type="text" placeholder="Enter your Name" value="<%= rs.getString(2) %>" name="name" required>

        <p>Mobile Number</p>
        <input type="text" placeholder="Enter your Mobile Number" value="<%= rs.getString(3) %>"
               name="mobile" pattern="\d{10}" title="Phone number must be exactly 10 digits" required>

        <p>Email</p>
        <input type="email" placeholder="Enter your Email" value="<%= rs.getString(4) %>" name="email" required>

        <p>From</p>
        <input type="date" value="<%= rs.getString(5) %>" name="from_date" required onchange="validateToDate()">

        <p>To</p>
        <input type="date" value="<%= rs.getString(6) %>" name="to_date" required>

        <p>Hotel ID</p>
        <input type="text" placeholder="Enter Hotel ID" value="<%= rs.getString(7) %>" name="hotel_id" required>

        <p>Persons</p>
        <input type="number" placeholder="Enter Number of persons" value="<%= rs.getString(8) %>" name="Num_of_pers" required>

        <p>Status</p>
        <input type="text" placeholder="Update Status" value="<%= rs.getString(9) %>" name="status" required>

        <button type="submit" name="submit">Submit</button>

    </form>
</div>

<%
        }
    } catch (Exception e) {
        System.out.println(e);
    }
%>

</body>
</html>
