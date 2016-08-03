package com.softserve.edu.uipages;

import java.util.LinkedList;
import java.util.List;

import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.ITable;
import com.softserve.edu.controls.ITableRow;
import com.softserve.edu.data.OrderingPageSearchFilters;
import com.softserve.edu.data.OrderingPageSearchFilters.FilterBy;
import com.softserve.edu.uimaps.OrderingPageUIMap;

/**
 *
 * @author rromaniktc
 * @author obelitc
 *
 */
public class OrderingPage {
	public static final int ORDER_NAME_COLUMN = 0;
	public static final int TOTAL_PRICE_COLUMN = 1;
	public static final int MAX_DISCOUNT_COLUMN = 2;
	public static final int DELIVERY_DATE_COLUMN = 3;
	public static final int STATUS_COLUMN = 4;
	public static final int ASSIGNEE_COLUMN = 5;
	public static final int ROLE_COLUMN = 6;
	public static final int EDIT_COLUMN = 7;
	public static final int DELETE_COLUMN = 8;

	public static final String DELETE_WARNING_MESSAGE = "The order will be deleted from the List of Orders. Are you sure you want to proceed?";

	private OrderingPageUIMap controls;

	public OrderingPage() {
		controls = new OrderingPageUIMap();
	}

	public LoginPage logout() {
		controls.logout.click();
		return new LoginPage();
	}

	public OrderDetailsPage goToOrderDetailsPage() {
		controls.createNewOrder.click();
		return new OrderDetailsPage();
	}

	public CustomerHomePage goToCusomerHomePage() {
		controls.userInfo.click();
		return new CustomerHomePage();
	}

	public OrderingPage clickOrderingTab() {
		controls.ordering.click();
		return new OrderingPage();
	}

	// Added by Ostap Voitsekhovs'kyi
	// for asserting current page
	public ILink getCreateNewOrder() {
		return controls.createNewOrder;
	}

	/**
	 * Return the orders table on the ordering page
	 *
	 * @return
	 */
	public ITable getTable() {
		return controls.ordersTable;
	}

	/**
	 * Returns a List of ITableRows.
	 *
	 * @return
	 */
	public List<ITableRow> getTableRows() {
		return controls.ordersTable.getTableRows();
	}

	/**
	 * Clicks on the cell located on the intersection of i-th row and j-th
	 * column. Takes numbers of row and column as parameters
	 *
	 * @param row
	 * @param column
	 */
	public void clickCell(int row, int column) {

		getTableRows().get(row).getCell(column).click();
	}

	/**
	 * Return a List of String which represents a column of the orders table
	 *
	 * @param column
	 * @return tableColumn
	 */
	public List<String> getColumn(int column) {
		List<String> tableColumn = new LinkedList<String>();
		for (int i = 0; i < getTableRows().size(); i++)
			tableColumn.add(getTableRows().get(i).getCell(column).getText());

		return tableColumn;
	}

	/**
	 * Returns a list of Order Name values for all orders in the orders table
	 *
	 * @return totalPrices
	 */
	public List<String> getAllOrderNames() {
		List<String> orderNames = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			orderNames.add(getTableRows().get(i).getCell(ORDER_NAME_COLUMN)
					.getText());

		return orderNames;
	}

	/**
	 * Returns a list of Total Price values for all orders in the orders table
	 *
	 * @return totalPrices
	 */
	public List<String> getAllTotalPrices() {
		List<String> totalPrices = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			totalPrices.add(getTableRows().get(i).getCell(TOTAL_PRICE_COLUMN)
					.getText());

		return totalPrices;
	}

	/**
	 * Returns a list of Max Discount values for all orders in the orders table
	 *
	 * @return maxDiscounts
	 */
	public List<String> getAllMaxDiscounts() {
		List<String> maxDiscounts = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			maxDiscounts.add(getTableRows().get(i).getCell(MAX_DISCOUNT_COLUMN)
					.getText());

		return maxDiscounts;
	}

	/**
	 * Returns a list of Delivery Date values for all orders in the orders table
	 *
	 * @return deliveryDates
	 */
	public List<String> getAllDeliveryDates() {
		List<String> deliveryDates = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			deliveryDates.add(getTableRows().get(i)
					.getCell(DELIVERY_DATE_COLUMN).getText());

		return deliveryDates;
	}

	/**
	 * Returns a list of Status values for all orders in the orders table
	 *
	 * @return statuses
	 */
	public List<String> getAllStatuses() {
		List<String> statuses = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			statuses.add(getTableRows().get(i).getCell(STATUS_COLUMN).getText());

		return statuses;
	}

	/**
	 * Returns a list of Assignee values for all orders in the orders table
	 *
	 * @return assignees
	 */
	public List<String> getAllAssignees() {
		List<String> assignees = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			assignees.add(getTableRows().get(i).getCell(ASSIGNEE_COLUMN)
					.getText());

		return assignees;
	}

	/**
	 * Returns a list of Assignee values for all orders in the order table.
	 *
	 * @return assignees
	 */
	public List<String> getAllRoles() {
		List<String> roles = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			roles.add(getTableRows().get(i).getCell(ROLE_COLUMN).getText());

		return roles;
	}

	/**
	 * Clicks on column head and returns new OrderingPage object. The first
	 * click on an order-table column head sorts orders by that column values in
	 * descending order, the second click in ascending order, then again in
	 * descending, then again in ascending and so on.
	 *
	 * @param column
	 * @return new OrderingPage();
	 */
	public OrderingPage clickColumnHead(int column) {
		controls.ordersTable.getCell(0, column).click();
		return new OrderingPage();
	}

	/**
	 * Clicks delete button of specified order and dismiss alert.
	 *
	 * @param row
	 *            the number of row to click delete
	 * @return alertMessage
	 */
	public String clickOrderDeleteAndDismiss(int row) {
		getTableRows().get(row).getCell(DELETE_COLUMN).click();
		String alertMessage = controls.alert.getText();
		controls.alert.alertDismiss();

		return alertMessage;
	}

	/**
	 * Sets select "filterBy" by text "Status" and sets select "filterValue" by
	 * given value
	 *
	 * @param value
	 */
	public void setFilterByStatus(
			OrderingPageSearchFilters.FilterValueByStatus value) {
		this.controls.filterBy.selectByText(FilterBy.ORDER_STATUS.toString());
		this.controls.filterValue.selectByText(value.toString());
	}

	/**
	 * Sets select "filterBy" by text "Role" and sets select "filterValue" by
	 * given value
	 *
	 * @param value
	 */
	public void setFilterByRole(
			OrderingPageSearchFilters.FilterValueByRole value) {
		this.controls.filterBy.selectByText(FilterBy.ROLE.toString());
		this.controls.filterValue.selectByText(value.toString());
	}

	/**
	 * Sets select "search" by given value and is looked for orders by given
	 * text
	 *
	 * @param value
	 * @param text
	 * @return
	 */
	public OrderingPage searchByValue(
			OrderingPageSearchFilters.SearchByValue value, String text) {
		this.controls.search.selectByText(value.toString());
		this.controls.searchValue.sendKeys(text);
		this.controls.apply.click();
		return new OrderingPage();
	}

	public OrderingPage clickApplyButton() {
		this.controls.apply.click();
		return new OrderingPage();
	}

}
