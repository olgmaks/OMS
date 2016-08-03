package com.softserve.edu.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DatabaseUtils {
	private static final String DB_PROPERTIES_FILE_NAME = "/db.properties";
	private static final String DB_PROPERTIES_USERNAME = "username";
	private static final String DB_PROPERTIES_PASSWORD = "password";
	private static final String DB_PROPERTIES_URL = "url";

	private static final String DEFAULT_PROPERTIES_USERNAME = "lv-117";
	private static final String DEFAULT_PROPERTIES_PASSWORD = "lv-117";
	private static final String DEFAULT_PROPERTIES_URL = "jdbc:jtds:sqlserver://ssu-sql12/Lv117proba;instance=tc;";
	//
	private static final String FILE_NOT_FOUND_EXCEPTION = "FileNotFoundException for db.properties: ";
	private static final String IO_EXCEPTION = "IOException for db.properties: ";
	private static final String DB_PROPERTIES_EXCEPTION = DB_PROPERTIES_FILE_NAME
			+ " could not be read";
	private static final String INPUT_STREAM_EXCEPTION = "Exception for fileInputStream.close(): ";
	private static final String SQL_EXCEPTION = "SQLException for DriverManager.getConnection(): ";
	//
	private static final String SPLITTER_OF_PROTOCOL_NAME = ":/";
	private static final Object SYNC_ROOT = new Object();
	//
	private static Connection connection = null;
	private static String username;
	private static String password;
	private static String url;
	private static DatabaseUtils instance = null;
	private static Logger logger;

	private DatabaseUtils() {
		logger = LoggerFactory.getLogger(DatabaseUtils.class);
	}

	public static synchronized DatabaseUtils getInstance() {
		if (instance == null) {
			synchronized (SYNC_ROOT) {
				if (instance == null) {
					instance = new DatabaseUtils();
					// String path =
					// DatabaseUtils.getInstance().getClass().getClassLoader().getResource("db.properties").getPath();
					// String path =
					// DatabaseUtils.getInstance().getClass().getResource("/db.properties").getPath();
					String path = DatabaseUtils.getInstance().getClass()
							.getResource(DB_PROPERTIES_FILE_NAME).toString();// .substring(LENGTH_OF_PROTOCOL_NAME);
					path = path.substring(path
							.indexOf(SPLITTER_OF_PROTOCOL_NAME)
							+ SPLITTER_OF_PROTOCOL_NAME.length());
					File file = new File(path);
					// System.out.println("**********PATH to DB Properties: "
					// + path);
					// System.out.println("**********file.canRead(): "
					// + file.canRead());
					// System.out.println("**********getResourceAsStream(): "
					// + DatabaseUtils
					// .getInstance()
					// .getClass()
					// .getResourceAsStream(
					// DB_PROPERTIES_FILE_NAME));
					if ((file.canRead())
							|| (DatabaseUtils
									.getInstance()
									.getClass()
									.getResourceAsStream(
											DB_PROPERTIES_FILE_NAME) != null)) {
						// if (true) {
						Properties properties = new Properties();
						// FileInputStream fileInputStream = null;
						InputStream fileInputStream = null;
						try {
							// fileInputStream = new FileInputStream(file);
							fileInputStream = DatabaseUtils
									.getInstance()
									.getClass()
									.getResourceAsStream(
											DB_PROPERTIES_FILE_NAME);
							properties.load(fileInputStream);
						} catch (FileNotFoundException e) {
							String exception = FILE_NOT_FOUND_EXCEPTION
									+ e.getStackTrace().toString();
							logger.error(exception);
							// e.printStackTrace();
							// TODO Throw Custom Exception
							throw new RuntimeException(exception);
						} catch (IOException e) {
							String exception = IO_EXCEPTION
									+ e.getStackTrace().toString();
							logger.error(exception);
							// e.printStackTrace();
							// TODO Throw Custom Exception
							throw new RuntimeException(exception);
						} finally {
							try {
								if (fileInputStream != null) {
									fileInputStream.close();
								}
							} catch (Exception e) {
								String exception = INPUT_STREAM_EXCEPTION
										+ e.getStackTrace().toString();
								logger.warn(exception);
								// TODO Throw Custom Exception
							}
						}
						username = properties.getProperty(
								DB_PROPERTIES_USERNAME,
								DEFAULT_PROPERTIES_USERNAME);
						password = properties.getProperty(
								DB_PROPERTIES_PASSWORD,
								DEFAULT_PROPERTIES_PASSWORD);
						url = properties.getProperty(DB_PROPERTIES_URL,
								DEFAULT_PROPERTIES_URL);
					} else {
						String exception = DB_PROPERTIES_EXCEPTION;
						logger.error(exception);
						// TODO Throw Custom Exception
						throw new RuntimeException(exception);
					}
					try {
						DriverManager
								.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
						connection = DriverManager.getConnection(url, username,
								password);
					} catch (SQLException e) {
						try {
							if (connection != null) {
								connection.close();
							}
						} catch (Exception ex) {
							String exception = INPUT_STREAM_EXCEPTION
									+ e.getStackTrace().toString();
							logger.warn(exception);
							// TODO Throw Custom Exception
						}
						String exception = SQL_EXCEPTION
								+ e.getStackTrace().toString();
						logger.error(exception);
						// e.printStackTrace();
						throw new RuntimeException(exception);
					}
				}
			} // synchronized (SYNC_ROOT) {
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception ex) {
			String exception = "Exception for connection.close(): "
					+ ex.getStackTrace().toString();
			logger.warn(exception);
			// TODO Throw Custom Exception
		}
	}
}
