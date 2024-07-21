package Controller;
import Model.StaffDBUtil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class StaffregisterServlet
 */
@WebServlet("/StaffregisterServlet")
public class StaffregisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String phone = request.getParameter("mobile");
		String emial = request.getParameter("email");
		String position = request.getParameter("position");
		String userName = request.getParameter("UserName");
		String pwd = request.getParameter("Password");

		
		boolean isSuccess;
		
		isSuccess = StaffDBUtil.insertStaffRegistration(name, phone, emial, userName, position, pwd);
		
		if(isSuccess == true) {
			
			RequestDispatcher dis1 = request.getRequestDispatcher("StaffView.jsp");
			dis1.forward(request, response);
			
		}else {
			
			RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
			dis2.forward(request, response);
		}
		
	}

}
