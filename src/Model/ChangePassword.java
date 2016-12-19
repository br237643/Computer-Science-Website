package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangePassword {
	public static Connection DbCon() throws ClassNotFoundException, SQLException{
		  Class.forName("com.mysql.jdbc.Driver");
		  String connectionString ="jdbc:mysql://localhost:3306/termproject";
		  return DriverManager.getConnection(connectionString+"?useUnicode=yes&characterEncoding=UTF-8","root","");
	}
	
	public static boolean facultyPasswordUpdate(String password, String netID) throws ClassNotFoundException, SQLException
	{
		Statement smt = null;
		String query = " UPDATE registration SET password='"+password+"' WHERE netID='"+netID+"';";
		Connection con = DbCon();
		boolean success = false;
		try{
			smt = con.createStatement();
			boolean result = smt.execute(query);
			success = true;
		}catch(Exception ex){
			System.out.println(ex);
			success = false;
		}
		return success;
	}
public static  String getStudentPassword(String username) throws SQLException, ClassNotFoundException{
		
		Statement smt = null;
		
		String query = "select * from student WHERE netID='"+username+"'";
		
		Connection con = DbCon();
		String name = new String();
		try{
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(query);
			while(rs.next()){
				name=rs.getString("password");
				
				
					
			}
			
		}catch(Exception ex){
			System.out.println(ex);
			
		}
	
	return name;
	
	}
	public static boolean studentPasswordUpdate(String password, String netID) throws ClassNotFoundException, SQLException
	{
		Statement smt = null;
		String query = " UPDATE student SET password='"+password+"' WHERE netID='"+netID+"';";
		Connection con = DbCon();
		boolean success = false;
		try{
			smt = con.createStatement();
			boolean result = smt.execute(query);
			success = true;
		}catch(Exception ex){
			System.out.println(ex);
			success = false;
		}
		return success;
	}
}