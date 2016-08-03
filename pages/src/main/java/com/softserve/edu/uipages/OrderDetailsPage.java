package com.softserve.edu.uipages;

import java.util.ArrayList;

import com.softserve.edu.data.Card;
import com.softserve.edu.uimaps.OrderDetailsPageUIMap;

/**
 * 
 * @author bkliutc
 * @author izadortc
 * 
 */
public class OrderDetailsPage {
	final String ASIGNEE_LOGIN = "login2";

	private OrderDetailsPageUIMap controls;

	public OrderDetailsPage() {
		controls = new OrderDetailsPageUIMap();
	}

	public OrderingPage goToOrderingPage() {
		controls.ordering.click();
		return new OrderingPage();
	}

	public CustomerHomePage goToUserInfoPage() {
		controls.userInfoLink.click();
		return new CustomerHomePage();
	}

	public LoginPage logOut() {
		controls.logOut.click();
		return new LoginPage();
	}

	// - - - - - - - - - - - - - - //
	public AddItemPage goToAddItemPage() {
		controls.addItem.click();
		return new AddItemPage();
	}

	/**
	 * Returns number of the selected product in row
	 * 
	 * @param index
	 *            number of row
	 * @return String representation of column 'Item Number'
	 */
	public String getItemNumberFromRow(int index) {
		return controls.resultTable.getRow(index).getNumber();
	}

	/**
	 * Returns name of the selected product in row
	 * 
	 * @param index
	 *            number of row
	 * @return String representation of column 'Item Name'
	 */
	public String getItemNameFromRow(int index) {
		return controls.resultTable.getRow(index).getName();
	}

	/**
	 * Returns description of the selected product in row
	 * 
	 * @param index
	 *            number of row
	 * @return String representation of column 'Item Description'
	 */
	public String getItemDescriptionFromRow(int index) {
		return controls.resultTable.getRow(index).getDescription();
	}

	/**
	 * Returns dimension of the selected product in row
	 * 
	 * @param index
	 *            number of row
	 * @return String representation of column 'Dimension'
	 */
	public String getItemDimensionFromRow(int index) {
		return controls.resultTable.getRow(index).getDimension();
	}

	/**
	 * Returns price of the selected product in row
	 * 
	 * @param index
	 *            number of row
	 * @return String representation of column 'Price'
	 */
	public String getItemPriceFromRow(int index) {
		return controls.resultTable.getRow(index).getPrice();
	}

	/**
	 * Returns quantity of the selected product in row
	 * 
	 * @param index
	 *            number of row
	 * @return String representation of column 'Quantity'
	 */
	public String getItemQuantityFromRow(int index) {
		return controls.resultTable.getRow(index).getQuantity();
	}

	public String getItemPricePerLineFromRow(int index) {
		return controls.resultTable.getRow(index).getPricePerLine();
	}

	/**
	 * Go to edit product page from table by index
	 * 
	 * @param index
	 *            number of row
	 * @return new AddItemPage entity
	 */
	public AddItemPage clickEditFromRow(int index) {
		controls.resultTable.getRow(index).clickEdit();
		return new AddItemPage();
	}

	/**
	 * Delete product from table by index
	 * 
	 * @param index
	 *            number of row
	 * @return new OrderDetailsPage entity
	 */
	public OrderDetailsPage clickDeleteFromRow(int index) {
		controls.resultTable.getRow(index).clickDelete();
		return new OrderDetailsPage();
	}

	/**
	 * Returns the index of the first occurrence of String element in 'Item
	 * Number' column
	 * 
	 * @param number
	 *            String to search for
	 * @return the index of the first occurrence row, or 0 if occurrence is not
	 *         found
	 */
	public int indexOfRowByItemNumber(String number) {
		return controls.resultTable.indexOfRowByItemNumber(number);
	}

	/**
	 * Returns the index of the first occurrence of String element in 'Item
	 * Name' column
	 * 
	 * @param name
	 *            String to search for
	 * @return the index of the first occurrence row, or 0 if occurrence is not
	 *         found
	 */
	public int indexOfRowByItemName(String name) {
		return controls.resultTable.indexOfRowByItemName(name);
	}

	// - - - - - - - - - - - - - - //

	public void clickAsignee() {
		controls.asignee.sendText(ASIGNEE_LOGIN);
	}

	public ArrayList<String> getCreditCardType() {
		return controls.creditcardtype.getAllValues();
	}

	public ArrayList<String> getExpirymonth() {
		return controls.expirymonth.getAllValues();
	}

	public ArrayList<String> getExpiryyear() {
		return controls.expiryyear.getAllValues();
	}

	public OrderDetailsPage clickSave() {
		controls.saveButton.click();
		return new OrderDetailsPage();
	}

	public OrderingPage clickDone() {
		controls.orderButton.click();
		return new OrderingPage();
	}

	public OrderingPage clickCancel() {
		controls.cancelButton.click();
		return new OrderingPage();
	}

	public void setCreditCardType(String creditcardtype) {
		controls.creditcardtype.selectByText(creditcardtype);
	}

	public void setCreditCardNumber(String creditcardnumber) {
		controls.creditcardnumber.sendKeys(creditcardnumber);
	}

	public OrderingPage clickOrder() {
		controls.orderButton.click();
		return new OrderingPage();
	}

	public void setcvv(String cvv) {
		controls.cvv.sendKeys(cvv);
	}

	public CardInfoErrorPage clickOrderError() {
		controls.orderButton.click();
		return new CardInfoErrorPage();
	}

	public OrderDetailsPage getStartDateMaestro() {
		controls.startdatemaestro.click();
		return new OrderDetailsPage();
	}

	public OrderDetailsPage getIssueNumberMaestro() {
		controls.issuenumbermaestro.click();
		return new OrderDetailsPage();
	}

	public void setExpirymonth(String expirymonth) {
		controls.expirymonth.selectByText(expirymonth);
	}

	public void setExpiryYear(String expiryyear) {
		controls.expiryyear.selectByText(expiryyear);
	}

	public OrderDetailsPage createNewCardInfo(Card card) {
		setCreditCardType(card.getCreditcardType());
		setCreditCardNumber(card.getCreditcardnumber());
		setcvv(card.getCvv());
		setExpirymonth(card.getexpirymonth());
		setExpiryYear(card.getexpiryyear());

		return new OrderDetailsPage();
	}

}
