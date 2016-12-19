package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AlumniDAO;
import Model.Dao;

/**
 * Servlet implementation class UpdateJobServlet
 */
@WebServlet("/UpdateJobServlet")
public class UpdateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateJobServlet() {
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
		
		String location=request.getParameter("location");
		String description=request.getParameter("description");
		String requirement=request.getParameter("requirement");
		String url=request.getParameter("url");
		String email=request.getParameter("email");
		String id=request.getParameter("ID");
		int ID=Integer.valueOf(id);
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
			String sql="UPDATE jobportal SET location=?  , description=?,requirement=?  , url=?,email=? WHERE Id=?";
			  
			
				      
			  st=(PreparedStatement) c.prepareStatement(sql);
			  st.setString(1, location);
			  st.setString(2, description);
			  st.setString(3, requirement);
			  st.setString(4, url);
			  st.setString(5, email);
			  st.setInt(6, ID);
			  
			  st.executeUpdate ();
			  response.sendRedirect("TeamJobPortal.jsp");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	}


