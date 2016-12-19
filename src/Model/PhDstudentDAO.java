package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhDstudentDAO {
	public static Connection DbCon() throws ClassNotFoundException, SQLException{
		  Class.forName("com.mysql.jdbc.Driver");
		  String connectionString ="jdbc:mysql://localhost:3306/termproject";
		  return DriverManager.getConnection(connectionString+"?useUnicode=yes&characterEncoding=UTF-8","root","");
	}
	
	public static boolean statusUpdate(String update, String netID) throws ClassNotFoundException, SQLException
	{
		Statement smt = null;
		String query = " UPDATE student SET status='"+update+"' WHERE netID='"+netID+"';";
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