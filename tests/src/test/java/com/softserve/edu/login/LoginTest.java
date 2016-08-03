package com.softserve.edu.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.LoggerRepository;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.User;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.AdminHomePage;
import com.softserve.edu.uipages.CustomerHomePage;
import com.softserve.edu.uipages.LoginPage;
import com.softserve.edu.uipages.MerchandiserHomePage;
import com.softserve.edu.uipages.SupervisorHomePage;

public class LoginTest {

	private static final Logger logger = LogManager.getLogger(LoginTest.class);

	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
		PropertyConfigurator.configure(LoggerRepository
				.getPathToLoggerProperties());
		logger.info(LoggerRepository.BEFORE_TEST_SUITE_MESSAGE);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		logger.info(LoggerRepository.AFTER_TEST_SUITE_MESSAGE);
		RunnerPage.stop();
	}

	@Test
	public void checkUnknownUserLogin() {
		//Checking invalid user logining. Expecting error message according to specification
		//User name and password are incorect
		logger.info("NEW TEST CASE : Check Unknown User Login");
		User invalidUser = UserRepository.getInvalidUser();
		//Load login page
		LoginPage loginPage = new LoginPage().unSuccesfulLogin(invalidUser);
		logger.info(LoggerRepository.getLoginMessage(invalidUser));
		//Checking of expecting error message presence
		Specification.get().forElement(loginPage.getActualErrorMessage())
				.valueMatch(loginPage.EXPECTED_ERROR_MESSAGE_INCORECT_LOGIN)
				.next().check();

	}

	@Test
	public void checkUserWithoutLogin() {
		//Checking invalid user logining. Expecting error message according to specification
		//User name is empty  
		logger.info("NEW TEST CASE : Check User Without Login");
		User emptyLoginUser = UserRepository.getEmptyLoginUser();
		//Load login page
		LoginPage loginPage = new LoginPage().unSuccesfulLogin(emptyLoginUser);
		logger.info(LoggerRepository.getLoginMessage(emptyLoginUser));
		//Checking of expecting error message presence
		Specification.get().forElement(loginPage.getActualErrorMessage())
				.valueMatch(loginPage.EXPECTED_ERROR_MESSAGE_WITHOUT_LOGIN)
				.next().check();

	}

	@Test
	public void checkUserWithoutPassword() {
		//Checking invalid user logining. Expecting error message according to specification
		//Password is empty  
		logger.info("NEW TEST CASE : Check User Without Password ");
		User emptyPasswordUser = UserRepository.getEmptyPasswordUser();
		//Load login page
		LoginPage loginPage = new LoginPage()
				.unSuccesfulLogin(emptyPasswordUser);
		logger.info(LoggerRepository.getLoginMessage(emptyPasswordUser));
		//Checking of expecting error message presence
		Specification.get().forElement(loginPage.getActualErrorMessage())
				.valueMatch(loginPage.EXPECTED_ERROR_MESSAGE_WITHOUT_PASSWORD)
				.next().check();

	}

	@Test
	public void checkIncorectUserLogin() {
		//Checking invalid user logining. Expecting error message according to specification
		//Incorect user name 
		logger.info("NEW TEST CASE : Check Incorrect User Login");
		User invalidLoginUser = UserRepository.getInvalidLoginUser();
		//Load login page
		LoginPage loginPage = new LoginPage()
				.unSuccesfulLogin(invalidLoginUser);
		logger.info(LoggerRepository.getLoginMessage(invalidLoginUser));
		//Checking of expecting error message presence
		Specification.get().forElement(loginPage.getActualErrorMessage())
				.valueMatch(loginPage.EXPECTED_ERROR_MESSAGE_INCORECT_LOGIN)
				.next().check();

	}

	@Test
	public void checkIncorrectUserPassword() {
		//Checking invalid user logining. Expecting error message according to specification
		//Incorect user password 
		logger.info("NEW TEST CASE : Check Incorrect User Password");
		User incorrectPasswordUser = UserRepository.getInvalidPasswordUser();
		//Load login page
		LoginPage loginPage = new LoginPage()
				.unSuccesfulLogin(incorrectPasswordUser);
		logger.info(LoggerRepository.getLoginMessage(incorrectPasswordUser));
		//Checking of expecting error message presence
		Specification.get().forElement(loginPage.getActualErrorMessage())
				.valueMatch(loginPage.EXPECTED_ERROR_MESSAGE_INCORECT_PASSWORD)
				.next().check();
	}

	@Test
	public void checkAdminLogin() {
		//Checking administrator logining. Expecting successful logining 
		logger.info("NEW TEST CASE : Check Administrator logining");
		// Precondition and Test
		User adminUser = UserRepository.getAdminUser();
		//Load administrator page
		AdminHomePage adminHomePage = new LoginPage()
				.successAdminLogin(adminUser);
		logger.info(LoggerRepository.getLoginMessage(adminUser));
		// Checking presents of expecting name and role on page
		Specification.get()
				.forElement(adminHomePage.getName())
				.valueMatch(adminUser.getName()).next()
				.forElement(adminHomePage.getRole())
				.valueMatch(adminUser.getRole()).next().check();
		// Return to Previous State
		adminHomePage.logout();
	}

	@Test
	public void checkCustomerLogin() {
		//Checking customer logining. Expecting successful logining 
		logger.info("NEW TEST CASE : Check Customer logining");
		// Precondition and Test
		User customerUser = UserRepository.getCustomerUser();
		//Load customer page
		CustomerHomePage customerHomePage = new LoginPage()
				.successCustomerLogin(customerUser);
		logger.info(LoggerRepository.getLoginMessage(customerUser));
		// Checking presents of expecting name and role on page
		Specification.get().forElement(customerHomePage.getName())
				.valueMatch(customerUser.getName()).next()
				.forElement(customerHomePage.getRole())
				.valueMatch(customerUser.getRole()).next().check();
		// Return to Previous State
		customerHomePage.logout();
	}

	@Test
	public void checkSupervisorLogin() {
		//Checking supervisor logining. Expecting successful logining 	
		logger.info("NEW TEST CASE : Check Supervisor logining");
		// Precondition and Test
		User supervisorUser = UserRepository.getSupervisorUser();
		//Load supervisor page
		SupervisorHomePage supervisorHomePage = new LoginPage()
				.successSupervisorLogin(supervisorUser);
		logger.info(LoggerRepository.getLoginMessage(supervisorUser));
		// Checking presents of expecting name and role on page
		Specification.get().forElement(supervisorHomePage.getName())
				.valueMatch(supervisorUser.getName()).next()
				.forElement(supervisorHomePage.getRole())
				.valueMatch(supervisorUser.getRole()).next().check();
		// Return to Previous State
		supervisorHomePage.logout();
	}

	@Test
	public void checkMerchandiserLogin() {
		//Checking merchandiser logining. Expecting successful logining 
		logger.info("NEW TEST CASE : Check Merchandiser logining");
		// Precondition and Test
		User merchandiserUser = UserRepository.getMerchandiserUser();
		//Load merchandiser page
		MerchandiserHomePage merchandiserHomePage = new LoginPage()
				.successMerchandiserLogin(merchandiserUser);
		logger.info(LoggerRepository.getLoginMessage(merchandiserUser));
		// Checking presents of expecting name and role on page
		Specification.get().forElement(merchandiserHomePage.getName())
				.valueMatch(merchandiserUser.getName()).next()
				.forElement(merchandiserHomePage.getRole())
				.valueMatch(merchandiserUser.getRole()).next().check();
		// Return to Previous State
		merchandiserHomePage.logout();
	}

}
