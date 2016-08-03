package com.softserve.edu.administrationpage;

import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.SearchFilters.Condition;
import com.softserve.edu.data.SearchFilters.Field;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.User;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.login.LoginTest;
import com.softserve.edu.uipages.AdministrationPage;
import com.softserve.edu.uipages.LoginPage;

public class AdministrationPageTest {
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	private static final String INFO_LINE = "This page is appointed for creating new user for particular role.";
	private List<String> strings;
	private User tempUser = UserRepository.getTempUser();
	private User adminUser = UserRepository.getAdminUser();

	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		RunnerPage.stop();
	}

	 @Test
	public void checkLinksOnAdministrationPage() {
		logger.info("TEST: Check Redirection Of Links");
		AdministrationPage administrationPage = new LoginPage()
				.successAdminLogin(adminUser).goToAdministrationPage();

		specification
				.forElement(
						administrationPage.gotoCreateNewUserPage()
								.getInfoLine().getText()).valueMatch(INFO_LINE)
				.next();

		RunnerPage.previousPage();
		new AdministrationPage().logout();
		specification.check();
	}

	 @Test
	public void checkDefaultsValuesOfSearchFilters() {
		logger.info("TEST: Compare Default Values Of Serch Filters With Requirements");
		AdministrationPage administrationPage = new LoginPage()
				.successAdminLogin(adminUser).goToAdministrationPage();

		specification.forElement(administrationPage.getFieldValue())
				.valueMatch((Field.FIRST_NAME).toString()).next();
		specification.forElement(administrationPage.getConditionValue())
				.valueMatch((Condition.STARTS_WITH).toString()).next();
		administrationPage.logout();
		specification.check();
	}

	 @Test
	public void checkUserTableSorting() {
		logger.info("TEST: Testing Correctly Work Of Table Sorting");
		AdministrationPage administrationPage = new LoginPage()
				.successAdminLogin(adminUser).goToAdministrationPage();

		administrationPage = administrationPage
				.clickColumnHead(AdministrationPage.FIRST_NAME_COLUMN);
		verifySortedAscending(administrationPage.getAllFirstNames());

		administrationPage = administrationPage
				.clickColumnHead(AdministrationPage.LAST_NAME_COLUMN);
		verifySortedAscending(administrationPage.getAllLastNames());

		administrationPage = administrationPage
				.clickColumnHead(AdministrationPage.LOGIN_COLUMN);
		verifySortedAscending(administrationPage.getAllLogins());

		administrationPage = administrationPage
				.clickColumnHead(AdministrationPage.ROLE_COLUMN);
		verifySortedAscending(administrationPage.getAllRoles());

		administrationPage = administrationPage
				.clickColumnHead(AdministrationPage.REGION_COLUMN);
		verifySortedAscending(administrationPage.getAllRegion());
		specification.check();
		administrationPage.logout();
	}

	@Test
	public void checkValuesOfSearchFilters() {
		logger.info("TEST: Compare All Values Of Serch Filters With Requirements");
		AdministrationPage administrationPage = new LoginPage()
				.successAdminLogin(adminUser).goToAdministrationPage();
		
		verifyFirstDropDownValues(administrationPage.getAllFieldValues());
		verifySecondDropDownValues(administrationPage.getAllConditionValues());
		administrationPage.logout();

	}

	// @Test
	public void checkUserDelete() {
		logger.info("TEST: Testing User Deletion Via Table");
		AdministrationPage administrationPage = new LoginPage()
				.successAdminLogin(adminUser).goToAdministrationPage();

		administrationPage.gotoCreateNewUserPage().createNewUser(tempUser);

		int i = 0;
		do {
			administrationPage = new AdministrationPage();
			strings = administrationPage.getAllLogins();
			if (strings.indexOf(tempUser.getLogin()) >= 0) {
				administrationPage.clickUserDelete(strings.indexOf(tempUser
						.getLogin()));

				break;
			} else {
				administrationPage.forwardButtonClick();
			}
		} while (i == 0);

		administrationPage = new AdministrationPage();
		administrationPage.logout();
	}

	// @Test
	public void checkUserEdit() {

		AdministrationPage administrationPage = new LoginPage()
				.successAdminLogin(adminUser).goToAdministrationPage();

		administrationPage.gotoCreateNewUserPage().createNewUser(tempUser);

		for (int i = 0; i == 0;) {

			administrationPage = new AdministrationPage();
			strings = administrationPage.getAllLogins();
			if (strings.indexOf(tempUser.getLogin()) >= 0) {
				administrationPage.clickUserEdit(strings.indexOf(UserRepository
						.getTempUser().getLogin()));

				break;
			} else {
				administrationPage.forwardButtonClick();
			}
		}
		administrationPage.logout();
	}

	// @Test
	public void checkCountOfUsers() {

		AdministrationPage administrationPage = new LoginPage()
				.successAdminLogin(adminUser).goToAdministrationPage();

		System.out.println(administrationPage.getNumberOfFoundUsers());

		strings = administrationPage.getAllFirstNames();
		administrationPage = administrationPage.forwardButtonClick();
		strings.addAll(administrationPage.getAllFirstNames());
		administrationPage = administrationPage.forwardButtonClick();
		strings.addAll(administrationPage.getAllFirstNames());

		System.out.println(strings.size());
		administrationPage.logout();
	}

	Specification specification = Specification.get();
	
	private void verifyFirstDropDownValues (List<String> strList) {
		int check = 0;
		for (int i = 0; i < strList.size(); i++) {
			for (Field value : Field.values()) {
				if (strList.get(i).equals(value.toString()))
					check++;
				else
					continue;
			}
		}
		if ((check != strList.size())
				|| ((strList.size()) != Field.values().length)) {
			specification.failed();
		}
		specification.check();

	}
	
	private void verifySecondDropDownValues(List<String> strList) {
		int check = 0;
		for (int i = 0; i < strList.size(); i++) {
			for (Condition value : Condition.values()) {
				if (strList.get(i).equals(value.toString()))
					check++;
				else
					continue;
			}
		}
		if ((check != strList.size())
				|| ((strList.size()) != Condition.values().length)) {
			specification.failed();
		}
		specification.check();
	}



	private void verifySortedAscending(List<String> strList) {

		for (ListIterator<String> it = strList.listIterator(); it.hasNext(); it
				.next()) {
			if (it.hasPrevious()) {
				int comparator = strList.get(it.previousIndex()).compareTo(
						strList.get(it.nextIndex()));
				Boolean condition = (comparator <= 0) ? true : false;

				specification.forElement(condition.toString())
						.valueMatch("true").next();

			}
		}
	}
}
