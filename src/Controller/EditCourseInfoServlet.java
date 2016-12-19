package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Dao;

/**
 * Servlet implementation class EditCourseInfoServlet
 */
@WebServlet("/EditCourseInfoServlet")
public class EditCourseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourseInfoServlet() {
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
		String CourseID=request.getParameter("CourseID");
		String CourseName = null;
		String ProfessorName = null;
		String OfficeHours = null;
		String TAInfo = null;
		String Syllabus = null;
		
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
			String sql= "Select * from courselist WHERE courseID=?";
			  
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, CourseID);
			  
			  
			  st.executeQuery();
			  rs = st.getResultSet();
			  while (rs.next ()){
			   CourseName=rs.getString("CourseName");
			  ProfessorName=rs.getString("ProfessorName");
			  OfficeHours=rs.getString("OfficeHours");
			  TAInfo=rs.getString("TAInfo");
			  Syllabus=rs.getString("Syllabus");
			  
			  }
			 
		
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("CourseID", CourseID);
		session.setAttribute("CourseName", CourseName);
		session.setAttribute("ProfessorName", ProfessorName);
		session.setAttribute("OfficeHours", OfficeHours);
		session.setAttribute("TAInfo", TAInfo);
		
		session.setAttribute("Syllabus", Syllabus);
		response.sendRedirect("EditCourseInfo.jsp");
		
	}

}
