package com.softserve.edu.customer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.Pause;
import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.AddItemPageFilters.SearchProperty;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.AddItemPage;
import com.softserve.edu.uipages.LoginPage;
import com.softserve.edu.uipages.OrderDetailsPage;

public class AddItemPageSearchTest {
	public final String SEARCH_VALUE_NAME = "brains";
	public final String SEARCH_VALUE_DESCRIPTION = "produ";
	public final int NUMBER_OF_RESULTS = 10;

	@BeforeClass
	public static void setUp() {
		// TODO change to another page with LoweCase
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() throws Exception {

		RunnerPage.stop();
	}

	@Test
	public void addItemPageSearchTest() {

		// PreCondition
		/*
		 * Go to 'Order details' page
		 */
		OrderDetailsPage orderDetailsPage = new LoginPage()
				.successCustomerLogin(UserRepository.getCustomerUser())
				.goToOrderingPage().goToOrderDetailsPage();

		/*
		 * Go to 'AddItemPage' page
		 */
		AddItemPage addItemPage = orderDetailsPage.goToAddItemPage();

		// Test Operation
		/*
		 * Set search property (by 'Item Name') and value in search box on
		 * 'AddItemPage' page
		 */
		addItemPage.setSearchProperty(SearchProperty.ITEM_NAME.toString());
		addItemPage.setSearchValue(SEARCH_VALUE_NAME);
		addItemPage = addItemPage.clickSearchButton();

		/*
		 * Verify that search by filter 'Item Name' works correctly
		 */
		Specification specification = Specification.get()
				.forElement(addItemPage.getCellText(1, 0).toString())
				.valueMatch(SEARCH_VALUE_NAME).next();
		Pause.sleep();

		/*
		 * Set search property (by 'Item Description') and value in search box
		 * on 'AddItemPage' page
		 */
		addItemPage.setSearchProperty(SearchProperty.ITEM_DESCRIPTION
				.toString());
		addItemPage.setSearchValue(SEARCH_VALUE_DESCRIPTION);
		addItemPage = addItemPage.clickSearchButton();

		/*
		 * Verify that search by filter 'Item Description' works correctly for
		 * every result returned after searching
		 */
		for (int i = 1; i <= addItemPage.getAmountOfResults(); i++) {
			specification.forElement(addItemPage.getCellText(i, 1).toString())
					.valueStartWith(SEARCH_VALUE_DESCRIPTION).next();
		}

		// Back to Previous State
		/*
		 * Return to the orderDetailsPage
		 */
		orderDetailsPage = addItemPage.clickCancelButton();
		/*
		 * Logout of the system
		 */
		orderDetailsPage.logOut();

		// Checking
		/*
		 * Checking if there was an error during test
		 */
		specification.check();
	}

}
