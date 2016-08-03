package com.softserve.edu.redirect;

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
		AdminHomePage adminHomePage = new LoginPage()
				.successAdminLogin(UserRepository.getAdminUser());
		Pause.sleep();
		// Test Operation
		AdministrationPage adminPage = adminHomePage.goToAdministrationPage();
		Pause.sleep();
		// Preparation Check
		Specification specification = Specification.get()
				.forElement(adminPage.getAppointmentTitle())
				.valueMatch(LABEL_TO_CHECK_ADMIN_PAGE).next();
		// Back to Previous State
		adminPage.logout();

		
		// PreCondition
		CustomerHomePage customerHomePage = new LoginPage()
				.successCustomerLogin(UserRepository.getCustomerUser());
		Pause.sleep();
		// Test Operation
		OrderingPage orderingPage = customerHomePage.goToOrderingPage();
		Pause.sleep();
		// Preparation Check
		specification.forElement(orderingPage.getCreateNewOrder())
				.valueMatch(LABEL_TO_CHECK_ORDERING_PAGE).next();
		// Back to Previous State
		orderingPage.logout();

		
		// PreCondition
		MerchandiserHomePage merchandiserHomePage = new LoginPage()
				.successMerchandiserLogin(UserRepository.getMerchandiserUser());
		Pause.sleep();
		// Test Operation
		OrderingPage orderingPageMerchandiser = merchandiserHomePage
				.goToOrderingPage();
		Pause.sleep();
		// Preparation Check
		specification.forElement(orderingPageMerchandiser.getCreateNewOrder())
		.valueMatch(LABEL_TO_CHECK_ORDERING_PAGE).next();
		// Back to Previous State
		orderingPageMerchandiser.logout();

		
		// PreCondition
		SupervisorHomePage supervisorHomePage = new LoginPage()
				.successSupervisorLogin(UserRepository.getSupervisorUser());
		Pause.sleep();
		// Test Operation
		ItemManagementPage itemManagementPage = supervisorHomePage
				.goToItemManagementPage();
		Pause.sleep();
		// Preparation Check
		specification.forElement(itemManagementPage.getAppointmentTitle())
		.valueMatch(LABEL_TO_CHECK_MANAGEMENT_PAGE).next();
		// Back to Previous State
		itemManagementPage.logout();

		
		// Checking
		specification.check();

	}
}
