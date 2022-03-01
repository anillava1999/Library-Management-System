package com.lms.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.apache.log4j.Logger;

import com.lms.dbcon.ConnectionHolder;
import com.lms.dbcon.DBConnectionException;
import com.lms.dbfw.DBFWException;
import com.lms.dbfw.DBHelper;
import com.lms.dbfw.ParamMapper;
import com.lms.training.domain.Bookdetails;

public class RegisterBooksDAO{
	static Logger log = Logger.getLogger(RegisterBooksDAO.class);

	public int addbooks(final Bookdetails book) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;

		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, book.getBookname());
				pStmt.setInt(2, book.getIsbn());
				pStmt.setString(3, book.getAuthor());
				pStmt.setString(4, book.getPublisher());
				pStmt.setInt(5, book.getEdition());
				pStmt.setInt(6, book.getPrice());
				pStmt.setInt(7, book.getQuantity());

			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_BOOKS, mapper);
			log.debug("GOT CONNECTION");


		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}

	public List<Bookdetails> list()
	{
		List<Bookdetails> list=new ArrayList<>();
		List book=null;
		ConnectionHolder ch=null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			log.debug("fetching");
			book=DBHelper.executeSelect(con, SqlMapper.FETCH_BOOKS,SqlMapper.BOOK_MAPPER );

		}catch(DBConnectionException e)
		{
			try {
				throw new DBConnectionException("Unable to Connect to db"+e);
			}catch(DBConnectionException e1)
			{
				e1.printStackTrace();
			}
		}catch(DBFWException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
					con.close();

			}catch(SQLException e) {
			}
		}
		return book;

	}

}