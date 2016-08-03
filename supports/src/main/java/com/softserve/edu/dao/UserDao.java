package com.softserve.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.entity.UserDB;

public class UserDao {
	// TODO Insert, Update, Delete
	private static final String EMPTY_SPACE = " ";
	private static final String SQL_EXCEPTION_QUERY = "SQLException for Query: ";
	private static final String RESULT_SET_CLOSE_EXCEPTION = "Exception for resultSet.close(): ";
	private static final String STATEMENT_CLOSE_EXCEPTION = "Exception for statement.close(): ";
	//
	private static Logger logger = LoggerFactory.getLogger(UserDao.class);

	public UserDB getUserByLogin(String login) {
		UserDB user = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = String.format(UserDB.GET_USER_BY_LOGIN, login);
		try {
			statement = DatabaseUtils.getInstance().getConnection()
					.createStatement();
			resultSet = statement.executeQuery(query);
			if (resultSet.next()) {
				// TODO Use Builder
				user = new UserDB(Long.parseLong(resultSet.getString(1)),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),
						resultSet.getString(6), Long.parseLong(resultSet
								.getString(7)));
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
		return user;
	}

	public List<UserDB> getAllUsers() {
		List<UserDB> allUsers = new ArrayList<UserDB>();
		UserDB user = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String query = UserDB.GET_ALL_USERS;
		try {
			statement = DatabaseUtils.getInstance().getConnection()
					.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				// TODO Use Builder
				user = new UserDB(Long.parseLong(resultSet.getString(1)),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5),
						resultSet.getString(6), Long.parseLong(resultSet
								.getString(7)));
				allUsers.add(user);
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
		return allUsers;
	}

	public boolean deleteUserById(Long id) {
		Statement statement = null;
		boolean result = false;
		String query = String.format(UserDB.DELETE_USER_BY_ID, id);
		try {
			statement = DatabaseUtils.getInstance().getConnection()
					.createStatement();
			result = statement.execute(query);
		} catch (SQLException e) {
			String exception = SQL_EXCEPTION_QUERY + query + EMPTY_SPACE
					+ e.getStackTrace().toString();
			logger.error(exception);
			// e.printStackTrace();
			// TODO Throw Custom Exception
			throw new RuntimeException(exception);
		} finally {
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
		return result;
	}

}
