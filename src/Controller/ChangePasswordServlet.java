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

import Model.ChangePassword;
import Model.Dao;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
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
		String oldpassword=request.getParameter("oldPassword");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		String netID=(String) session.getAttribute("username");
		System.out.println(netID);
		System.out.println(password);
		System.out.println(oldpassword);
		String opassword=null;
		String error="Old password was not correct";
		if(session.getAttribute("type").toString().contains("faculty")){
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
				String sql="Select * from registration WHERE netID=?";
				  
				
					      
				  st=c.prepareStatement(sql);
				  st.setString(1, netID);
				  
				  
				  st.executeQuery();
				  rs = st.getResultSet();
				  while (rs.next ()){
				   opassword=rs.getString("password");
				  
				  }
			}catch(Exception e){
				
			}
				
			
			
		if(opassword==oldpassword){
		try {
			boolean result=ChangePassword.facultyPasswordUpdate(password, netID);
			response.sendRedirect("index.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			HttpSession session1=request.getSession();
			session1.setAttribute("Error", error);
		}
		}
		if(session.getAttribute("type").toString().contains("staff")){
			try {
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root",""); 
				String sql="Select * from registration WHERE netID=?";
				  
				
					      
				  st=c.prepareStatement(sql);
				  st.setString(1, netID);
				  
				  
				  st.executeQuery();
				  rs = st.getResultSet();
				  while (rs.next ()){
				   opassword=rs.getString("password");
				  
				  }
			}catch(Exception e){
				
			}
			if(opassword==oldpassword){
			try {
				boolean result=ChangePassword.facultyPasswordUpdate(password, netID);
				response.sendRedirect("index.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			else{
				HttpSession session1=request.getSession();
				session1.setAttribute("Error", error);
			}
		}
		if(session.getAttribute("type").toString().contains("student")){
		String oPass = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root",""); 
			String sql="Select * from student WHERE netID=?";
			  
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, netID);
			  
			  
			  st.executeQuery();
			  rs = st.getResultSet();
			  while (rs.next ()){
			   opassword=rs.getString("password");
			  
			  }
		}catch(Exception e){
			
		}
		if(opassword==oldpassword){
		
		
			try {
			
			boolean result=ChangePassword.studentPasswordUpdate(password, netID);
			response.sendRedirect("Sindex.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			HttpSession session1=request.getSession();
			session1.setAttribute("Error", error);
		}
		}
		}
	}

		
		
		
		
	


