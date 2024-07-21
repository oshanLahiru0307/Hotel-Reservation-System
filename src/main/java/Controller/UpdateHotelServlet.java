package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.hotelBDUtil;

/**
 * Servlet implementation class UpdateHotelServlet
 */
@WebServlet("/UpdateHotelServlet")
public class UpdateHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
        boolean isSuccess;
		
		isSuccess = hotelBDUtil.updateHotels(id,name,location,country,phone,email);
		
		if(isSuccess == true) {
			
			RequestDispatcher dis1 = request.getRequestDispatcher("hotelsView.jsp");
			dis1.forward(request, response);
			
		}else {
			
			RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
