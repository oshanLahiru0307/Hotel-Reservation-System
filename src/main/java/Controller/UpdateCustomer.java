package Controller;
import Model.registraionDBUtil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UpdateCustomer
 */
@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("mobile");
		String emial = request.getParameter("email");
		String userName = request.getParameter("UserName");
		String pwd = request.getParameter("Password");

		
		boolean isSuccess;
		
		isSuccess = registraionDBUtil.updateCustomer(id, name, phone, emial, userName, pwd);
		
		if(isSuccess == true) {
			
			RequestDispatcher dis1 = request.getRequestDispatcher("registrationView.jsp");
			dis1.forward(request, response);
			
		}else {
			
			RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
			dis2.forward(request, response);
		}
		
	}

}
