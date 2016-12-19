package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Dao;

/**
 * Servlet implementation class AddCoursesServlet
 */
@WebServlet("/AddCoursesServlet")
public class AddCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement st;
	 private  Connection c;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCoursesServlet() {
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
		HttpSession session = request.getSession();
		String name=(String) session.getAttribute("name");

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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		
		try {
			 // Load the database driver
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root",""); 
			  // Get a Connection to the database
			  
			  //Add the data into the database
			
			  String sql="INSERT INTO `termproject`.`courselist` (`CourseID`, `CourseName`, `ProfessorName`, `Semester`,`OfficeHours`,`TAInfo`,`Syllabus`) VALUES (?, ?, ?, ?,?,?,?)";
			  String CourseID=request.getParameter("courseID");
			  String CourseName=request.getParameter("courseName");
			  String Semester="fall";
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, CourseID);
			  st.setString(2, CourseName);
			  st.setString(3, name);
			  st.setString(4, Semester);
			  st.setString(5, request.getParameter("OfficeHours"));
			  st.setString(6, request.getParameter("TAinfo"));
			  st.setString(7, request.getParameter("Syllabus"));
			  
			  
			  st.executeUpdate();
			  response.sendRedirect("ViewCourses.jsp");
		}catch(Exception e){
			System.out.println("Error is" +e);
		}
		
		
		
	}

}
