	package Controller;
import Model.Dao;
import Model.StudentDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Dao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement st;
	 private  Connection c;
	  private ResultSet rs;
	  String usermail1;
	  String password1;
	  String name;
       /**Storing username **/
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
			  String type=request.getParameter("type");
			  HttpSession s = request.getSession();
			  s.setAttribute("type", type);
			  System.out.println(type);
			  
			  if(type.contains("faculty"))
			  {
				  System.out.println("hello"); 
				 
					  try {
							 name=Dao.getname(usermail1);
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							 HttpSession session1 = request.getSession();
							 session1.setAttribute("name",name);
								System.out.println(name);
			  String sql="select netID,password from registration where netID=?";
			  String temp = request.getParameter("usermail");
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, temp);
			  
			  st.executeQuery ();
			  rs = st.getResultSet();
			  while (rs.next ()){
			   usermail1=rs.getString("netID");
			  password1=rs.getString("password");
			  
			  }
			  }
			  if(type.contains("staff"))
			  {
				  System.out.println("hello"); 
				 
					  try {
							 name=Dao.getname(usermail1);
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							 HttpSession session1 = request.getSession();
							 session1.setAttribute("name",name);
								System.out.println(name);
			  String sql="select netID,password from registration where netID=?";
			  String temp = request.getParameter("usermail");
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, temp);
			  
			  st.executeQuery ();
			  rs = st.getResultSet();
			  while (rs.next ()){
			   usermail1=rs.getString("netID");
			  password1=rs.getString("password");
			  
			  }
			  }
			  if(type.contains("student"))
			  {
				  try {
						 name=StudentDAO.getStudentname(usermail1);
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						 HttpSession session1 = request.getSession();
						 session1.setAttribute("name",name);
							System.out.println(name);
				  String sql="select netID,password from student where netID=?";
				  String temp = request.getParameter("usermail");
				
					      
				  st=c.prepareStatement(sql);
				  st.setString(1, temp);
				  
				  st.executeQuery ();
				  rs = st.getResultSet();
				  while (rs.next ()){
				   usermail1=rs.getString("netID");
				  password1=rs.getString("password");  
			  }
			  }
			  if(usermail1.equals(request.getParameter("usermail"))){
				  System.out.println("Password is valid");
				  if( password1.equals(request.getParameter("password"))){
				  System.out.println("User is Valid");
				  String username = null;
					HttpSession session = request.getSession();
					session.setAttribute("username", request.getParameter("usermail"));
					username = (String) session.getAttribute("username");
				 if(type.contains("faculty"))
				 {
  					RequestDispatcher requestDispatcher = request
		                    .getRequestDispatcher("/index.jsp");
		            requestDispatcher.forward(request, response);
				 }
				 if(type.contains("staff"))
				 {
  					RequestDispatcher requestDispatcher = request
		                    .getRequestDispatcher("/index.jsp");
		            requestDispatcher.forward(request, response);
				 }
				 if(type.contains("student")){
					 RequestDispatcher requestDispatcher = request
			                    .getRequestDispatcher("/Sindex.jsp");
			            requestDispatcher.forward(request, response);
				 }
				 
				 }
				  else {
					  String Error="Username or Password didn't match";
					  
					  request.setAttribute("Error", Error);
					  request.getRequestDispatcher("Login.jsp").forward(request, response);
					 
				  }
				  
			  } 
				  else{
					  String Error="Username or Password didn't match";
					  
					  request.setAttribute("Error", Error);
					  request.getRequestDispatcher("Login.jsp").forward(request, response);
			
				  
				  }
			 
			  
		}catch(Exception e){
			String Error="Username or Password didn't match";
			  
			  request.setAttribute("Error", Error);
			  request.getRequestDispatcher("Login.jsp").forward(request, response);
			  System.out.println("Exception is ;"+e);
			  }
			 
			           
			  
			 //System.out.println(username);
			 System.out.println(request.getParameter("password"));
			 
			 System.out.println(password1);
			
			 

	}
	

}
