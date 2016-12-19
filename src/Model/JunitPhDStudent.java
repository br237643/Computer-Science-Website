package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class JunitPhDStudent {

	@Test
	public void test21(){
		PhDstudentDAO test21= new PhDstudentDAO();
		 boolean output21=false;
		 try {
			output21=PhDstudentDAO.statusUpdate("good", "SB112233");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals(true, output21);
	}

}
