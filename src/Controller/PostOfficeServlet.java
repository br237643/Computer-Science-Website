package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.*;
/**
 * Servlet implementation class PostOfficeServlet
 */
@WebServlet("/PostOfficeServlet")
public class PostOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private PreparedStatement st;
	 private  Connection c;
	  private ResultSet rs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostOfficeServlet() {
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
		HttpSession session=request.getSession();
		String facultyname=(String) session.getAttribute("username");
		Dao connect = new Dao();
		
		try{
			
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root",""); 
		String OfficeHours=request.getParameter("OfficeHours");
		String Syl =request.getParameter("Syllabus");
		String sql="insert into coursefaculty values(?,?,?,?,?);";
		  
		  st=c.prepareStatement(sql);
		  System.out.println(facultyname);
		  st.setString(1,request.getParameter("CourseID"));
		  st.setString(2,OfficeHours);
		  st.setString(3,Syl);
		  st.setString(4,request.getParameter("TAinfo"));
		  st.setString(5,facultyname);
		  st.executeUpdate();
		  System.out.println(sql);
		}catch(Exception e)
		{
			
		}
		}
	}


