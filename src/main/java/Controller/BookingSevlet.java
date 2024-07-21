package Controller;

import Model.BookingDBUtil;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookingSevlet
 */
@WebServlet("/BookingSevlet")
public class BookingSevlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("mobile");
        String email = request.getParameter("email");
        String from_date = request.getParameter("from_date");
        String to_date = request.getParameter("to_date");
        String hotel_id = request.getParameter("hotel_id");
        String persons = request.getParameter("Num_of_pers");
        String status = request.getParameter("status");

        // Validate required fields
        if (name == null || name.isEmpty() ||
            phone == null || phone.isEmpty() ||
            email == null || email.isEmpty() ||
            from_date == null || from_date.isEmpty() ||
            to_date == null || to_date.isEmpty() ||
            hotel_id == null || hotel_id.isEmpty() ||
            persons == null || persons.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bookingForm.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Validate date fields
        LocalDate fromDate = LocalDate.parse(from_date);
        LocalDate toDate = LocalDate.parse(to_date);
        LocalDate today = LocalDate.now();

        if (fromDate.isBefore(today)) {
            request.setAttribute("errorMessage", "From date should be today or later.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bookingForm.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (toDate.isBefore(fromDate) || toDate.equals(fromDate)) {
            request.setAttribute("errorMessage", "To date should be after the from date.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bookingForm.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Proceed with booking if validation passes
        boolean isSuccess = BookingDBUtil.insertBooking(name, phone, email, from_date, to_date, hotel_id, persons, status);

        if (isSuccess) {
            RequestDispatcher dis1 = request.getRequestDispatcher("CustomerBookingView.jsp");
            dis1.forward(request, response);
        } else {
            RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
            dis2.forward(request, response);
        }
    }
}

