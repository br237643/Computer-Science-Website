package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class JunitNewResource {

	@Test
	public void test19(){
		NewResource test19= new NewResource();
		 boolean output19=false;
		 try {
			output19=NewResource.addNewResource("projector234", "its good");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals(true, output19);
	}
	public void test20(){
		NewResource test20= new NewResource();
		 int output20=0;
		 try {
			output20=NewResource.checkNewResource("Projector2");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals(0, output20);
	}
	
	

}
