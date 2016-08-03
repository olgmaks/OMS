package com.softserve.edu.orderingpage;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.RunnerPage;
import com.softserve.edu.data.OrderingPageSearchFilters;
import com.softserve.edu.data.OrderingPageSearchFilters.FilterValueByRole;
import com.softserve.edu.data.OrderingPageSearchFilters.FilterValueByStatus;
import com.softserve.edu.data.SearchValuesRepository;
import com.softserve.edu.data.UrlRepository;
import com.softserve.edu.data.UserRepository;
import com.softserve.edu.domain.Specification;
import com.softserve.edu.uipages.LoginPage;
import com.softserve.edu.uipages.OrderingPage;

public class SearchFiltersTest {

	OrderingPage orderingPage;
	Specification specification;

	@BeforeClass
	public static void setUpClass() {
		RunnerPage.load(UrlRepository.getLocalUrl());
	}

	@AfterClass
	public static void tearDown() {
		RunnerPage.stop();
	}

	@Before
	public void setPreConditions() {
		orderingPage = new LoginPage().successCustomerLogin(
				UserRepository.getCustomerUser()).goToOrderingPage();
		specification = Specification.get();
	}

	@After
	public void check() {
		// Return to previous state
		orderingPage.logout();

		// Check after each test
		specification.check();

	}

	@Test
	public void filterByStatusTest() {

		// Filter orders by status equals created
		orderingPage.setFilterByStatus(FilterValueByStatus.CREATED);
		orderingPage = orderingPage.clickApplyButton();

		// Save test data
		/*
		 * Variable resultByStatusCreated contains all values of column status
		 * after filtering by status with value equals created
		 */
		List<String> resultByStatusCreated = orderingPage.getAllStatuses();

		// Prepare these for checking
		for (String result : resultByStatusCreated) {
			this.specification = specification.forElement(result)
					.valueMatch(FilterValueByStatus.CREATED.toString()).next();
		}

		// Filter orders by status equals delivered
		orderingPage.setFilterByStatus(FilterValueByStatus.DELIVERED);
		orderingPage = orderingPage.clickApplyButton();

		// Save test data
		/*
		 * Variable resultByStatusDelivered contains all values of column status
		 * after filtering by status with value equals delivered
		 */
		List<String> resultByStatusDelivered;
		resultByStatusDelivered = orderingPage.getAllStatuses();

		// Prepare these for checking
		for (String result : resultByStatusDelivered) {
			specification = specification.forElement(result)
					.valueMatch(FilterValueByStatus.DELIVERED.toString())
					.next();
		}

		// Filter orders by status equals pending
		orderingPage.setFilterByStatus(FilterValueByStatus.PENDING);
		orderingPage = orderingPage.clickApplyButton();

		// Save test data
		/*
		 * Variable resultByStatusDelivered contains all values of column status
		 * after filtering by status with value equals pending
		 */
		List<String> resultByStatusPending;
		resultByStatusPending = orderingPage.getAllStatuses();

		// Prepare these for checking
		for (String result : resultByStatusPending) {
			specification = specification.forElement(result)
					.valueMatch(FilterValueByStatus.PENDING.toString()).next();
		}

	}

	@Test
	public void filterByRoleTest() {

		// Filter orders by role equals "Administrator"
		orderingPage.setFilterByRole(FilterValueByRole.ADMINISTRATOR);
		orderingPage = orderingPage.clickApplyButton();

		// Save test data
		/*
		 * Variable resultByRoleAdm contains all values of column role after
		 * filtering by role with value equals "Administrator"
		 */
		List<String> resultByRoleAdm = orderingPage.getAllRoles();

		// Prepare these for checking
		for (String result : resultByRoleAdm) {
			specification = specification.forElement(result)
					.valueMatch(FilterValueByRole.ADMINISTRATOR.toString())
					.next();
		}
	}
	
