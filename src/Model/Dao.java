package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;


public class Dao {
	private  PreparedStatement st;
	
	public static Connection DbCon() throws ClassNotFoundException, SQLException{
		  Class.forName("com.mysql.jdbc.Driver");
		  String connectionString ="jdbc:mysql://localhost:3306/termproject";
		  return DriverManager.getConnection(connectionString+"?useUnicode=yes&characterEncoding=UTF-8","root","");
	}
	
	public static List<Integer> getBookedSlots(Date date,String resourceType) throws ClassNotFoundException, SQLException{
		Statement smt = null;
		String query = "SELECT * from resource where date='"+date+"' and type='"+resourceType+"'";
		Connection con = DbCon();
		List<Integer> list = new ArrayList<>();
		try{
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(query);
			while(rs.next()){
				list.add(rs.getInt("value"));
			}
		}catch(Exception ex){
			System.out.println(ex);
		}
		return list;
	}
	
	public static boolean bookSlot(String username, Date date, String type, Integer slot) throws ClassNotFoundException, SQLException
	{
		Statement smt = null;
		String query = "INSERT INTO resource (`username`, `date`, `type`, `value`) VALUES ('"+username+"', '"+date+"', '"+type+"', '"+slot+"')";
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
	public static  String getname(String username) throws SQLException, ClassNotFoundException{
		
		Statement smt = null;
		System.out.println(username);
		String query = "select * from registration WHERE netID='"+username+"'";
		
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
	
	}
	

	
