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
import com.softserve.edu.uipages.AdministrationPage;
import com.softserve.edu.uipages.CustomerHomePage;
import com.softserve.edu.uipages.ItemManagementPage;
import com.softserve.edu.uipages.LoginPage;
import com.softserve.edu.uipages.MerchandiserHomePage;
import com.softserve.edu.uipages.OrderingPage;
import com.softserve.edu.uipages.SupervisorHomePage;

public class TestTabsClickability {
	private final String LABEL_TO_CHECK_ADMIN_PAGE = "This page is appointed "
			+ "for creating new and managing existing users";
	private final String LABEL_TO_CHECK_ORDERING_PAGE = "Create new order";
	private final String LABEL_TO_CHECK_MANAGEMENT_PAGE = "This page is appointed "
			+ "for adding new and editing existing products.";

	// Added by Ostap Voitsekhovs'kyi

	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		RunnerPage.stop();
	}

	@Test
	public void checkTabsClickability() {

		// PreCondition
		/*
		 * Go to 'AdminHomePage' page
		 */
		AdminHomePage adminHomePage = new LoginPage()
				.successAdminLogin(UserRepository.getAdminUser());
		Pause.sleep();

		// Test Operation
		/*
		 * Go to 'AdministrationPage' page
		 */
		AdministrationPage adminPage = adminHomePage.goToAdministrationPage();
		Pause.sleep();

		// Preparation Check
		/*
		 * Verify if opened page is correct
		 */
		Specification specification = Specification.get()
				.forElement(adminPage.getAppointmentTitle())
				.valueMatch(LABEL_TO_CHECK_ADMIN_PAGE).next();

		// Back to Previous State
		/*
		 * Logout of the system
		 */
		adminPage.logout();

		// PreCondition
		/*
		 * Go to 'CustomerHomePage' page
		 */
		CustomerHomePage customerHomePage = new LoginPage()
				.successCustomerLogin(UserRepository.getCustomerUser());
		Pause.sleep();
		// Test Operation
		/*
		 * Go to 'AdministrationPage' page
		 */
		OrderingPage orderingPage = customerHomePage.goToOrderingPage();
		Pause.sleep();

		// Preparation Check
		/*
		 * Verify if opened page is correct
		 */
		specification.forElement(orderingPage.getCreateNewOrder())
				.valueMatch(LABEL_TO_CHECK_ORDERING_PAGE).next();
		// Back to Previous State
		/*
		 * Logout of the system
		 */
		orderingPage.logout();

		// PreCondition
		/*
		 * Go to 'MerchandiserHomePage' page
		 */
		MerchandiserHomePage merchandiserHomePage = new LoginPage()
				.successMerchandiserLogin(UserRepository.getMerchandiserUser());
		Pause.sleep();
		// Test Operation
		/*
		 * Go to 'OrderingPage' page
		 */
		OrderingPage orderingPageMerchandiser = merchandiserHomePage
				.goToOrderingPage();
		Pause.sleep();
		// Preparation Check
		/*
		 * Verify if opened page is correct
		 */
		specification.forElement(orderingPageMerchandiser.getCreateNewOrder())
				.valueMatch(LABEL_TO_CHECK_ORDERING_PAGE).next();
		// Back to Previous State
		/*
		 * Logout of the system
		 */
		orderingPageMerchandiser.logout();

		// PreCondition
		/*
		 * Go to 'SupervisorHomePage' page
		 */
		SupervisorHomePage supervisorHomePage = new LoginPage()
				.successSupervisorLogin(UserRepository.getSupervisorUser());
		Pause.sleep();

		// Test Operation
		/*
		 * Go to 'ItemManagementPage' page
		 */
		ItemManagementPage itemManagementPage = supervisorHomePage
				.goToItemManagementPage();
		Pause.sleep();
		// Preparation Check
		/*
		 * Verify if opened page is correct
		 */
		specification.forElement(itemManagementPage.getAppointmentTitle())
				.valueMatch(LABEL_TO_CHECK_MANAGEMENT_PAGE).next();
		// Back to Previous State
		/*
		 * Logout of the system
		 */
		itemManagementPage.logout();

		// Checking
		/*
		 * Checking if there was an error during test
		 */
		specification.check();

	}
}
