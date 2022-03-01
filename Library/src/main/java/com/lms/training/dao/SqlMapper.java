package com.lms.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lms.dbfw.ResultMapper;
import com.lms.training.domain.Admin;
import com.lms.training.domain.Bookdetails;
import com.lms.training.domain.Student;


public class SqlMapper {

	public static final ResultMapper MAP_ADMIN = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Admin admin = new Admin();
			admin.setAdminid(rs.getInt("adminid"));
			admin.setAdminpassword(rs.getString("adminpassword"));
			return admin;

		}
	};
	public static final String ADD_ADMIN = "insert into admin values(?,?,?,?,?)";
	public static final String FETCH_ADMIN = "select * from admin where adminid=?";


//================================================================================================================
	
	public static final ResultMapper MAP_STUDENT = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Student student = new Student();
			student.setStudentid(rs.getInt("studentid"));
			student.setStudentpassword(rs.getString("studentpassword"));
			return student;

		}
	};
	public static final String FETCH_STUDENT = "select * from student where studentid=? and studentpassword=?";
	public static final String ADD_STUDENT = "insert into student values(?,?,?,?,?)";
	public static final String UPDATE_STUDENT = "update  student set studentcontactnumber=? where studentid=?";
	public static final String DELETE_STUDENT = "delete from  student where studentid=?";



	//================================================================================================================
	public static final ResultMapper BOOK_MAPPER= new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Bookdetails book = new Bookdetails();
			book.setBookname(rs.getString("bookname"));
			book.setIsbn(rs.getInt("isbn"));
			book.setAuthor(rs.getString("author"));
			book.setPublisher(rs.getString("publisher"));
			book.setEdition(rs.getInt("edition"));
			book.setPrice(rs.getInt("price"));
			book.setQuantity(rs.getInt("quantity"));
			return book;

		}
	};
	public static final String FETCH_BOOKS = "select * from bookdetails" ;
	public static final String ADD_BOOKS = "insert into bookdetails values(?,?,?,?,?,?,?)";
	public static final String DELETE_BOOK = "delete from  bookdetails where isbn=?";
	public static final String UPDATE_BOOK = "update  bookdetails set price=? where isbn=?";
	public static final String REQUEST_BOOK = "insert into requestbook values(?,?,?,?)";
	public static final String CANCEL_BOOK = "insert into cancelbook values(?,?,?,?)";
	public static final String RETURN_BOOK = "insert into returnbook values(?,?,?,?)";

}







