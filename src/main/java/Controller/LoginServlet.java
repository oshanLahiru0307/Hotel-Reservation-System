package Controller;
import Entity.Customer;
import Model.CustomerDBUtil;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        try {
			
			List<Customer> cusDetails = CustomerDBUtil.Validate();
			request.setAttribute("cusDetails",cusDetails);
			
		}catch(Exception e){
			
			e.printStackTrace();	
			
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("AdminHome.jsp");
		dis.forward(request,response);
	}

}
