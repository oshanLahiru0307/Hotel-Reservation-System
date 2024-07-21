package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookingDBUtil;

/**
 * Servlet implementation class CustomerBookingUpdate
 */
@WebServlet("/CustomerBookingUpdate")
public class CustomerBookingUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
        boolean Success;
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("mobile");
		String emial = request.getParameter("email");
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		String hotel_id = request.getParameter("hotel_id");
		String persons = request.getParameter("Num_of_pers");
		String status = request.getParameter("status");
		
		Success = BookingDBUtil.updateBooking(id, name, phone, emial, from_date, to_date, hotel_id, persons,status);
		
	       if(Success == true) {
				
				RequestDispatcher dis1 = request.getRequestDispatcher("CustomerBookingView.jsp");
				dis1.forward(request, response);
				
			}else {
				
				RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
				dis2.forward(request, response);
		    }
		
	}

}
