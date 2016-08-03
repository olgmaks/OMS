package com.softserve.edu.supervisor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.LoginPage;
import com.softserve.edu.uipages.SupervisorHomePage;

public class LoginSupervisorTest {

	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		RunnerPage.stop();
	}

	/*
	 * @Test public void checkUnknownUserLogin() { LoginPage loginPage = new
	 * LoginPage().unSuccesfulLogin(UserRepository.getInvalidUser());
	 * Specification.get().forElement(loginPage.getErrorMessage()).valueMatch(
	 * "Such user does not exist in the system - please try again")
	 * .next().check(); }
	 */

	// @Test
	// public void checkUserWithoutLogin() {
	// LoginPage loginPage = new LoginPage().unSuccesfulLogin(UserRepository
	// .getEmptyLoginUser());
	// Specification.get().forElement(loginPage.getErrorMessage())
	// .valueMatch("Please enter user name").next().check();
	// }

	// @Test
	// public void checkUserWithoutPassword() {
	// LoginPage loginPage = new LoginPage().unSuccesfulLogin(UserRepository
	// .getEmptyPasswordUser());
	// Specification.get().forElement(loginPage.getErrorMessage())
	// .valueMatch("Please enter password").next().check();
	// }

	// @Test
	// public void checkIncorrectUserLogin() {
	// LoginPage loginPage = new LoginPage().unSuccesfulLogin(UserRepository
	// .getInvalidLoginUser());
	// Specification
	// .get()
	// .forElement(loginPage.getErrorMessage())
	// .valueMatch(
	// "Such user does not exist in the system - please try again")
	// .next().check();
	// }

	// @Test
	// public void checkIncorrectUserPassword() {
	// LoginPage loginPage = new LoginPage().unSuccesfulLogin(UserRepository
	// .getInvalidPasswordUser());
	// Specification.get().forElement(loginPage.getErrorMessage())
	// .valueMatch("Password is incorrect - please try again").next()
	// .check();
	// }

	/*
	 * @Test public void checkAdminLogin() { // Precondition and Test
	 * AdminHomePage adminHomePage = new LoginPage().unSuccesfulLogin(
	 * UserRepository.getInvalidUser()).successAdminLogin(
	 * UserRepository.getAdminUser()); // Preparation Check Specification
	 * specification = Specification.get() .forElement(adminHomePage.getName())
	 * .valueMatch(UserRepository.getAdminUser().getName()).next()
	 * .forElement(adminHomePage.getRole())
	 * .valueMatch(UserRepository.getAdminUser().getRole()).next(); // Return to
	 * Previous State adminHomePage.logout(); // Checking specification.check();
	 * }
	 */

	// @Test
	// public void checkCustomerLogin() {
	// CustomerHomePage customerHomePage = new LoginPage().successCustomerLogin(
	// UserRepository.getValidCustomerUser());
	// Specification.get()
	// .forElement(customerHomePage.getName())
	// .valueMatch(UserRepository.getValidCustomerUser().getName()).next()
	// .forElement(customerHomePage.getRole())
	// .valueMatch(UserRepository.getValidCustomerUser().getRole()).next()
	// .check();
	// customerHomePage.logout();
	// }
	
	/**
	 * 
	 * @author nkramtc  
	 * 
	 */
	
	@Test
	public void checkSupervisorLogin() {
		SupervisorHomePage supervisorHomePage = new LoginPage()
				.successSupervisorLogin(UserRepository.getSupervisorUser());
		Specification.get().forElement(supervisorHomePage.getName())
				.valueMatch(UserRepository.getSupervisorUser().getName())
				.next().forElement(supervisorHomePage.getRole())
				.valueMatch(UserRepository.getSupervisorUser().getRole())
				.next().check();
		supervisorHomePage.logout();
	}

	/*
	 * @Test public void checkMerchandiserLogin() { UserHomePage userHomePage =
	 * new LoginPage().successMerchandiserLogin(
	 * UserRepository.getMerchandiser()); Specification.get()
	 * .forElement(userHomePage.getName())
	 * .valueMatch(UserRepository.getMerchandiser().getName()).next()
	 * .forElement(userHomePage.getRole())
	 * .valueMatch(UserRepository.getMerchandiser().getRole()).next() .check();
	 * userHomePage.logout(); }
	 */

	// @Test
	// public void checkSaveLoggedUser(){
	// AdminHomePage adminHomePage = new LoginPage().successAdminLogin(
	// UserRepository.getAdminUser());
	// LoginPage loginPage = adminHomePage.logout();
	// Specification.get()
	// .forElement(loginPage.getLogin())
	// .valueMatch(UserRepository.getAdminUser().getLogin()).next()
	// .forElement(loginPage.getPassword())
	// .valueMatch("").next()
	// .check();
	// System.out.println(loginPage.getLogin());
	// }

}
