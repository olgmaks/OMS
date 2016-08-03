package com.softserve.edu.administrationpage;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.User;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.AdministrationPage;
import com.softserve.edu.uipages.LoginPage;

public class UserDeletionTest {

	private List<String> listOfStrings;
	private User tempUser = UserRepository.getTempUser();
	private User adminUser = UserRepository.getAdminUser();
	private String errorMessage = "Your login attempt was not successful, try again.\n\nReason: Bad credentials.";

	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		RunnerPage.stop();
	}

	/**
	 * testingUserDeletion tests user deletion and verifies whether deleted user is able
	 * to log in to the system
	 * 
	 * @author sprottc
	 */

	@Test
	public void testingUserDeletion() {

		AdministrationPage administrationPage = new LoginPage()
				.successAdminLogin(adminUser)
				.goToAdministrationPage();

		administrationPage.gotoCreateNewUserPage().createNewUser(tempUser);
		
		/**
		 * Cycle goes through every page in table and searches for tempUser that should be deleted and deletes it.
		 */
		int i = 0;
		do {

			administrationPage = new AdministrationPage();
			listOfStrings = administrationPage.getAllLogins();
			if (listOfStrings.indexOf(tempUser.getLogin()) >= 0) {
				administrationPage.clickUserDelete(i);
				break;
			} else {
				administrationPage.forwardButtonClick();
			}

		} while (i == 0);
		
		// log out
		administrationPage = new AdministrationPage();
		administrationPage.logout();
		
		/**
		 *  verification whether deleted tempUser is able to log in to the system
		 */
		LoginPage loginPage = new LoginPage();
		loginPage.unSuccesfulLogin(tempUser);
		Specification.get()
		.forElement(loginPage.getActualErrorMessage())
		.valueMatch(errorMessage).next().check();
		

	}
}


