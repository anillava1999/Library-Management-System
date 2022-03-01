package com.lms.dbcon;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;


public class ConnectionHolder {

	public static ConnectionHolder instance = null;
	private DataSource ds = null;

	private ConnectionHolder() {

	}

	public static ConnectionHolder getInstance() throws DBConnectionException {
		synchronized (ConnectionHolder.class) {
			if (instance == null) {
				instance = new ConnectionHolder();
				instance.initAppDataSource();// it will set all the properties given in the context.xml by calling initAppDataSource method 
			}
		}
		return instance;
	}

	public Connection getConnection() throws DBConnectionException {

		try {
			return ds.getConnection(); // here is the connection process will happen by reading ds initialized values .. 
		} catch (SQLException e) {
			throw new DBConnectionException(e);
		}
	}

	public void dispose() throws DBConnectionException {
		BasicDataSource bds = (BasicDataSource) ds;
		try {
			bds.close();
		} catch (SQLException e) {
			throw new DBConnectionException("Unable to close the connection", e);
		}
	}






	private void initAppDataSource() throws DBConnectionException {
		Context initContext;  // who  will read context.xml 

		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/mydb");
		} catch (NamingException e) {
			throw new DBConnectionException("Unable to get datasource", e);

		}
	}

}
