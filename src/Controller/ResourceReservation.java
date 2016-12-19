package Controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.*;

/**
 * Servlet implementation class ResourceReservation
 */
@WebServlet("/ResourceReservation")
public class ResourceReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResourceReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		HttpSession session = request.getSession();
		if(request.getParameter("CheckAvailable")!=null){
		String resourceType = request.getParameter("type");
		Date date= Date.valueOf(request.getParameter("date"));
		List<Integer> bookedSlots = new ArrayList<>();
		try {
			bookedSlots = Dao.getBookedSlots(date, resourceType);
		} catch ( ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Integer> allSlots = new ArrayList<>();
		for(int i=1; i<9;i++){
			allSlots.add(i);
		}
		for(Integer a : bookedSlots){
			allSlots.remove(a);
		}
		request.setAttribute("availableSlots", allSlots);
		session.setAttribute("type", resourceType);
		session.setAttribute("date", date.toString());
	  RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("/AvailableSlots.jsp");
        requestDispatcher.forward(request, response);
		}
		
		if(request.getParameter("BookSlot")!=null){
			String type = (String) session.getAttribute("type");
			System.out.println(session.getAttribute("date"));
			Date date= Date.valueOf((String) session.getAttribute("date"));
			Integer slot = Integer.parseInt(request.getParameter("slot"));
			String username = (String) session.getAttribute("username");
			if(slot!=null)
			{
			try {
				boolean result = Dao.bookSlot(username, date, type, slot);
				System.out.println(result);
				response.sendRedirect("index.jsp");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		}
		
		
		
		
	}

}
