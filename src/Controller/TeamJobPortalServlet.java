package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Dao;

/**
 * Servlet implementation class TeamJobPortalServlet
 */
@WebServlet("/TeamJobPortalServlet")
public class TeamJobPortalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement st;
	 private  Connection c;
	  private ResultSet rs;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamJobPortalServlet() {
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
		String location=request.getParameter("location");
		String category=request.getParameter("category");
		String description=request.getParameter("description");
		String requirement=request.getParameter("requirement");
		Date date= Date.valueOf(request.getParameter("date"));
		String url=request.getParameter("url");
		String email=request.getParameter("email");
		HttpSession session=request.getSession();
		String owner=(String)session.getAttribute("name");
		
		
		
		
		//Database Connection
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
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root",""); 
			//owner i am passing srinivas you can put name using your session. so it will be srinivas for all posts. 
			String sql="INSERT INTO `termproject`.`jobportal` (`owner`, `location`, `category`, `description`, `requirement`, `deadlinedate`, `url`, `email`) VALUES (?, ?, ?, ?,?, '"+date+"', ?, ?)";			  
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, owner);
			  st.setString(2, location);
			  st.setString(3, category);
			  st.setString(4, description);
			  st.setString(5, requirement);
			  st.setString(6, url);
			  st.setString(7, email);
			  
			 
			  st.executeUpdate ();
			 
			  response.sendRedirect("TeamJobPortal.jsp");
			  
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
