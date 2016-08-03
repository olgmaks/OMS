package com.softserve.edu.newuser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.Pause;
import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.uipages.AdministrationPage;
import com.softserve.edu.uipages.CreateNewUserPage;
import com.softserve.edu.uipages.LoginPage;

public class CheckInvalidLoginTest {

		@BeforeClass
		public static void setUp() {
			RunnerPage.load(UrlRepository.getLocalUrl());
		}

		@AfterClass
		public static void tearDown() throws Exception {
			RunnerPage.stop();
		}
		@Test
		public void checkInvalidLogin() {
			// PreCondition, goto createNewUserPage
			CreateNewUserPage createNewUserPage = new LoginPage()
					.successAdminLogin(UserRepository.getAdminUser())
					.goToAdministrationPage().gotoCreateNewUserPage();
			// Test Operation. Checking validator.isDisplayed
			AdministrationPage administrationPage = createNewUserPage.checkLogin(UserRepository.getInvalidUser());
			Pause.sleep(3000);
			administrationPage.logout();

}
}


