package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class JunitAlumniDAO {

	@Test
	public void test2(){
		 boolean output1 = true;
		 AlumniDAO test1= new AlumniDAO();
		 try {
			output1 =AlumniDAO.AlumniCreation("Srinivas", "1995", "www.google.com", "We are friends");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals(true, output1);
	}
	public void test4(){
		 boolean output2 = true;
		 AlumniDAO test4= new AlumniDAO();
		 try {
			output2 =AlumniDAO.AlumniInfo("Srinivas", "1995", "www.google.com", "We are friends", 10);
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals(true, output2);
	}
	
}
