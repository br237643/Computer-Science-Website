package Model;

import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AnnouncementRetrival {

	public List<String> Title = new ArrayList<String>();
	private List<String> Vegie = new ArrayList<>();
	private static PreparedStatement st;
	private static Connection c;
	private static ResultSet rs;
	
	

	public static Connection DbCon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionString = "jdbc:mysql://localhost:3306/termproject";
		return (Connection) DriverManager.getConnection(connectionString + "?useUnicode=yes&characterEncoding=UTF-8",
				"root", "");
			
			
	}

	public List<String> announcementsDetails(){
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
		List<String> Title = new ArrayList<String>();
			c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "");
			String sql = "Select * from announcements";

			st = (PreparedStatement) c.prepareStatement(sql);

			st.executeQuery();
			int i=0;
			while (rs.next()) {
		Title.add(rs.getString("Title"));
		
		
		
		}	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Title;
	}
	
	
}
