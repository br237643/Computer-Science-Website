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

import Model.AnnouncementsDAO;
import Model.Dao;

/**
 * Servlet implementation class EditAnnouncementServlet
 */
@WebServlet("/EditAnnouncementServlet")
public class EditAnnouncementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static java.sql.PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAnnouncementServlet() {
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
		String ID=request.getParameter("CourseID");
		int id=Integer.valueOf(ID);
		System.out.println(id);
		String Title=null;
		String Description=null;
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
			String sql="Select * from announcements WHERE id_announcements=?";
			  
			
				      
			st=c.prepareStatement(sql);
			
			  st.setInt(1, id);
			  
			  st.executeQuery();
			  rs = st.getResultSet();
			  while(rs.next()){
				  Title=rs.getString("title");
				  Description=rs.getString("description");
			  }
			 
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("ID", ID);
		session.setAttribute("Description", Description);
		session.setAttribute("Title", Title);
		request.getRequestDispatcher("EditAnnouncement.jsp").forward(request, response);
		
	}

}
