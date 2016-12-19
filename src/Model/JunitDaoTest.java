package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class JunitDaoTest {



	@Test
	public void test1() {
		Dao test = new Dao();
		
		String output = null;
		try {
			output = Dao.getname("SR957737");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Shanmugar Rathinasamy", output);
	}
	
	public void test3(){
		 StudentDAO test2= new StudentDAO();
		 String output2=null;
		 try {
			output2=StudentDAO.getStudentname("SB112233");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("Bhavani  Srinivas", output2);
	}
	public void test5(){
		 StudentDAO test5= new StudentDAO();
		 String output5=null;
		 try {
			output5=StudentDAO.getStudentAdvisor("SB112233");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("Neil Murray", output5);
	}
	public void test6(){
		 StudentDAO test6= new StudentDAO();
		 String output6=null;
		 try {
			output6=StudentDAO.getStudentEmail("SB112233");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("bramadevu@albany.edu", output6);
	} 
	public void test7(){
		 StudentDAO test7= new StudentDAO();
		 String output7=null;
		 try {
			output7=StudentDAO.getStudentPhone("SB112233");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("4435151925", output7);
	}
	public void test8(){
		 StudentDAO test8= new StudentDAO();
		 String output8=null;
		 try {
			output8=StudentDAO.getStudentstatus("SB112233");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals(null, output8);
	}
	public void test9(){
		 StudentDAO test9= new StudentDAO();
		 boolean output9=false;
		 try {
			output9=StudentDAO.studentEditProfile("2222", "srinivas.nick@gmail.com", "Neil Murray", "SB112233");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("true", output9);
	}
		 
				 
		
	}

	
	
	


