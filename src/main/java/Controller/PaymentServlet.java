package Controller;
import Model.CardDetailsDBUtil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String Cnum = request.getParameter("cardnum");
		String exdate = request.getParameter("exdate");
		String cvc = request.getParameter("cvc");
		
        boolean isSuccess;
		
		isSuccess = CardDetailsDBUtil.insertCardDetails(fname, lname, Cnum, exdate, cvc);
		
		if(isSuccess == true) {
			
			RequestDispatcher dis1 = request.getRequestDispatcher("CardDetailsView.jsp");
			dis1.forward(request, response);
			
		}else {
			
			RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
			dis2.forward(request, response);
		}
		
   		
	}

}
