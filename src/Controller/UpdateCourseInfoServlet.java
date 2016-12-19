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
import javax.servlet.http.HttpSession;

import Model.Dao;

/**
 * Servlet implementation class UpdateCourseInfoServlet
 */
@WebServlet("/UpdateCourseInfoServlet")
public class UpdateCourseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourseInfoServlet() {
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
		HttpSession session=request.getSession();
		String CourseName=request.getParameter("CourseName");
		
		String OfficeHours = request.getParameter("OfficeHours");
		String TAInfo=request.getParameter("TAInfo");
		  System.out.println(TAInfo);
		String Syllabus=request.getParameter("Syllabus");
		String ProfessorName=(String) session.getAttribute("name");
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
			String sql= "UPDATE `termproject`.`courselist` SET  ProfessorName=? , OfficeHours=?, TAInfo=?,Syllabus=?   WHERE CourseName=?";
			  
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, ProfessorName);
		
			  st.setString(2, OfficeHours);
			  st.setString(3, TAInfo);
			  st.setString(4, Syllabus);
			  st.setString(5,CourseName);
			  st.executeUpdate ();
			 
			
			
		response.sendRedirect("ViewCourses.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}


