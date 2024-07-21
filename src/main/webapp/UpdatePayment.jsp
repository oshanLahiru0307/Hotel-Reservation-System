<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    
        <%@ page import="Connect.ConnectionProviderForSql" %>

        <%@ page import="java.sql.*" %>

    <html>

    <head>

        <meta charset="ISO-8859-1">
        
        <title>Card Details</title>s
        <link rel="stylesheet" href="css/payment.css">

    </head>

    <body>
    
                <% 
                
                    String ID=request.getParameter("id");
                
                    try{ 
                    	
                    	Connection con=ConnectionProviderForSql.getConnection();
                        Statement stmt=con.createStatement(); ResultSet rs=stmt.executeQuery("select * from payment_details where id='"+ID+"' ");
	 
	                while(rs.next()){

 
                %>

        <div class="container">

            <h1>Card Details</h1>

            <form action="UpdateCard" method="post">

                <input type="hidden" placeholder="Enter First Name" value="<%= rs.getString(1) %>" name="id" required>
                
                
                <p>First Name</p>
                <input type="text" placeholder="Enter First Name" value="<%= rs.getString(2) %>" name="fname" required>



                <p>Last Name</p>
                <input type="text" placeholder="Enter First Name" value="<%= rs.getString(3) %>" name="lname" required>



                <p>Card Number</p> 
                <input type="text" placeholder="Enter Card Number" value="<%= rs.getString(4) %>" name="cardnum" required>



                <p>Expiry-Date</p>
                <input type="date" placeholder="Enter Card Expiry Date" value="<%= rs.getString(5) %>" name="exdate" required>



                <p>CVC</p>
                <input type="text" placeholder="Enter CVC Number" value="<%= rs.getString(6) %>"  name="cvc" pattern="\d{3}" title="Phone number must be exactly 3 digits" required>


                <button type="submit" name="submit">Submit</button>

            </form>

        </div>
        
                    <% } 
	                
	                     }catch(Exception e){ 
	                    	 
	                	  System.out.println(e); 
	                	
	                     } 
	                
	                %>

    </body>

    </html>