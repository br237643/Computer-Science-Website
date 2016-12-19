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

import Model.Dao;

/**
 * Servlet implementation class PostedResultsServlet
 */
@WebServlet("/PostedResultsServlet")
public class PostedResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement st;
	 private  Connection c;
	  private ResultSet rs;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostedResultsServlet() {
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
		String Results=request.getParameter("Results");
		String ExamName=request.getParameter("ExamName");
		System.out.println(Results);
		System.out.println(ExamName);
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
			String sql="Update examination SET results=? Where nameOfExam=?";
			  
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, Results);
			  st.setString(2, ExamName);
			  
			  
			  st.executeUpdate ();
			 
			
			
		
			request.getRequestDispatcher("PostResult.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
