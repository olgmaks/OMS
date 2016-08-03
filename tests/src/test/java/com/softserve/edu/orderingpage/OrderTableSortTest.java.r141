package com.softserve.edu.orderingpage;

import java.util.List;
import java.util.ListIterator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.LoginPage;
import com.softserve.edu.uipages.OrderingPage;

public class OrderTableSortTest {
	/**
	 * This list is used to get all string values of a table column
	 */
	private List<String> strings;

	@BeforeClass
	public static void setUp() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		RunnerPage.stop();
	}

	@Test
	public void checkWarningMessageOnDelete() {
		/*
		 * Go to ordering page of OMS application
		 */
		OrderingPage orderingPage = new LoginPage().successCustomerLogin(
				UserRepository.getCustomerUser()).goToOrderingPage();

		/*
		 * Get first order name before clicking delete
		 */
		String orderNameBefore = orderingPage.getAllOrderNames().get(0);

		/*
		 * Click delete on the first order in order table and dismiss alert. The
		 * method returns the text of alert
		 */
		String alertMessage = orderingPage.clickOrderDeleteAndDismiss(1);

		/*
		 * Get first order name after clicking delete and dismissing alert
		 */
		String orderNameAfter = orderingPage.getAllOrderNames().get(0);

		/*
		 * Prepare for checking that alert message meet the specification
		 */
		Specification specification = Specification.get()
				.forElement(alertMessage)
				.valueMatch(OrderingPage.DELETE_WARNING_MESSAGE).next();

		/*
		 * Prepare for checking that first order name did not change after
		 * clicking delete and dismissing alert
		 */
		specification.forElement(orderNameBefore).valueMatch(orderNameAfter)
				.next();

		/*
		 * Return application to initial conditions (logout from application and
		 * returning to login page)
		 */
		orderingPage.logout();

		/*
		 * Check that message on alert meets specification and that the order
		 * was not deleted
		 */
		specification.check();
	}

	/*
	 * Inctance of Specification to hold and verify results of test
	 */
	Specification specification = Specification.get();

	@Test
	public void checkOrderTableSorting() {
		/*
		 * Go to ordering page of OMS application
		 */
		OrderingPage orderingPage = new LoginPage().successCustomerLogin(
				UserRepository.getCustomerUser()).goToOrderingPage();

		/*
		 * Check sorting by Order Name value
		 */

		/*
		 * First click on OrderName column head sorts orders in descending order
		 */
		orderingPage = orderingPage
				.clickColumnHead(OrderingPage.ORDER_NAME_COLUMN);

		/*
		 * Grab all OrderNames values and verify that they sorted in descending
		 * order
		 */
		strings = orderingPage.getAllOrderNames();
		verifySortedDescending(strings);

		/*
		 * Second click on OrderName column head sorts orders in ascending order
		 */
		orderingPage = orderingPage
				.clickColumnHead(OrderingPage.ORDER_NAME_COLUMN);
		/*
		 * Grab all OrderNames values and verify that they sorted in ascending
		 * order
		 */
		strings = orderingPage.getAllOrderNames();
		verifySortedAscending(strings);

		/*
		 * Check sorting by TotalPrice value
		 */

		/*
		 * First click on TotalPrice column head sorts orders in descending
		 * order
		 */
		orderingPage = orderingPage
				.clickColumnHead(OrderingPage.TOTAL_PRICE_COLUMN);

		/*
		 * Grab all TotalPrice values and verify that they sorted in descending
		 * order
		 */
		strings = orderingPage.getAllTotalPrices();
		verifySortedDescending(strings);

		/*
		 * Second click on TotalPrice column head sorts orders in ascending
		 * order
		 */
		orderingPage = orderingPage
				.clickColumnHead(OrderingPage.TOTAL_PRICE_COLUMN);
		/*
		 * Grab all TotalPrices values and verify that they sorted in ascending
		 * order
		 */
		strings = orderingPage.getAllTotalPrices();
		verifySortedAscending(strings);

		/*
		 * Check sorting by Max Discount value
		 */

		/*
		 * First click on Max Discount column head sorts orders in the
		 * descending order by Max Discount value
		 */
		orderingPage = orderingPage
				.clickColumnHead(OrderingPage.MAX_DISCOUNT_COLUMN);

		/*
		 * Grab all Max Discount values and verify that they are sorted in the
		 * descending order
		 */
		strings = orderingPage.getAllMaxDiscounts();
		verifySortedDescending(strings);

		/*
		 * Second click on Max Discount column head sorts orders in the
		 * ascending order by Max Discount value
		 */
		orderingPage = orderingPage
				.clickColumnHead(OrderingPage.MAX_DISCOUNT_COLUMN);
		/*
		 * Grab all Max Discount values and verify that they are sorted in the
		 * ascending order
		 */
		strings = orderingPage.getAllMaxDiscounts();
		verifySortedAscending(strings);

		/*
		 * Check sorting by Delivery Date value
		 */

		/*
		 * First click on Delivery Date column head sorts orders in the
		 * descending order by Delivery Date value
		 */
		orderingPage = orderingPage
				.clickColumnHead(OrderingPage.DELIVERY_DATE_COLUMN);

		/*
		 * Grab all Delivery Date values and verify that they are sorted in the
		 * descending order
		 */
		strings = orderingPage.getAllDeliveryDates();
		verifySortedDescending(strings);

		/*
		 * Second click on Delivery Date column head sorts orders in the
		 * ascending order by Delivery Date value
		 */
		orderingPage = orderingPage
				.clickColumnHead(OrderingPage.DELIVERY_DATE_COLUMN);
		/*
		 * Grab all Delivery Date values and verify that they are sorted in the
		 * ascending order
		 */
		strings = orderingPage.getAllDeliveryDates();
		verifySortedAscending(strings);

		/*
		 * Check sorting by Status value
		 */

		/*
		 * First click on Status column head sorts orders in the descending
		 * order by Status value
		 */
		orderingPage = orderingPage.clickColumnHead(OrderingPage.STATUS_COLUMN);

		/*
		 * Grab all Status values and verify that they are sorted in the
		 * descending order
		 */
		strings = orderingPage.getAllStatuses();
		verifySortedAscending(strings);

		/*
		 * Second click on Status column head sorts orders in the ascending
		 * order by Status value
		 */
		orderingPage = orderingPage.clickColumnHead(OrderingPage.STATUS_COLUMN);
		/*
		 * Grab all Status values and verify that they are sorted in the
		 * ascending order
		 */
		strings = orderingPage.getAllStatuses();
		verifySortedDescending(strings);

		/*
		 * Check sorting by Assignee value
		 */

		/*
		 * First click on Assignee column head sorts orders in the descending
		 * order by Assignee value
		 */
		orderingPage = orderingPage
				.clickColumnHead(OrderingPage.ASSIGNEE_COLUMN);

		/*
		 * Grab all Assignee values and verify that they are sorted in the
		 * descending order
		 */
		strings = orderingPage.getAllAssignees();
		verifySortedDescending(strings);

		/*
		 * Second click on Assignee column head sorts orders in the ascending
		 * order by Assignee value
		 */
		orderingPage = orderingPage
				.clickColumnHead(OrderingPage.ASSIGNEE_COLUMN);
		/*
		 * Grab all Assignee values and verify that they are sorted in the
		 * ascending order
		 */
		strings = orderingPage.getAllAssignees();
		verifySortedAscending(strings);

		/*
		 * Check sorting by Role value
		 */

		/*
		 * First click on Role column head sorts orders in the descending order
		 * by Role value
		 */
		orderingPage = orderingPage.clickColumnHead(OrderingPage.ROLE_COLUMN);

		/*
		 * Grab all Role values and verify that they are sorted in the
		 * descending order
		 */
		strings = orderingPage.getAllRoles();
		verifySortedDescending(strings);

		/*
		 * Second click on Role column head sorts orders in the ascending order
		 * by Role value
		 */
		orderingPage = orderingPage.clickColumnHead(OrderingPage.ROLE_COLUMN);
		/*
		 * Grab all Role values and verify that they are sorted in the ascending
		 * order
		 */
		strings = orderingPage.getAllRoles();
		verifySortedAscending(strings);

		/*
		 * Return application to initial conditions (logout from application and
		 * returning to login page)
		 */
		orderingPage.logout();

		/*
		 * Check if sorting works properly
		 */
		specification.check();
	}

	/**
	 * Verifies that List of Strings is sorted in descending order
	 * alphabetically
	 * 
	 * @param strList
	 */
	private void verifySortedDescending(List<String> strList) {
		// Expected result expressed in words. This will be actual result if
		// List sorted in Descending order
		String expectedResult = "Sorted in Descending order";

		// String to express wrong result, that is if List is not sorted in
		// Descending order
		String wrongResult = "Not sorted in Descending order";

		// Variable to represent actual result for verification of sorting
		String actualResult;

		// Compares all neighboring elements in List of String
		for (ListIterator<String> it = strList.listIterator(); it.hasNext(); it
				.next()) {
			if (it.hasPrevious()) {
				int comparator = 0;
				
				// Verifies that elements are not null and compares
				comparator = ((strList.get(it.previousIndex()) == null) || (strList
						.get(it.nextIndex()) == null)) ? 0 : strList.get(
						it.previousIndex()).compareTo(
						strList.get(it.nextIndex()));

				// Find actual result
				actualResult = (comparator >= 0) ? expectedResult : wrongResult;

				// Check if sorted in Descending order
				specification.forElement(expectedResult)
						.valueMatch(actualResult).next();
			}
		}
	}

	/**
	 * Verifies that List of Strings is sorted in ascending order
	 * 
	 * @param strList
	 */
	private void verifySortedAscending(List<String> strList) {
		// Expected result expressed in words. This will be actual result if
		// List sorted in Ascending order
		String expectedResult = "Sorted in Ascending order";

		// String to express wrong result, that is if List is not sorted in
		// Ascending order
		String wrongResult = "Not sorted in Ascending order";

		// Variable to represent actual result for verification of sorting
		String actualResult;

		// Compares all neighboring elements in List of String
		for (ListIterator<String> it = strList.listIterator(); it.hasNext(); it
				.next()) {
			if (it.hasPrevious()) {

				int comparator = 0;

				// Verifies that elements are not null and compares
				comparator = ((strList.get(it.previousIndex()) == null) || (strList
						.get(it.nextIndex()) == null)) ? 0 : strList.get(
						it.previousIndex()).compareTo(
						strList.get(it.nextIndex()));

				// Find actual result
				actualResult = (comparator <= 0) ? expectedResult : wrongResult;

				// Check if sorted in Ascending order
				specification.forElement(actualResult)
						.valueMatch(expectedResult).next();
			}
		}
	}
}