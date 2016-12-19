package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class JunitStudent {

	@Test
	public void test22(){
		StudentDAO test22= new StudentDAO();
		 String output22=null;
		 try {
			output22=StudentDAO.getStudentAdvisor("SB112233");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("Neil Murray", output22);
	}
	public void test23(){
		StudentDAO test23= new StudentDAO();
		 String output24=null;
		 try {
			output24=StudentDAO.getStudentEmail("SB112233");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("bramadevu@albany.edu", output24);
	}
	public void test25(){
		StudentDAO test25= new StudentDAO();
		 String output25=null;
		 try {
			output25=StudentDAO.getStudentPhone("SB112233");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("4435151925", output25);
	}
}
