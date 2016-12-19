package Controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Model.Dao;

/**
 * Servlet implementation class AnnouncementRetrivalServlet
 */
@WebServlet("/AnnouncementRetrivalServlet")
public class AnnouncementRetrivalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<String> Title = new ArrayList<String>();
	private List<String> Vegie = new ArrayList<>();
	private static PreparedStatement st;
	private static Connection c;
	private static ResultSet rs;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnouncementRetrivalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dao connect = new Dao();
		try {
			connect.DbCon();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root",""); 
				String sql = "Select * from announcements";

				st = (PreparedStatement) c.prepareStatement(sql);

				rs=st.executeQuery();
				
				while (rs.next()) {
			Title.add(rs.getString("Title"));
			
			
			
			}	

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		System.out.println("hey");
		
		
		request.setAttribute("Title", Title);
			RequestDispatcher requestDispatcher = request
	                .getRequestDispatcher("/AnnouncementRetrival.jsp");
			 
		        requestDispatcher.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
			
			
	

	
		

		
	


