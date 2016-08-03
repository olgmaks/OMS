package com.softserve.edu.customer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.AddItemPage;
import com.softserve.edu.uipages.LoginPage;
import com.softserve.edu.uipages.OrderDetailsPage;

/**
 * 
 * @author bkliutc
 *
 */
public class OrderDetailsPageTableTest {
	/**
	 * This fields use for test's data
	 */
	final String BEFORE_PRODUCT_ID_PART = "selectFrom";
	final String FIRST_SELECTED_PRODUCT_ID = "13";
	final String FIRST_SELECTED_PRODUCT_NAME = "bear";
	final String FIRST_SELECTED_PRODUCT_QUANTITY = "1";
	final String SECOND_SELECTED_PRODUCT_ID = "12";
	final String SECOND_SELECTED_PRODUCT_NAME = "brains";
	final String SECOND_SELECTED_PRODUCT_QUANTITY = "3";

	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		RunnerPage.stop();
	}

	@Test
	public void createNewRowInTableTest() {
		// PreCondition
		/*
		 * Go to 'Order details' page
		 */
		OrderDetailsPage orderDetailsPage = new LoginPage()
				.successCustomerLogin(UserRepository.getCustomerUser())
				.goToOrderingPage().goToOrderDetailsPage();

		// Test Operation
		/*
		 * Switching to 'Add item' page and select first test's data
		 */
		AddItemPage addItemPage = orderDetailsPage.goToAddItemPage()
				.setSelectedPruductById(
						BEFORE_PRODUCT_ID_PART + FIRST_SELECTED_PRODUCT_ID);
		/*
		 * Confirm chosen product and return to 'Order details' page
		 */
		orderDetailsPage = addItemPage.clickDoneButton();
		// Preparation Check
		/*
		 * Verify if the chosen product appears in table
		 */
		Specification specification = Specification.get();
		specification
				.forElement(
						orderDetailsPage.getItemNameFromRow(orderDetailsPage
								.indexOfRowByItemNumber(FIRST_SELECTED_PRODUCT_ID)))
				.valueMatch(FIRST_SELECTED_PRODUCT_NAME).next();

		// Back to Previous State
		/*
		 * Log OUT and return to 'Loggin' page
		 */
		orderDetailsPage.logOut();
		// Checking
		/*
		 * Checking if there were errors during test
		 */
		specification.check();
	}

	@Test
	public void editRowInTableTest() {
		// PreCondition
		/*
		 * Go to 'Add item' page, choose product and confirm the election
		 */
		OrderDetailsPage orderDetailsPage = new LoginPage()
				.successCustomerLogin(UserRepository.getCustomerUser())
				.goToOrderingPage()
				.goToOrderDetailsPage()
				.goToAddItemPage()
				.setSelectedPruductById(
						BEFORE_PRODUCT_ID_PART + FIRST_SELECTED_PRODUCT_ID)
				.clickDoneButton();

		// Test Operation
		/*
		 * Find product in table and click 'edit' link, switch to 'Add item'
		 * page
		 */
		AddItemPage addItemPage = orderDetailsPage
				.clickEditFromRow(orderDetailsPage
						.indexOfRowByItemNumber(FIRST_SELECTED_PRODUCT_ID));
		/*
		 * Select second test's data product with appropriate quantity, confirm
		 * selection and return to 'Order details' page
		 */
		orderDetailsPage = addItemPage
				.setSelectedPruductById(
						BEFORE_PRODUCT_ID_PART + SECOND_SELECTED_PRODUCT_ID)
				.setQuantity(SECOND_SELECTED_PRODUCT_QUANTITY)
				.clickDoneButton();
		// Preparation Check
		/*
		 * Verify if the product which displayed in table are changed
		 */
		Specification specification = Specification
				.get()
				.forElement(
						orderDetailsPage.getItemNumberFromRow(orderDetailsPage
								.indexOfRowByItemName(SECOND_SELECTED_PRODUCT_NAME))
								+ orderDetailsPage.getItemNameFromRow(orderDetailsPage
										.indexOfRowByItemNumber(SECOND_SELECTED_PRODUCT_ID)))
				.valueMatch(
						SECOND_SELECTED_PRODUCT_ID
								+ SECOND_SELECTED_PRODUCT_NAME).next();

		// Back to Previous State
		/*
		 * Log OUT and return to 'Loggin' page
		 */
		orderDetailsPage.logOut();
		// Checking
		/*
		 * Checking if there were errors during test
		 */
		specification.check();

	}

	@Test
	public void deleteRowInTableTest() {
		// PreCondition
		/*
		 * Go to 'Order details' page and add two products from test's data
		 */
		OrderDetailsPage orderDetailsPage = new LoginPage()
				.successCustomerLogin(UserRepository.getCustomerUser())
				.goToOrderingPage()
				.goToOrderDetailsPage()
				.goToAddItemPage()
				.setSelectedPruductById(
						BEFORE_PRODUCT_ID_PART + FIRST_SELECTED_PRODUCT_ID)
				.clickDoneButton()
				.goToAddItemPage()
				.setSelectedPruductById(
						BEFORE_PRODUCT_ID_PART + SECOND_SELECTED_PRODUCT_ID)
				.clickDoneButton();
		// Test Operation
		/*
		 * Find product in table by test's data second product ID and click
		 * 'delete' link
		 */
		orderDetailsPage = orderDetailsPage.clickDeleteFromRow(orderDetailsPage
				.indexOfRowByItemNumber(FIRST_SELECTED_PRODUCT_ID));
		// Preparation Check
		/*
		 * Verify if the product which remaining in table are equals to second
		 * selected product
		 */
		Specification specification = Specification
				.get()
				.forElement(
						orderDetailsPage.getItemNumberFromRow(orderDetailsPage
								.indexOfRowByItemNumber(SECOND_SELECTED_PRODUCT_ID))
								+ orderDetailsPage.getItemNameFromRow(orderDetailsPage
										.indexOfRowByItemName(SECOND_SELECTED_PRODUCT_NAME)))
				.valueMatch(
						SECOND_SELECTED_PRODUCT_ID
								+ SECOND_SELECTED_PRODUCT_NAME).next();

		// Back to Previous State
		/*
		 * Log OUT and return to 'Loggin' page
		 */
		orderDetailsPage.logOut();
		// Checking
		/*
		 * Checking if there was an error during test
		 */
		specification.check();
	}

}
