package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DiscussionBoard {
	private static PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;   
	public static Connection DbCon() throws ClassNotFoundException, SQLException{
		  Class.forName("com.mysql.jdbc.Driver");
		  String connectionString ="jdbc:mysql://localhost:3306/termproject";
		  return DriverManager.getConnection(connectionString+"?useUnicode=yes&characterEncoding=UTF-8","root","");
	}
	
	public static boolean newPost(String name, String title)throws ClassNotFoundException, SQLException
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
			String sql="insert into discussionpost (`postedby`,  `title`) VALUES (  ?, ?)";
			  
			
				      
			  st=(PreparedStatement) c.prepareStatement(sql);
			  st.setString(1, name);
			  st.setString(2, title);
			  
			  st.executeUpdate ();
			 return true;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
public static  String getPostedByname(String postID) throws SQLException, ClassNotFoundException{
		
		Statement smt = null;
		
		String query = "select * from discussionpost WHERE Pid='"+postID+"'";
		
		Connection con = DbCon();
		String name = new String();
		try{
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(query);
			while(rs.next()){
				name=rs.getString("postedBy");
				
				
					
			}
			
		}catch(Exception ex){
			System.out.println(ex);
			
		}
	
	return name;
	
	}
public static  String getPostTitle(String postID) throws SQLException, ClassNotFoundException{
	
	Statement smt = null;
	
	String query = "select * from discussionpost WHERE Pid='"+postID+"'";
	
	Connection con = DbCon();
	String name = new String();
	try{
		smt = con.createStatement();
		ResultSet rs = smt.executeQuery(query);
		while(rs.next()){
			name=rs.getString("title");
			
			
				
		}
		
	}catch(Exception ex){
		System.out.println(ex);
		
	}

return name;

}

}