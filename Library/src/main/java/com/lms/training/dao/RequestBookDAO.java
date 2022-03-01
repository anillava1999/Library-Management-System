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

public class RequestBookDAO
{
	static Logger log = Logger.getLogger(RequestBookDAO.class);

	public int RequestBook (final int studentid,final int isbn,final String requestbook,final java.sql.Date requestdate ) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException 
			{
				pStmt.setInt(1,studentid);
				pStmt.setInt(2,isbn);
				pStmt.setString(3,requestbook);
				pStmt.setDate(4,requestdate);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.REQUEST_BOOK, mapper);
			log.debug("GOT CONNECTION");


		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}	
}
