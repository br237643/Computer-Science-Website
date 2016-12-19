package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class AnnouncementsDAO {
	private static PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;   

	public static Connection DbCon() throws ClassNotFoundException, SQLException{
		  Class.forName("com.mysql.jdbc.Driver");
		  String connectionString ="jdbc:mysql://localhost:3306/termproject";
		  return DriverManager.getConnection(connectionString+"?useUnicode=yes&characterEncoding=UTF-8","root","");
	}
	
	public static boolean announcementsDetails(String Title,String Description, int ID) throws ClassNotFoundException, SQLException
	{
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
			String sql="UPDATE announcements SET title=?  , description=? WHERE id_announcements=?";
			  
			
				      
			  st=(PreparedStatement) c.prepareStatement(sql);
			  st.setString(1, Title);
			  st.setString(2, Description);
			  st.setInt(3, ID);
			  
			  st.executeUpdate ();
			 return true;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
}
}