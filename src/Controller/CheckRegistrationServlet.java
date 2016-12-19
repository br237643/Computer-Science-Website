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

import Model.Dao;

/**
 * Servlet implementation class CheckRegistrationServlet
 */
@WebServlet("/CheckRegistrationServlet")
public class CheckRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static java.sql.PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("Name");
		System.out.println(name);
		String netId=null;
		String Status="Registered";
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
			String sql="Select * From examregistration WHERE examname=?";
			  
			
				      
			st=c.prepareStatement(sql);
			
			  st.setString(1, name);
			  
			  st.executeQuery();
			  rs=st.getResultSet();
				while(rs.next()){
					netId=rs.getString("studentID");
					System.out.println(netId);
					
				}
				if(netId==null){
					Status="Not";
					request.setAttribute("Status", Status);
					request.setAttribute("name", name);
					request.getRequestDispatcher("ExamRegistration.jsp").forward(request, response);
				}
			 		if(netId!=null){
			 			request.setAttribute("Status", Status);
						request.setAttribute("name", name);
						request.getRequestDispatcher("ExamRegistration.jsp").forward(request, response);
			 		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
