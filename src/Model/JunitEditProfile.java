package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class JunitEditProfile {

	@Test
	public void test13() {
		EditProfile test13 = new EditProfile();
		
		String output13 = null;
		try {
			output13 = EditProfile.getEmail("SR957737");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("nobody@albany.edu", output13);
	}
	public void test14() {
		EditProfile test14 = new EditProfile();
		
		String output14 = null;
		try {
			output14 = EditProfile.getPhone("SR957737");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("123123123", output14);
	}
	public void test15() {
		EditProfile test15 = new EditProfile();
		
		String output15 = null;
		try {
			output15 = EditProfile.gettAdvisor("SR957737");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null, output15);
	}
	public void test16() {
		EditProfile test16 = new EditProfile();
		
		boolean output16 = false;
		try {
			output16 = EditProfile.EditProfile(null, null, null, null);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, output16);
	}
	



}
