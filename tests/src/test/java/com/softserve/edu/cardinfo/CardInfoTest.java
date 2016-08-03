package com.softserve.edu.cardinfo;

/**
 *
 * @author izadortc
 *  *
 */


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;




import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.AddItemPage;
import com.softserve.edu.uipages.CardInfoErrorPage;
import com.softserve.edu.uipages.LoginPage;
import com.softserve.edu.uipages.OrderDetailsPage;
import com.softserve.edu.uipages.OrderingPage;



public class CardInfoTest {
	final String FIRST_SELECTED_PRODUCT_ID = "13";
	final String ERROR_MESSAGE = "Credit Card Number is incorrect. Please, re-type it again.";
	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		 RunnerPage.stop();
	}

	@Test
	public void checkSuccCardInfoTest() {
		// PreCondition
		// go to ordering page of OMS application
		OrderingPage orderingPage = new LoginPage().successCustomerLogin(
				UserRepository.getCustomerUser()).goToOrderingPage();
		// go to ordering details page of OMS application
		OrderDetailsPage orderDetailsPage = orderingPage.goToOrderDetailsPage();
		// go to adding page of OMS application
		AddItemPage addItemPage = orderDetailsPage.goToAddItemPage()
				.setSelectedPruductById(
						"selectFrom" + FIRST_SELECTED_PRODUCT_ID);
		//choose order
		orderDetailsPage = addItemPage.clickDoneButton();
		orderDetailsPage.clickAsignee();
		orderDetailsPage.clickSave();
		orderDetailsPage = new OrderDetailsPage();
		// Preparation Check . Insert information with user repository
		orderDetailsPage.createNewCardInfo(UserRepository.getCardInfo());
		//Check the information on the order details page with user repository
		Specification specification = Specification.get()
				.forElement(orderDetailsPage.getCreditCardType().get(1))
					.valueMatch(UserRepository.getCardInfo().getCreditcardType())
				.next()
				.forElement(orderDetailsPage.getExpirymonth().get(0))
					.valueMatch(UserRepository.getCardInfo().getexpirymonth())
				.next()
				.forElement(orderDetailsPage.getExpiryyear().get(6))
					.valueMatch(UserRepository.getCardInfo().getexpiryyear())
				.next();
		//ordering
		orderDetailsPage.clickOrder();
		orderingPage = new OrderingPage();
		// Back to Previous State
		orderingPage.logout();
		// Checking
		specification.check();
	}



	@Test
	public void checkNoSuccCardInfoTest() {
		// PreCondition
				// go to ordering page of OMS application
		OrderingPage orderingPage = new LoginPage().successCustomerLogin(
				UserRepository.getCustomerUser()).goToOrderingPage();
		// go to ordering details page of OMS application
		OrderDetailsPage orderDetailsPage = orderingPage.goToOrderDetailsPage();
		// go to adding page of OMS application
		AddItemPage addItemPage = orderDetailsPage.goToAddItemPage()
				.setSelectedPruductById(
						"selectFrom" + FIRST_SELECTED_PRODUCT_ID);
		//choose order
		orderDetailsPage = addItemPage.clickDoneButton();
		orderDetailsPage.clickAsignee();
		orderDetailsPage.clickSave();
		orderDetailsPage = new OrderDetailsPage();
		// Preparation Check . Insert information with user repository
		orderDetailsPage.createNewCardInfo(UserRepository.getCardNoSuccInfo());
		//Check the information on the order details page with user repository
		Specification specification = Specification.get().forElement(orderDetailsPage.getCreditCardType()
				.get(1)).valueMatch(UserRepository.getCardNoSuccInfo().getCreditcardType()).next();
		specification = Specification.get().forElement(orderDetailsPage.getExpirymonth().
				get(0)).valueMatch(UserRepository.getCardNoSuccInfo().getexpirymonth()).next();
		specification = Specification.get().forElement(orderDetailsPage.getExpiryyear()
				.get(6)).valueMatch(UserRepository.getCardNoSuccInfo().getexpiryyear()).next();
		//incorrectly entered number
		orderDetailsPage.clickOrderError();
		//check information on error message
		specification = Specification.get().forElement(new CardInfoErrorPage().getErrorMessage())
				.valueMatch(ERROR_MESSAGE).next();
		orderDetailsPage = new CardInfoErrorPage().goToOrderDetailsPage();
		// Back to Previous State
		orderDetailsPage.logOut();
		// Checking
		specification.check();
	}



	@Test
		public void checkMaestroCardInfoTest() {
			// PreCondition
			// go to ordering page of OMS application
			OrderingPage orderingPage = new LoginPage().successCustomerLogin(
					UserRepository.getCustomerUser()).goToOrderingPage();
			// go to ordering details page of OMS application
			OrderDetailsPage orderDetailsPage = orderingPage.goToOrderDetailsPage();
			// go to adding page of OMS application
			AddItemPage addItemPage = orderDetailsPage.goToAddItemPage()
					.setSelectedPruductById(
							"selectFrom" + FIRST_SELECTED_PRODUCT_ID);
			//choose order
			orderDetailsPage = addItemPage.clickDoneButton();
			orderDetailsPage.clickAsignee();
			orderDetailsPage.clickSave();
			orderDetailsPage = new OrderDetailsPage();
			// Preparation Check . Insert information with user repository
			orderDetailsPage.createNewCardInfo(UserRepository.getCardMaestroInfo());
			//Check the information on the order details page with user repository
			Specification specification = Specification.get().forElement(orderDetailsPage.getCreditCardType()
					.get(3)).valueMatch(UserRepository.getCardInfo().getCreditcardType()).next();
			specification = Specification.get().forElement(orderDetailsPage.getExpirymonth().
					get(0)).valueMatch(UserRepository.getCardInfo().getexpirymonth()).next();
			specification = Specification.get().forElement(orderDetailsPage.getExpiryyear()
					.get(6)).valueMatch(UserRepository.getCardInfo().getexpiryyear()).next();
			//Check if opening  StartDateMaestro and IssueNumberMaestro
			orderDetailsPage.getStartDateMaestro().getIssueNumberMaestro();
			// Back to Previous State
			orderDetailsPage = new OrderDetailsPage();
			orderDetailsPage .logOut();
			// Checking
			specification.check();
		}



}
