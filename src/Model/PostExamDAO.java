package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class PostExamDAO {
	private static PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;   

	public static Connection DbCon() throws ClassNotFoundException, SQLException{
		  Class.forName("com.mysql.jdbc.Driver");
		  String connectionString ="jdbc:mysql://localhost:3306/termproject";
		  return DriverManager.getConnection(connectionString+"?useUnicode=yes&characterEncoding=UTF-8","root","");
	}
	
	public static boolean postExam(String owner,String examName, String examDate, String examDetails) throws ClassNotFoundException, SQLException
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
			String sql="insert into examination (`owner`,  `nameOfExam`,`dateOfExam`, `details`) VALUES (?,?,  ?, ?)";
			  
			
				      
			  st=(PreparedStatement) c.prepareStatement(sql);
			  st.setString(1, owner);
			  st.setString(2, examName);
			  st.setString(3, examDate);
			  st.setString(4, examDetails);
			  st.executeUpdate ();
			 return true;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
}
}