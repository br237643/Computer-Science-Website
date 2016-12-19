package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewResource {
	private static PreparedStatement st;
	 private static  Connection c;
	  private static ResultSet rs;
	 
	public static Connection DbCon() throws ClassNotFoundException, SQLException{
		  Class.forName("com.mysql.jdbc.Driver");
		  String connectionString ="jdbc:mysql://localhost:3306/termproject";
		  return DriverManager.getConnection(connectionString+"?useUnicode=yes&characterEncoding=UTF-8","root","");
	}
	public static boolean addNewResource(String addResource, String details) throws ClassNotFoundException, SQLException
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
			String sql="INSERT INTO newresource(`name`, `details`) VALUES  (?,  ?)";
			  
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, addResource);
			  
			  st.setString(2, details);
			  
			  st.executeUpdate();
			 
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	
	public static int checkNewResource(String addResource) throws ClassNotFoundException, SQLException
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
			String sql="Select * from newresources WHERE addResource=?";
			  
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, addResource);
			   
			  if(rs !=null && rs.next()){
				return rs.getInt("idResource");  
				
			  }
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
}