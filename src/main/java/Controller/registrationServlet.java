package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Customer;
import Model.CustomerDBUtil;
import Model.registraionDBUtil;

/**
 * Servlet implementation class registrationServlet
 */
@WebServlet("/registrationServlet")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String phone = request.getParameter("mobile");
		String emial = request.getParameter("email");
		String userName = request.getParameter("UserName");
		String pwd = request.getParameter("Password");

		boolean isSuccess;

		try {

			List<Customer> cusDetails = CustomerDBUtil.Validate();
			request.setAttribute("cusDetails", cusDetails);

		} catch (Exception e) {

			e.printStackTrace();

		}

		isSuccess = registraionDBUtil.insertRegistration(name, phone, emial, userName, pwd);

		if (isSuccess == true) {

			RequestDispatcher dis1 = request.getRequestDispatcher("Home.jsp");
			dis1.forward(request, response);

		} else {

			RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
			dis2.forward(request, response);
		}

	}

}
