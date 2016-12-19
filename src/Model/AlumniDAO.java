 package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlumniDAO {
	private static PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;  
	public static Connection DbCon() throws ClassNotFoundException, SQLException{
		  Class.forName("com.mysql.jdbc.Driver");
		  String connectionString ="jdbc:mysql://localhost:3306/termproject";
		  return DriverManager.getConnection(connectionString+"?useUnicode=yes&characterEncoding=UTF-8","root","");
	}
	
	public static boolean AlumniCreation(String name, String year, String url, String details) throws ClassNotFoundException, SQLException
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
			String sql="INSERT INTO alumniinfo(`name`, `year`, `url`, `details`) VALUES  (?,  ?, ?,?)";
			  
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, name);
			  st.setString(2, year);
			  st.setString(3, url);
			  st.setString(4, details);
			  
			  st.executeUpdate ();
			 
			return true;
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean AlumniInfo(String name,String year,String url,String details, int ID) throws ClassNotFoundException, SQLException
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
			String sql="UPDATE alumniinfo SET name=?  , year=?,url=?  , details=? WHERE Id=?";
			  
			
				      
			  st=(PreparedStatement) c.prepareStatement(sql);
			  st.setString(1, name);
			  st.setString(2, year);
			  st.setString(3, url);
			  st.setString(4, details);
			  st.setInt(5, ID);
			  
			  st.executeUpdate ();
			 return true;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
}
}