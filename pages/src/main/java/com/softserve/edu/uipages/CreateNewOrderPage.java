package com.softserve.edu.uipages;

import com.softserve.edu.uimaps.CreateNewOrderPageUIMap;
/**
 * @author bkliutc
 */
public class CreateNewOrderPage {

	private CreateNewOrderPageUIMap controls;

	public CreateNewOrderPage() {

		controls = new CreateNewOrderPageUIMap();
	}

	protected CreateNewOrderPageUIMap getControls() {
		return controls;
	}

	public AddItemPage goToAddItemPage() {
		controls.addItem.click();
		return new AddItemPage();
	}

	public LoginPage logOut() {
		controls.logOut.click();
		return new LoginPage();
	}

//	public String getItemNumber() {
//		return controls.tableRow.getItemNumber();
//	}
//
//	public String getItemName() {
//		return controls.tableRow.getItemName();
//
//	}
//
//	public String getQuantity() {
//		return controls.tableRow.getQuantity();
//
//	}
//
//	public AddItemPage editClick() {
//		controls.tableRow.editClick();
//		return new AddItemPage();
//	}
//	public CreateNewOrderPage deleteClick() {
//		controls.tableRow.deleteClick();
//		return new CreateNewOrderPage(true);
//	}

}