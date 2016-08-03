package com.softserve.edu.uipages;

import com.softserve.edu.controls.GeneralWebElement;
import com.softserve.edu.uimaps.AddItemPageUIMap;

/**
 * 
 * @author bkliutc
 * @author ostapwd
 *
 */
public class AddItemPage {
	private AddItemPageUIMap controls;

	public AddItemPage() {
		controls = new AddItemPageUIMap();
	}

	/**
	 * Sets search property in searching box
	 * 
	 * @param Sstring
	 *            value
	 * 
	 */
	public void setSearchProperty(String value) {
		controls.searchProperty.selectByText(value);
	}

	/**
	 * Sets search value in searching box
	 * 
	 * @param Sstring
	 *            value
	 */
	public void setSearchValue(String value) {
		controls.searchValue.clear();
		controls.searchValue.sendKeys(value);
	}

	/**
	 * Clicks on 'Search' button in searching box
	 * 
	 *
	 * 
	 * @return AddItemPage
	 */
	public AddItemPage clickSearchButton() {
		controls.search.click();
		return new AddItemPage();
	}

	/**
	 * Choose product from table by ID
	 * 
	 * @param productId
	 *            String representation of product ID
	 * @return new 'Add Item' page with selected product
	 */
	public AddItemPage setSelectedPruductById(String productId) {
		controls = new AddItemPageUIMap(productId);
		controls.select.submit();
		return new AddItemPage();
	}

	/**
	 * Set quantity value of product
	 * 
	 * @param quantity
	 *            number of products
	 * @return 'Add Item' page
	 */
	public AddItemPage setQuantity(String quantity) {
		controls.quantity.sendKeys(quantity);
		return this;
	}

	/**
	 * Confirm selected product and values by clicking on 'Done' button
	 * 
	 * @return new 'Order Details' page
	 */
	public OrderDetailsPage clickDoneButton() {
		controls.done.click();
		return new OrderDetailsPage();
	}

	/**
	 * Dismiss all changes on 'Add Item' page and return to previous page
	 * 
	 * @return new 'Order Details' page
	 */
	public OrderDetailsPage clickCancelButton() {
		controls.cancel.click();
		return new OrderDetailsPage();
	}

	/**
	 * Gets cell from table
	 * 
	 * @param int i, int j (i - row number, j - colum number)
	 * 
	 * @return cell of the table
	 */
	public String getCellText(int i, int j) {
		return controls.table.getCell(i, j).getText();
	}

	/**
	 * Gets amount of returned results in the table
	 * 
	 * 
	 * @return int amount of result
	 */
	public int getAmountOfResults() {
		return controls.table.getRowAmount() - 1;
	}

	/**
	 * Click on selected cell
	 * 
	 * @param int i, int j (i - row number, j - colum number)
	 * 
	 * @return AddItemPage
	 */
	public AddItemPage getCellSelectClick(int i, int j) {
		controls.generalWebElement = GeneralWebElement
				.getByXpathFromWebElement("//a [text()='Select']",
						controls.table.getCell(i, j).getControl());
		controls.generalWebElement.submit();
		return new AddItemPage();
	}

	/**
	 * Logout of the system
	 */
	public void logOut() {
		controls.logout.click();
	}

	public void setDimension(String value) {
		this.controls.selectDimension.selectByText(value);
	}

}
