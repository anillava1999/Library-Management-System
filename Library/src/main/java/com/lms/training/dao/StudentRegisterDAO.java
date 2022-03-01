
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
import com.lms.training.domain.Student;

public class StudentRegisterDAO {
	static Logger log = Logger.getLogger(StudentRegisterDAO.class);

	public int registerStudent (final Student student) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException 
			{
				pStmt.setInt(1, student.getStudentid());
				pStmt.setString(2, student.getStudentpassword());
				pStmt.setInt(3, student.getStudentroleid());
				pStmt.setString(4, student.getStudentemailid());
				pStmt.setString(5, student.getStudentcontactnumber());
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_STUDENT, mapper);
			log.debug("GOT CONNECTION");


		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	public boolean validateStudent(final int studentid,final String pswd) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List users = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, studentid);
				pStmt.setString(2, pswd);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			users= DBHelper.executeSelect(con, SqlMapper.FETCH_STUDENT,
					paramMapper, SqlMapper.MAP_STUDENT);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (users != null && users.size() > 0);


	}
}


