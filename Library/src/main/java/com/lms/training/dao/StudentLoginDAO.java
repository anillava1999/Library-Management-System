
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

public class StudentLoginDAO {

	static Logger log = Logger.getLogger(StudentLoginDAO.class);

	public List validateStudent(final int sid, final String psw) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {
				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, sid);
					pStmt.setString(2, psw) ;


				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_STUDENT,
					paramMapper, SqlMapper.MAP_STUDENT);
			log.debug("GOT CONNECTION");


		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}


}


