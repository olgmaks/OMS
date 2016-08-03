package com.softserve.edu.uipages;

import com.softserve.edu.controls.ILabel;
import com.softserve.edu.data.SupervisorItemManagementPageFilters;
import com.softserve.edu.uimaps.ItemManagementPageUIMap;

/**
 * 
 * @author nkramtc, istebktc
 * 
 */

public class ItemManagementPage {
	private ItemManagementPageUIMap controls;

	public ItemManagementPage() {
		controls = new ItemManagementPageUIMap();
	}

	public LoginPage logout() {
		controls.logout.click();
		return new LoginPage();
	}
	
	public ILabel getAppointmentTitle(){
		return controls.appointmentTitle;
	}

    public ILabel getFirstProductName() {
        return 	controls.firstProductName;
    }

    public ILabel getProductsFoundCounter () {
        return controls.productsFoundCounter;
    }

	// TODO public OrderDetailsPage goToOrderDetailsPage()
	// public void goToOrderDetailsPage() {
	// controls.createNewOrder.click();
	// return new OrderDetailsPage()

	public AddProductPage goToAddProductPage() {
		controls.addProductLink.click();
		return new AddProductPage();
	}

	/*
	 * public CustomerHomePage goToCustomerHomePage() {
	 * controls.userInfo.click(); return new CustomerHomePage(); }
	 */

    /**
     * Appointed for searching product by product name or description  and clicking 'Search' button
     * @param field - selects option from dropdown list to search by product name or description
     *              (use PRODUCT_NAME or DESCRIPTION values from SupervisorItemManagementPageFilters)
     * @param text - search query text
     */

    public ItemManagementPage searchProductWithSearchButton (SupervisorItemManagementPageFilters.SupervisorField field, String text){
        this.controls.dropdown.selectByText(field.toString());
        this.controls.searchField.sendKeys(text);
        this.controls.searchButton.click();
        return new ItemManagementPage();
    }

}
