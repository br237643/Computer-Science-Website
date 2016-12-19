package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class JunitAnnouncements {

	@Test
	public void test17() {
		AnnouncementsDAO test14 = new AnnouncementsDAO();
		
		boolean output17 = false;
		try {
			output17 =AnnouncementsDAO.announcementsDetails("hey", "This is good", 2);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, output17);
	}


}
