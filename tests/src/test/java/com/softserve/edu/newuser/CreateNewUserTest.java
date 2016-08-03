package com.softserve.edu.newuser;

import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.SearchFilters.Condition;
import com.softserve.edu.data.SearchFilters.Field;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.AdministrationPage;
import com.softserve.edu.uipages.CreateNewUserPage;
import com.softserve.edu.uipages.CustomerHomePage;
import com.softserve.edu.uipages.LoginPage;

public class CreateNewUserTest {
	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	// @AfterClass
	public static void tearDown() throws Exception {
		RunnerPage.stop();
	}
	@Test
		public void checkCreateNewUser() {
			// PreCondition, going to createNewUserPage
			CreateNewUserPage createNewUserPage = new LoginPage()
					.successAdminLogin(UserRepository.getAdminUser())
					.goToAdministrationPage().gotoCreateNewUserPage();
			// Test Operation. creating new user
			AdministrationPage administrationPage = createNewUserPage
					.createNewUser(UserRepository.getNewUser());
	
			administrationPage.searchBy(Field.LOGIN_NAME, Condition.EQUALS,
					UserRepository.getNewUser().getLogin());
			// Preparation Check
			Specification specification = Specification.get()
					.forElement(administrationPage.getFirstName())
					.valueMatch(UserRepository.getNewUser().getName()).next();
			// Test Operation. login to new customer user
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
}
