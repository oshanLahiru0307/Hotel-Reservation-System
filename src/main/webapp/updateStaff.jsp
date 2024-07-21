<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <%@ page import="Connect.ConnectionProviderForSql" %>

        <%@ page import="java.sql.*" %>

            <!DOCTYPE html>

            <html>

            <head>

                <meta charset="ISO-8859-1">
                <title>Staff-Registraion</title>
                <link rel="stylesheet" href="css/stafRregistrationForm.css">

            </head>

            <body>

                <% 
                
                String ID=request.getParameter("id"); 
                
                try{ 
                	
                	Connection con=ConnectionProviderForSql.getConnection();
                    Statement stmt=con.createStatement(); ResultSet rs=stmt.executeQuery("select * from staff_details where id='"+ID+"' ");
	 
	            while(rs.next()){

 
                %>
 

       <div class=" container">

                    <h1>Staff-Registration</h1>

                    <form action="staffUpdate" method="post">


                        <input type="hidden" value="<%= rs.getString(1) %>" name="id" required>


                        <p>Name</p>
                        <input type="text" placeholder="Enter your Name" value="<%= rs.getString(2) %>" name="name" required>



                        <p>Mobile Number</p>
                        <input type="text" placeholder="Enter your Moblie Number" value="<%= rs.getString(3) %>"
                            name="mobile" pattern="\d{10}" title="Phone number must be exactly 10 digits"  required>



                        <p>Email</p>
                        <input type="email" placeholder="Enter your Email" value="<%= rs.getString(4) %>" name="email" required>


                        <p>Position</p>
                        <input type="text" placeholder="Enter your Position" value="<%= rs.getString(5) %>"
                            name="position" required>



                        <p>User Name</p>
                        <input type="text" placeholder="Enter your User Name" value="<%= rs.getString(6) %>"
                            name="UserName" required>



                        <p>Password</p>
                        <input id="password" type="Password" placeholder="Enter your Password"
                            value="<%= rs.getString(7) %>" name="Password" required>



                        <p>Re-Enter Password</p>
                        <input id="confirmPassword" type="Password" placeholder="Enter your Password"
                            value="<%= rs.getString(7) %>" name="Password">



                        <button type="submit" name="submit">Submit</button>

                    </form>

                    </div>

                    <% } 
	            
                         }catch(Exception e){ 
                	
                	      System.out.println(e); 
                	
                         } 
                
                    %>

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