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
import com.lms.training.domain.Admin;
import com.lms.training.domain.Bookdetails;

public class AdminRegisterDAO {
	static Logger log = Logger.getLogger(AdminRegisterDAO.class);

	public int registerAdmin(final Admin admin) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException 
			{
				pStmt.setInt(1, admin.getAdminid());
				pStmt.setString(2, admin.getAdminpassword());
				pStmt.setInt(3, admin.getAdminroleid());
				pStmt.setString(4, admin.getAdminemailid());
				pStmt.setString(5, admin.getAdmincontactnumber());
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_ADMIN, mapper);
			log.debug("GOT CONNECTION");

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	public boolean validateAdmin(final int adminid) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List users = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, adminid);

			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			users= DBHelper.executeSelect(con, SqlMapper.FETCH_ADMIN,
					paramMapper, SqlMapper.MAP_ADMIN);
			log.debug("GOT CONNECTION");



		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (users != null && users.size() > 0);


	}
}
