package com.softserve.edu.uipages;

import com.softserve.edu.uimaps.AddProductPageUIMap;

public class AddProductPage {
	private AddProductPageUIMap controls;
	
	public AddProductPage() {
		this.controls = new AddProductPageUIMap();
	}
	
	//TODO MP: create product class
	public ItemManagementPage createNewProduct(String productName, String productDecription, float productPrice) {
		this.controls.name.sendKeys(productName);
		this.controls.description.sendKeys(productDecription);
		this.controls.price.sendKeys(new Float(productPrice).toString());
		
		this.controls.submit.click();
		
		return new ItemManagementPage();
	}
}
