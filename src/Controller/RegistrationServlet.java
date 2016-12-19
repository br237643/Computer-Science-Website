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

import com.sun.org.apache.xml.internal.security.exceptions.AlgorithmAlreadyRegisteredException;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement st;
	 private  Connection c;
	  private ResultSet rs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("User Already Exits ");
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
		System.out.println(request.getParameter("Fname"));
		String alredy=null;
		
		try{
			  Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
			
			String sql="Select * from registration where netID=?";
			st=c.prepareStatement(sql);
			
			st.setString(1, netID);
			
			System.out.println("hey");
			st.executeQuery();
			rs=st.getResultSet();
			while(rs.next()){
				alredy=rs.getString("netID");
				System.out.println(alredy);
				
			}
			if(alredy!=null){
			 String Error="User already exits";
			  
			  request.setAttribute("Error", Error);
			  request.getRequestDispatcher("Registration.jsp").forward(request, response);
			}
		}catch(Exception e){
			System.out.println("Error is " +e);
		}
		
		if(alredy==null)
			try{
				  Class.forName("com.mysql.jdbc.Driver");
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject","root","");
				
				String sql1="INSERT INTO registration (`name`, `netID`, `password`, `type`) VALUES (?, ?,?,?)";
				st=c.prepareStatement(sql1);
				st.setString(1,name);
				st.setString(2, netID);
				
				st.setString(3, password);
				st.setString(4, type);
				
				st.executeUpdate();
				response.sendRedirect("Login.jsp");
				
			}catch(Exception e){
				System.out.println("Error is" +e);
			}
			
			
	}

}
