package com.softserve.edu.data;

public class LoggerRepository {

	private final static String PATH_TO_LOGGER_PROPERTIES = "target/test-classes/log4j.properties";

	// Log Messages
	static  String space  =  "\n------------------------------";

	public final static String BEFORE_TEST_SUITE_MESSAGE = space + "-\nNEW TEST SUITE :"+space;

	public final static String AFTER_TEST_SUITE_MESSAGE = space + "-\nEND OF TEST SUITE :"+space;

	private final static String LOGIN_MESSAGE = "Logining with LOGIN : '%s', PASSWORD : '%s', ROLE : '%s'";


	public static String getPathToLoggerProperties() {
		return PATH_TO_LOGGER_PROPERTIES;
	}

	public static String getLoginMessage(User user) {
		return String.format(LOGIN_MESSAGE, user.getLogin(),
				user.getPassword(), user.getRole());
	}


}
