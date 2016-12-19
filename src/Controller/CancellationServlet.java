package Controller;
import Model.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CancellationServlet
 */
@WebServlet("/CancellationServlet")
public class CancellationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement st;
	 private  Connection c;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellationServlet() {
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
		
		System.out.println(Integer.parseInt(request.getParameter("cancelID")));
		
		
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
			  boolean a;
			  String sql="Delete from resource where ID=?";
			  String temp = request.getParameter("cancelID");
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, temp);
			  
			  st.executeUpdate();
			  response.sendRedirect("Cancellation.jsp");
		}catch(Exception e){
			
		}
		
}
}
		
