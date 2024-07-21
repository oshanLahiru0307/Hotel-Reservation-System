<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <%@ page import="Connect.ConnectionProviderForSql" %>

        <%@ page import="java.sql.*" %>


            <!DOCTYPE html>


            <html>

            <head>

                <meta charset="ISO-8859-1">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Staff Details</title>
                <link rel="stylesheet" href="css/table.css">

            </head>

            <body>

                <div class="filter">

                    <h1>Staff Details</h1>

                    <table>

                        <tr>

                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Mobile</th>
                            <th scope="col">Email</th>
                            <th scope="col">Position</th>
                            <th scope="col">User Name</th>
                            <th scope="col">Password</th>

                        </tr>

                        <% try{ 
                        	
                        	Connection con=ConnectionProviderForSql.getConnection(); 
                        	Statement stmt=con.createStatement(); 
                        	ResultSet rs=stmt.executeQuery("select * from staff_details");
                        	
                            while(rs.next()){ 
                            
                        %>


                            <tr>

                                <th scope="row">
                                    <%= rs.getString(1) %>
                                </th>
                                <td>
                                    <%= rs.getString(2) %>
                                </td>
                                <td>
                                    <%= rs.getString(3) %>
                                </td>
                                <td>
                                    <%= rs.getString(4) %>
                                </td>
                                <td>
                                    <%= rs.getString(5) %>
                                </td>
                                <td>
                                    <%= rs.getString(6) %>
                                </td>
                                <td>
                                    <%= rs.getString(7) %>
                                </td>
                                <td><button><a href="updateStaff.jsp?id=<%= rs.getString(1) %>">Update</a></button>
                                    <button><a href="deleteStaff.jsp?id=<%= rs.getString(1) %>">Delete</a></button>
                                </td>

                            </tr>

                            <% } 
                            
                                 }catch(Exception e){ 
                        	      	
                        	      System.out.println(e); 
                        	      
                                 } 
                        
                            %>


                    </table>


            </body>


            </html>