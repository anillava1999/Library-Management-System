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
import com.lms.training.dao.StudentRegisterDAO;
import com.lms.training.domain.Student;
import junit.framework.AssertionFailedError;


class StudentSideTest {

	static Connection con=null; 
	static String url="jdbc:mysql://localhost:3308/LMS";

	static StudentRegisterDAO dao;

	//  Connection testing
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

	// Operations Testings
	@Disabled
	@Test
	public void testRegisterAdmin()
	{

		int no;
		try {
			String query = "INSERT INTO student (`studentid`, `studentpassword`, `studentroleid`, `studentemailid`) VALUES ('4', '34', '4545', 'd@gmail.com')";
			no = con.createStatement().executeUpdate(query);
			assertEquals(no, 1);
			System.out.println("Student Registration successful");
			no = con.createStatement().executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AssertionFailedError error) {
			System.err.println(" FAIL TO REGISTER THE RECORD..." + error.toString());
		}


	}


	// Student Update Data Testing
	@Disabled
	@Test
	void testSrudentUpdatie() {

		try {
			String query = "update student set ContactNo=988384945 where RollId=34";
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



	// Student Data  Deletion Testing
	@Disabled
	@Test
	void testSDeletion() {
		String query = "delete from student where studentrollid=35";
		try {
			int no = con.createStatement().executeUpdate(query);
			assertEquals(no, 1);
			System.out.println("SUCCESSFULLY DELETED STUDENT RECORD ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("FAIL TO DELETE THE RECORD... NO DATA  FOUND" + e.toString());
		}

	}


	// Request Book Method Testing
	@Disabled
	@Test
	void testForReqBook() {

		try {
			String query = "insert into requestbook values(34,123,'flower',19-03-2020)";
			int no = con.createStatement().executeUpdate(query);
			assertEquals(1, no);
			System.out.println("SUCCESSFULLY REQUESTED THE BOOK");
		} catch (SQLException e) {
			System.err.println("FAIL TO REQUEST THE BOOK..." + e.toString());
		}  

	}


	// Cancel Book Method Testing
	@Disabled
	@Test
	void testForCancel() {
		String query = "delete from cancelbook where studentid=34 and bookisbn=123";
		try {
			int no = con.createStatement().executeUpdate(query);
			assertEquals(no, 1);
			System.out.println("SUCCESSFULLY CANCELED THE REQUESTED BOOK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("FAIL TO CANCEL THE RECORD... " + e.toString());
		}

	}

	// Return Book Method Testing
	@Disabled
	@Test
	void testForApp() {
		String query = "delete from returnbook where   studentid=34 and bookisbn=123";
		try {
			int no = con.createStatement().executeUpdate(query);
			assertEquals(no, 1);
			System.out.println("SUCCESSFULLY RETURNED BOOK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("UNABLE TO RETURN THE BOOK" + e.toString());
		}

	}


	// Search Book Method Testing
	@Disabled
	@Test
	void testForGetBook() throws SQLException {
		String query="select * from bookdetails";
		ResultSet rs = con.createStatement().executeQuery(query);
		try {
			assertEquals(rs.next(), true);
			System.out.println("BOOK IS AVAILABLE");
		}catch(AssertionFailedError error) {
			System.err.println("BOOK IS NOT FOUND:"+error.getMessage());
		}
	}



	@AfterAll
	public static void setUpAfterClass()
	{
		dao=null;
		System.out.println("After class");
	}
}


