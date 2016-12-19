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

import Model.StudentDAO;

/**
 * Servlet implementation class StudentRegistrationServlet
 */
@WebServlet("/StudentRegistrationServlet")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement st;
	 private  Connection c;
	  private ResultSet rs;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationServlet() {
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
		String name=request.getParameter("Fname");
		String Lname=request.getParameter("Lname");
		System.out.println(Lname);
		name=name.concat(" "+Lname);
		String netID=request.getParameter("netID");
		String password=request.getParameter("password");
		String year=request.getParameter("year");
		String program=request.getParameter("program");
		String major=request.getParameter("major");
		System.out.println(request.getParameter("Fname"));
		String already=null;
		try{
			  Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
			
			String sql="Select * from student where netID=?";
			st=c.prepareStatement(sql);
			
			st.setString(1, netID);
			
			
			st.executeQuery();
			rs=st.getResultSet();
			while(rs.next()){
				already=rs.getString("netID");
				System.out.println(already);
				
			}
			if(already!=null){
			 String Error="User already exits";
			  
			  request.setAttribute("Error", Error);
			  request.getRequestDispatcher("Registration1.jsp").forward(request, response);
			}
		}catch(Exception e){
			System.out.println("Error is " +e);
			String Error="User already exits";
			  
			  request.setAttribute("Error", Error);
			  request.getRequestDispatcher("Registration1.jsp").forward(request, response);
		}
		if(already==null){
		try {
			boolean result=StudentDAO.studentRegistration(name, netID, password, year, program, major);
		    response.sendRedirect("Login.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}
