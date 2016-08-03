//package com.softserve.edu.customer;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.softserve.edu.RunnerPage;
//import com.softserve.edu.data.UrlRepository;
//import com.softserve.edu.data.UserRepository;
//import com.softserve.edu.domain.Specification;
//import com.softserve.edu.engine.WebDriverUtils;
//import com.softserve.edu.uipages.AddItemPage;
//import com.softserve.edu.uipages.CreateNewOrderPage;
//import com.softserve.edu.uipages.LoginPage;
//
//public class CreateNewOrderTableRowTest {
//	final String FIRST_SELECTED_PRODUCT_ID = "13";
//	final String FIRST_SELECTED_PRODUCT_NAME = "bear";
//	final String FIRST_SELECTED_PRODUCT_QUANTITY = "1";
//	final String SECOND_SELECTED_PRODUCT_ID = "12";
//	final String SECOND_SELECTED_PRODUCT_NAME = "brains";
//	final String SECOND_SELECTED_PRODUCT_QUANTITY = "3";
//
//	@BeforeClass
//	public static void setUp() {
//		// TODO change to another page with LoweCase
//		RunnerPage.load(UrlRepository.getLocalUrl().toLowerCase());
//	}
//
//	@AfterClass
//	public static void tearDown() throws Exception {
//
//		RunnerPage.stop();
//	}
//
//	@Test
//	public void createNewRowInTableTest() {
//		// PreCondition
//
//		CreateNewOrderPage createNewOrderPage = new LoginPage()
//				.successCustomerLogin(UserRepository.getCustomerUser())
//				.goToOrderingPage().goToCreateNewOrderPage();
//
//		// Test Operation
//
//		AddItemPage addItemPage = createNewOrderPage.goToAddItemPage()
//				.setSelectedPruductById(
//						"selectFrom" + FIRST_SELECTED_PRODUCT_ID);
//		// addItemPage.setSelectedPruductById("selectFrom13");
//		createNewOrderPage = addItemPage.clickDoneButton();
////		Specification specification = Specification
////				.get()
////				.forElement(
////						createNewOrderPage.getItemNumber()
////								+ createNewOrderPage.getItemName())
////				.valueMatch(
////						FIRST_SELECTED_PRODUCT_ID + FIRST_SELECTED_PRODUCT_NAME)
////				.next();
//
//		// Back to Previous State
//		createNewOrderPage.logOut();
//		// Checking
////		specification.check();
//	}
//
//	@Test
//	public void editRowInTableTest() {
//		CreateNewOrderPage createNewOrderPage = new LoginPage()
//				.successCustomerLogin(UserRepository.getCustomerUser())
//				.goToOrderingPage()
//				.goToCreateNewOrderPage()
//				.goToAddItemPage()
//				.setSelectedPruductById(
//						"selectFrom" + FIRST_SELECTED_PRODUCT_ID)
//				.clickDoneButton();
////		AddItemPage addItemPage = createNewOrderPage.editClick();
////		createNewOrderPage = addItemPage
////				.setSelectedPruductById(
////						"selectFrom" + SECOND_SELECTED_PRODUCT_ID)
////				.setQuantity(SECOND_SELECTED_PRODUCT_QUANTITY)
////				.clickDoneButton();
//
////		Specification specification = Specification
////				.get()
////				.forElement(
////						createNewOrderPage.getItemNumber()
////								+ createNewOrderPage.getItemName())
////				.valueMatch(
////						SECOND_SELECTED_PRODUCT_ID
////								+ SECOND_SELECTED_PRODUCT_NAME).next();
//
//		// Back to Previous State
//		createNewOrderPage.logOut();
//		// Checking
////		specification.check();
//
//	}
//
//	@Test
//	public void deleteRowInTableTest() {
//
//		// PreCondition
//		CreateNewOrderPage createNewOrderPage = new LoginPage()
//				.successCustomerLogin(UserRepository.getCustomerUser())
//				.goToOrderingPage()
//				.goToCreateNewOrderPage()
//				.goToAddItemPage()
//				.setSelectedPruductById(
//						"selectFrom" + FIRST_SELECTED_PRODUCT_ID)
//				.clickDoneButton()
//				.goToAddItemPage()
//				.setSelectedPruductById(
//						"selectFrom" + SECOND_SELECTED_PRODUCT_ID)
//				.clickDoneButton();
//		// Test Operation
////		createNewOrderPage = createNewOrderPage.deleteClick();
//		// // Preparation Check
//
////		Specification specification = Specification
////				.get()
////				.forElement(
////						createNewOrderPage.getItemNumber()
////								+ createNewOrderPage.getItemName())
////				.valueMatch(
////						SECOND_SELECTED_PRODUCT_ID
////								+ SECOND_SELECTED_PRODUCT_NAME).next();
//
//		// Back to Previous State
//		createNewOrderPage.logOut();
//		// Checking
////		specification.check();
//	}
//
//}
