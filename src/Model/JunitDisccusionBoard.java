package Model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class JunitDisccusionBoard {

	@Test
	public void test10(){
		DiscussionBoard test11= new DiscussionBoard();
		 String output10=null;
		 try {
			output10=DiscussionBoard.getPostedByname("2");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("Ramadevu Bhavani Srinivas", output10);
	}
	public void test11(){
		 DiscussionBoard test11= new DiscussionBoard();
		 String output11=null;
		 try {
			output11=DiscussionBoard.getPostTitle("2");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("Hey is this thing working.", output11);
	}
	public void test12(){
		DiscussionBoard test11= new DiscussionBoard();
		 boolean output12=false;
		 try {
			output12=DiscussionBoard.newPost("Ramadevu Bhavani Srinivas", "its J unit test case");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals(false, output12);
	}

}
