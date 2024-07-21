<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <%@ page import="Connect.ConnectionProviderForSql" %>

        <%@ page import="java.sql.*" %>

            <!DOCTYPE html>

            <html>

            <head>

                <meta charset="ISO-8859-1">
                <title>Hotels</title>
                <link rel="stylesheet" href="css/hotelform.css">

            </head>

            <body>

                <% 
                
                String ID=request.getParameter("id"); 
                
                try{ 
                	
                	Connection con=ConnectionProviderForSql.getConnection();
                    Statement stmt=con.createStatement(); 
                    ResultSet rs=stmt.executeQuery("select * from hotels_details where id='"+ID+"' ");
	 
	            while(rs.next()){

 
               %>

    <div class=" container">

                    <h1>Hotels Registration</h1>

                    <form action="UpdateHotels" method="post">


                        <input type="hidden" value="<%= rs.getString(1) %>" name="id">

                        <p>Name</p>
                        <input type="text" placeholder="Enter Hotel Name" value="<%= rs.getString(2) %>" name="name" required>



                        <p>Location</p>
                        <input type="text" placeholder="Enter loacation" value="<%= rs.getString(3) %>" name="location" required>



                        <p>Country</p>
                        <input type="text" placeholder="Enter Country" value="<%= rs.getString(4) %>" name="country" required>



                        <p>phone</p>
                        <input type="text" placeholder="Enter Hotel Phone number" value="<%= rs.getString(5) %>" name="phone" pattern="\d{10}" title="Phone number must be exactly 10 digits" required>



                        <p>Email</p>
                        <input type="email" placeholder="Enter Hotel Email" value="<%= rs.getString(6) %>" name="email" required>


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