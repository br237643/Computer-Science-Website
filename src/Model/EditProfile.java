package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EditProfile {
	private static PreparedStatement st;
	 private static  Connection c;
	  private ResultSet rs;   

	public static Connection DbCon() throws ClassNotFoundException, SQLException{
		  Class.forName("com.mysql.jdbc.Driver");
		  String connectionString ="jdbc:mysql://localhost:3306/termproject";
		  return DriverManager.getConnection(connectionString+"?useUnicode=yes&characterEncoding=UTF-8","root","");
	}
	public static  String gettAdvisor(String username) throws SQLException, ClassNotFoundException{
		
		Statement smt = null;
		
		String query = "select * from registration WHERE netID='"+username+"'";
		
		Connection con = DbCon();
		String name = new String();
		try{
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(query);
			while(rs.next()){
				name=rs.getString("advisorInfo");
				
				
					
			}
			
		}catch(Exception ex){
			System.out.println(ex);
			
		}

	return name;

	}
	public static  String getPhone(String username) throws SQLException, ClassNotFoundException{
		
		Statement smt = null;
		
		String query = "select * from registration WHERE netID='"+username+"'";
		
		Connection con = DbCon();
		String name = new String();
		try{
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(query);
			while(rs.next()){
				name=rs.getString("phone");
				
				
					
			}
			
		}catch(Exception ex){
			System.out.println(ex);
			
		}

	return name;

	}
	public static  String getEmail(String username) throws SQLException, ClassNotFoundException{
		
		Statement smt = null;
		
		String query = "select * from registration WHERE netID='"+username+"'";
		
		Connection con = DbCon();
		String name = new String();
		try{
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(query);
			while(rs.next()){
				name=rs.getString("email");
				
				
					
			}
			
		}catch(Exception ex){
			System.out.println(ex);
			
		}

	return name;

	}
	public static boolean EditProfile(String phone, String email, String advisor, String netID)throws SQLException, ClassNotFoundException
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
			String sql="UPDATE registration  SET  phone=? , email=? , advisorInfo=?    WHERE netID=?";
			  
			
				      
			  st=c.prepareStatement(sql);
			  st.setString(1, phone);
			  st.setString(2, email);
			  st.setString(3, advisor);
			  st.setString(4, netID);
			  st.executeUpdate ();
			 
			
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	
	}

}
