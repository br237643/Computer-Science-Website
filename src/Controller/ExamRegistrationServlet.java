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

import com.mysql.jdbc.PreparedStatement;

import Model.Dao;

/**
 * Servlet implementation class ExamRegistrationServlet
 */
@WebServlet("/ExamRegistrationServlet")
public class ExamRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamRegistrationServlet() {
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
		String examname=request.getParameter("name");
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");
		String netID=(String)session.getAttribute("username");
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
			String sql="INSERT INTO `termproject`.`examregistration` (`examname`, `studentID`, `studentname` ) VALUES (?, ?, ?)";
			  
			
				      
			 st=(PreparedStatement) c.prepareStatement(sql);
			
			  st.setString(1, examname);
			  st.setString(2, netID);
			  st.setString(3,name);
			  st.executeUpdate();
			 
				
				response.sendRedirect("Sindex.jsp");
				
			 		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
