package com.lms.training.UnitTesting;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.lms.dbcon.DBConnectionException;
import com.lms.training.dao.AdminRegisterDAO;
import com.lms.training.dao.StudentRegisterDAO;
import com.lms.training.domain.Student;
import junit.framework.AssertionFailedError;



public class AdminSideTest
{
	static Connection con=null; 
	static String url="jdbc:mysql://localhost:3308/LMS";
	static AdminRegisterDAO dao;
	
	// Connection testing
	@BeforeAll
	public static void init() throws DBConnectionException 
	{ 
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","@433428Anil@");
			System.out.println(con);
		}
		catch (ClassNotFoundException e)
		{ 
			e.printStackTrace();
		}
		catch (SQLException e) 
		{ 
			e.printStackTrace();
		}
	}

	
	// Operations Testing
	//@Disabled
	@Test
	 public void testRegisterAdmin()
	{
		try {
			String query = "insert into admin values(1003,'kiran',345,'sgmail.com',5004)";
			int no = con.createStatement().executeUpdate(query);
			assertEquals(1, no);
			System.out.println(" SUCCESSFULLY INSERTED THE BOOK DATA ");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} 
	
	}

	

	//Book Insertion Testing
	@Disabled
	@Test
	public void testForBookInsertion() {

		try {
			String query = "insert into bookdetials values('jockey',10053,'god','kiran',3,500,454)";
			int no = con.createStatement().executeUpdate(query);
			assertEquals(1, no);
			System.out.println(" SUCCESSFULLY INSERTED THE BOOK DATA ");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}  

	}
	
	// Student Update Data Testing
		@Disabled
		@Test
		public void testSUpdatio() {
			
			try {
				String query = "update student set studentContactNo=988384945 where studentRollId=34";
				int no = con.createStatement().executeUpdate(query);
				assertEquals(no, 1);
				System.out.println(" SUCCESSFULLY  UPDATED  STUDENT DATA ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (AssertionFailedError error) {
				System.err.println(" FAIL TO UPDATE THE RECORD... NO DATA IS FOUND" + error.toString());
			}

		}
//  Book Update Data Testing
	@Disabled
	@Test
	public void testBUpdation() {
		
		try {
			String query = "update bookdetails set author ='silver' where bookisbn=12";
			int no = con.createStatement().executeUpdate(query);
			assertEquals(no, 1);
			System.out.println(" SUCCESSFULLY  UPDATED  BOOK ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AssertionFailedError error) {
			System.err.println("FAIL TO UPDATE THE RECORD... NO DATA  FOUND##" + error.toString());
		}

	}
	
	// Book Data  Deletion Testing
		@Disabled
		@Test
		public void testBDeletion() {
			String query = "delete from bookdetials where bookisbn=1003";
			try {
				int no = con.createStatement().executeUpdate(query);
				assertEquals(no, 1);
				System.out.println("SUCCESSFULLY DELTED BOOK DATA");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("FAIL TO DELETE THE RECORD... NO DATA FOUND" + e.toString());
			}

		}
	@AfterAll
	public static void setUpAfterClass()
	{
		dao=null;
		System.out.println("After class");
	}
}

