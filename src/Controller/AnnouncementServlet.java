package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnnouncementServlet
 */
@WebServlet("/AnnouncementServlet")
public class AnnouncementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement st;
	 private  Connection c;
	  private ResultSet rs; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnouncementServlet() {
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
		doGet(request, response);
		String type=request.getParameter("type");
		String title=request.getParameter("title");
		String Description=request.getParameter("Description");
		HttpSession session2 = request.getSession(); 
		  
		String username = (String) session2.getAttribute("username");
		System.out.println(username);
		String name=(String) session2.getAttribute("name");
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
 
	       
		try{
			  Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
			
			String sql="INSERT INTO announcements (`title`, `description`, `usermail`, `type`,`date`) VALUES (?,?,?,?,?)"; 	
			st=c.prepareStatement(sql);
			st.setString(1,title);
			st.setString(2, Description);
			st.setString(3, name);
			st.setString(4, type);
			st.setString(5, currentTime);
			
			st.executeUpdate();
			response.sendRedirect("Announcement.jsp");
			
			
		}catch(Exception e){
			System.out.println("Error is" +e);
		}
	}

}
