<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <%@ page import="Connect.ConnectionProviderForSql" %>

        <%@ page import="java.sql.*" %>


            <!DOCTYPE html>


            <html>

            <head>

                <meta charset="ISO-8859-1">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Hotels Details</title>
                <link rel="stylesheet" href="css/table.css">

            </head>

            <body>

                <div class="filter">

                    <h1>Hotels Details</h1>

                    <table>

                        <tr>

                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Location</th>
                            <th scope="col">Country</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Email</th>

                        </tr>

                        <% try{ 
                        	
                        	Connection con=ConnectionProviderForSql.getConnection(); 
                        	Statement stmt=con.createStatement(); 
                        	ResultSet rs=stmt.executeQuery("select * from hotels_details");
                        	
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
                                    <button><a href="#">Visit</a></button>
                                </td>

                            </tr>

                            <% } 
                            
                                 }catch(Exception e){ 
                        	
                        	      System.out.println(e); 
                        	
                                 } 
                                 
                            %>


                    </table>

                </div>

            </body>


            </html>