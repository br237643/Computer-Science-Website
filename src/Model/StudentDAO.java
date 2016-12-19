package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	public static Connection DbCon() throws ClassNotFoundException, SQLException{
		  Class.forName("com.mysql.jdbc.Driver");
		  String connectionString ="jdbc:mysql://localhost:3306/termproject";
		  return DriverManager.getConnection(connectionString+"?useUnicode=yes&characterEncoding=UTF-8","root","");
	}
	
	public static boolean studentRegistration(String name, String netID, String password, String year, String program, String major) throws ClassNotFoundException, SQLException
	{
		Statement smt = null;
		String query = "INSERT INTO student (`name`, `netID`, `password`, `year`, `program`, `major`) VALUES ('"+name+"', '"+netID+"', '"+password+"', '"+year+"', '"+program+"', '"+major+"')";
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
public static  String getStudentname(String username) throws SQLException, ClassNotFoundException{
		
		Statement smt = null;
		
		String query = "select * from student WHERE netID='"+username+"'";
		
		Connection con = DbCon();
		String name = new String();
		try{
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(query);
			while(rs.next()){
				name=rs.getString("name");
				
				
					
			}
			
		}catch(Exception ex){
			System.out.println(ex);
			
		}
	
	return name;
	
	}
public static  String getStudentAdvisor(String username) throws SQLException, ClassNotFoundException{
	
	Statement smt = null;
	
	String query = "select * from student WHERE netID='"+username+"'";
	
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
public static  String getStudentPhone(String username) throws SQLException, ClassNotFoundException{
	
	Statement smt = null;
	
	String query = "select * from student WHERE netID='"+username+"'";
	
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
public static  String getStudentEmail(String username) throws SQLException, ClassNotFoundException{
	
	Statement smt = null;
	
	String query = "select * from student WHERE netID='"+username+"'";
	
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
public static boolean studentEditProfile(String phone, String email, String advisor, String netID)throws SQLException, ClassNotFoundException
{
	Statement smt = null;
	String query = "UPDATE student  SET  phone='"+phone+"' , email='"+email+"' , advisorInfo='"+advisor+"'    WHERE netID='"+netID+"'";

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
public static  String getStudentstatus(String username) throws SQLException, ClassNotFoundException{
	
	Statement smt = null;
	
	String query = "select * from student WHERE netID='"+username+"'";
	
	Connection con = DbCon();
	String name = new String();
	try{
		smt = con.createStatement();
		ResultSet rs = smt.executeQuery(query);
		while(rs.next()){
			name=rs.getString("status");
			
			
				
		}
		
	}catch(Exception ex){
		System.out.println(ex);
		
	}

return name;

}

}
