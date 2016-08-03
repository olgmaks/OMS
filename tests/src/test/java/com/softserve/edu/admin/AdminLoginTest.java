package com.softserve.edu.admin;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.SearchFilters.Condition;
import com.softserve.edu.data.SearchFilters.Field;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.service.DatabaseService;
import com.softserve.edu.service.UserService;
import com.softserve.edu.uipages.AdminHomePage;
import com.softserve.edu.uipages.AdministrationPage;
import com.softserve.edu.uipages.CreateNewUserPage;
import com.softserve.edu.uipages.CustomerHomePage;
import com.softserve.edu.uipages.LoginPage;

public class AdminLoginTest {

	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() {
		RunnerPage.stop();
		DatabaseService.closeConnection();
	}

	// @Test
	public void checkExistUser() {
		// PreCondition
		AdministrationPage administrationPage = new LoginPage()
				.successAdminLogin(UserRepository.getAdminUser())
				.goToAdministrationPage();
		// Test Operation
		administrationPage.searchBy(Field.LOGIN_NAME, Condition.EQUALS,
				UserRepository.getCustomerUser().getLogin());
		// Preparation Check
		// TODO
		Specification specification = Specification.get()
				.forElement(administrationPage.getFirstName())
				.valueMatch(UserRepository.getCustomerUser().getName()).next();
		// Back to Previous State
		administrationPage.logout();
		// Checking
		specification.check();
	}

	// @Test
	public void checkCreateNewUser() {
		// PreCondition
		CreateNewUserPage createNewUserPage = new LoginPage()
				.successAdminLogin(UserRepository.getAdminUser())
				.goToAdministrationPage().gotoCreateNewUserPage();
		// Test Operation
		AdministrationPage administrationPage = createNewUserPage
				.createNewUser(UserRepository.getNewUser());
		administrationPage.searchBy(Field.LOGIN_NAME, Condition.EQUALS,
				UserRepository.getNewUser().getLogin());
		// Preparation Check
		Specification specification = Specification.get()
				.forElement(administrationPage.getFirstName())
				.valueMatch(UserRepository.getNewUser().getName()).next();
		// Test Operation
		CustomerHomePage customerHomePage = administrationPage.logout()
				.successCustomerLogin(UserRepository.getNewUser());
		// Preparation Check
		specification.forElement(customerHomePage.getName())
				.valueMatch(UserRepository.getNewUser().getName()).next()
				.forElement(customerHomePage.getRole())
				.valueMatch(UserRepository.getNewUser().getRole()).next();
		// Back to Previous State
		administrationPage = customerHomePage.logout()
				.successAdminLogin(UserRepository.getAdminUser())
				.goToAdministrationPage();
		// TODO Bug found, must be > 1 in Table, do not Use Condition.EQUALS
		administrationPage.searchBy(Field.LOGIN_NAME, Condition.EQUALS,
				UserRepository.getNewUser().getLogin());
		administrationPage.deleteUser(UserRepository.getNewUser());
		administrationPage.logout();
		// Checking
		specification.check();
	}

	@Test
	public void CheckCreateNewUserDB() {
		// PreCondition
		CreateNewUserPage createNewUserPage = new LoginPage()
				.successAdminLogin(UserRepository.getAdminUser())
				.goToAdministrationPage().gotoCreateNewUserPage();
		// Test Operation
		AdministrationPage administrationPage = createNewUserPage
				.createNewUser(UserRepository.getNewUser());
		administrationPage.searchBy(Field.LOGIN_NAME, Condition.EQUALS,
				UserRepository.getNewUser().getLogin());
		// Preparation Check
		// TODO
		UserService userService = new UserService(UserRepository.getNewUser()
				.getLogin());
		Specification specification = Specification.get()
				.forElement(UserRepository.getNewUser().getLogin())
				.valueMatch(userService.getLoginUserDB())
				.next();
		specification
				.forElement(administrationPage.getFirstName())
				.valueMatch(userService.getNameUserDB())
				.next();
		// Back to Previous State
		// administrationPage.deleteUser();
		// TODO Specification Add forElement(boolean)
		userService.deleteUserDB();
		administrationPage.logout();
		// Checking
		specification.check();
	}


}
