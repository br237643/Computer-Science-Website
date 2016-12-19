package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class EditAlumniServlet
 */
@WebServlet("/EditAlumniServlet")
public class EditAlumniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static java.sql.PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAlumniServlet() {
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
	String Id=request.getParameter("CourseID");
	String name=null;
	String year=null;
	String url=null;
	String details=null;
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
		String sql="Select * from alumniinfo WHERE Id=?";
		  
		
			      
		st=c.prepareStatement(sql);
		
		  st.setString(1, Id);
		  
		  st.executeQuery();
		  rs = st.getResultSet();
		  while(rs.next()){
			  name=rs.getString("name");
			  year=rs.getString("year");
			  url=rs.getString("url");
			  details=rs.getString("details");
		  }
		 
		
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(Id);
	System.out.println(name);
	
	HttpSession session=request.getSession();
	session.setAttribute("ID", Id);
	session.setAttribute("name", name);
	session.setAttribute("year", year);
	session.setAttribute("url", url);
	session.setAttribute("details", details);
	request.getRequestDispatcher("EditAlumni.jsp").forward(request, response);
	
	
	}

}
