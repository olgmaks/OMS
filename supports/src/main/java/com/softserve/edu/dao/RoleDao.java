package com.softserve.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.entity.RoleDB;

public class RoleDao {
	// TODO Insert, Update, Delete
	private static final String EMPTY_SPACE = " ";
	private static final String SQL_EXCEPTION_QUERY = "SQLException for Query: ";
	private static final String RESULT_SET_CLOSE_EXCEPTION = "Exception for resultSet.close(): ";
	private static final String STATEMENT_CLOSE_EXCEPTION = "Exception for statement.close(): ";
	//
	private static Logger logger = LoggerFactory.getLogger(RoleDao.class);

	public RoleDB getRoleById(Long id) {
		RoleDB role = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = String.format(RoleDB.GET_ROLE_BY_ID, id);
		try {
			statement = DatabaseUtils.getInstance().getConnection()
					.createStatement();
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				role = new RoleDB(Long.parseLong(resultSet.getString(1)),
						resultSet.getString(2));
			}
		} catch (SQLException e) {
			String exception = SQL_EXCEPTION_QUERY + query + EMPTY_SPACE
					+ e.getStackTrace().toString();
			logger.error(exception);
			// e.printStackTrace();
			// TODO Throw Custom Exception
			throw new RuntimeException(exception);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception ex) {
					String exception = RESULT_SET_CLOSE_EXCEPTION
							+ ex.getStackTrace().toString();
					logger.warn(exception);
					// ex.printStackTrace();
					// TODO Throw Custom Exception
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception ex) {
					String exception = STATEMENT_CLOSE_EXCEPTION
							+ ex.getStackTrace().toString();
					logger.warn(exception);
					// ex.printStackTrace();
					// TODO Throw Custom Exception
				}
			}
		}
		return role;
	}

	public List<RoleDB> getAllRoles() {
		List<RoleDB> allRoles = new ArrayList<RoleDB>();
		RoleDB role = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = RoleDB.GET_ALL_ROLES;
		try {
			statement = DatabaseUtils.getInstance().getConnection()
					.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				role = new RoleDB(Long.parseLong(resultSet.getString(1)),
						resultSet.getString(2));
				allRoles.add(role);
			}
		} catch (SQLException e) {
			String exception = SQL_EXCEPTION_QUERY + query + EMPTY_SPACE
					+ e.getStackTrace().toString();
			logger.error(exception);
			// e.printStackTrace();
			// TODO Throw Custom Exception
			throw new RuntimeException(exception);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception ex) {
					String exception = RESULT_SET_CLOSE_EXCEPTION
							+ ex.getStackTrace().toString();
					logger.warn(exception);
					// ex.printStackTrace();
					// TODO Throw Custom Exception
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception ex) {
					String exception = STATEMENT_CLOSE_EXCEPTION
							+ ex.getStackTrace().toString();
					logger.warn(exception);
					// ex.printStackTrace();
					// TODO Throw Custom Exception
				}
			}
		}
		return allRoles;
	}
}