	@Test
	public void searchForOrdersByStatusTest() {

		// Search for orders with status value "created"
		orderingPage = orderingPage.searchByValue(
				OrderingPageSearchFilters.SearchByValue.ORDER_STATUS,
				SearchValuesRepository.ValidSearchByStatus.CREATED.toString());

		// Save test data
		/*
		 * Variable searchWithValueCreated contains all values of column status
		 * after search for orders by status with value equals "created"
		 */
		List<String> searchWithValueCreated = orderingPage.getAllStatuses();

		// Prepare these for checking
		for (String result : searchWithValueCreated) {
			this.specification = specification
					.forElement(result.toLowerCase())
					.valueStartWith(
							SearchValuesRepository.ValidSearchByStatus.CREATED
									.toString().toLowerCase()).next();
		}

		// Search for orders with status value "pending"
		orderingPage = orderingPage.searchByValue(
				OrderingPageSearchFilters.SearchByValue.ORDER_STATUS,
				SearchValuesRepository.ValidSearchByStatus.PENDING.toString());

		// Save test data
		/*
		 * Variable searchWithValueCreated contains all values of column status
		 * after search for orders by status with value equals "pending"
		 */
		List<String> searchWithValuePending = orderingPage.getAllStatuses();

		// Prepare these for checking
		for (String result : searchWithValuePending) {
			specification = specification
					.forElement(result.toLowerCase())
					.valueStartWith(
							SearchValuesRepository.ValidSearchByStatus.PENDING
									.toString().toLowerCase()).next();
		}

		// Search for orders with status value "pen"
		orderingPage = orderingPage.searchByValue(
				OrderingPageSearchFilters.SearchByValue.ORDER_STATUS,
				SearchValuesRepository.ValidSearchByStatus.PEN.toString());

		// Save test data
		/*
		 * Variable searchWithValueCreated contains all values of column status
		 * after search for orders by status with value equals "pen"
		 */
		List<String> searchWithValuePen = orderingPage.getAllStatuses();

		// Prepare these for checking
		for (String result : searchWithValuePen) {
			specification = specification
					.forElement(result.toLowerCase())
					.valueStartWith(
							SearchValuesRepository.ValidSearchByStatus.PEN
									.toString().toLowerCase()).next();
		}
		//
		// Search for orders with status value "ending"
		orderingPage = orderingPage.searchByValue(
				OrderingPageSearchFilters.SearchByValue.ORDER_STATUS,
				SearchValuesRepository.InvalidSearchByStatus.ENDING.toString());

		// Save test data
		/*
		 * Variable searchWithValueCreated contains all values of column status
		 * after search for orders by status with value equals "pen"
		 */
		List<String> searchWithValueEnding = orderingPage.getAllStatuses();

		// Prepare these for checking
		for (String result : searchWithValueEnding) {
			specification = specification
					.forElement(result.toLowerCase())
					.valueStartWith(
							SearchValuesRepository.InvalidSearchByStatus.ENDING
									.toString().toLowerCase()).next();
		}
	}


	@Test
	public void searchForOrdersWithFilter() {

		// Set filter by status with value "created"
		orderingPage.setFilterByStatus(FilterValueByStatus.CREATED);

		// Search for orders by assignee "Vitalik"
		orderingPage = orderingPage
				.searchByValue(
						OrderingPageSearchFilters.SearchByValue.ASSIGNEE,
						SearchValuesRepository.ValidSearchByAssignee.VITALIK
								.toString());

		// Save test data
		/*
		 * Variable resultBySearch contains all values of column status after
		 * search orders by assignee equals "vitalik"
		 */
		List<String> resultByAssignVital = orderingPage.getAllAssignees();

		// Prepare these for checking
		for (String result : resultByAssignVital) {
			this.specification = specification
					.forElement(result.toLowerCase())
					.valueMatch(
							SearchValuesRepository.ValidSearchByAssignee.VITALIK
									.toString().toLowerCase()).next();
		}

		// Set filter by status with value "NONE"
		orderingPage.setFilterByStatus(FilterValueByStatus.NONE);

		// Search for orders by assignee "Myroslav"
		orderingPage = orderingPage
				.searchByValue(
						OrderingPageSearchFilters.SearchByValue.ASSIGNEE,
						SearchValuesRepository.ValidSearchByAssignee.MYROSLAV
								.toString());

		// Save test data
		/*
		 * Variable resultBySearch contains all values of column status after
		 * search orders by assignee equals "Myroslav"
		 */
		List<String> resultByAssignMyroslav = orderingPage.getAllAssignees();

		// Prepare these for checking
		for (String result : resultByAssignMyroslav) {
			this.specification = specification
					.forElement(result.toLowerCase())
					.valueMatch(
							SearchValuesRepository.ValidSearchByAssignee.MYROSLAV
									.toString().toLowerCase()).next();
		}

	}
}