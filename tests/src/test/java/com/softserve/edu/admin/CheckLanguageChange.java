package com.softserve.edu.admin;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.Pause;
import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.AdminHomePage;
import com.softserve.edu.uipages.LoginPage;

public class CheckLanguageChange {
	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() {
		RunnerPage.stop();
		// DatabaseService.closeConnection();
	}

	// __________________________________________________________________
	// Added by Ostap Voitsekhovs'kyi
	@Test
	public void checkLanguageChanging() {

		// PreCondition
		/*
		 * Go to 'AdminHomePage' page
		 */
		AdminHomePage adminHomePage = new LoginPage()
				.successAdminLogin(UserRepository.getAdminUser());

		// Test Operation
		/*
		 * Changing language on 'AdminHomePage' page
		 */
		adminHomePage = adminHomePage.changeLanguage();
		Pause.sleep(1000);

		// Preparation Check
		/*
		 * Verify if language has been changed
		 */
		Specification specification = Specification.get()
				.forElement(adminHomePage.getLinkLanguageUS())
				.valueMatch("англ").next();

		// Test Operation
		/*
		 * Changing language on 'AdminHomePage' page
		 */
		adminHomePage = adminHomePage.changeLanguage();
		Pause.sleep(1000);
		
		// Preparation Check
		/*
		 * Verify if language has been changed
		 */
		specification.forElement(adminHomePage.getLinkLanguageUS())
				.valueMatch("en").next();

		// Back to Previous State
		/*
		 * Logout of the system
		 */
		adminHomePage.logout();

		// Checking
		/*
		 * Checking if there was an error during test
		 */
		specification.check();
	}

}
