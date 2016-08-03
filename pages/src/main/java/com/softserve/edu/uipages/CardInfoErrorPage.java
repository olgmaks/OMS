
package com.softserve.edu.uipages;




import com.softserve.edu.uimaps.CardInfoErrorUIMap;



public class CardInfoErrorPage {
	private CardInfoErrorUIMap controls;

	public CardInfoErrorPage() {
		controls = new CardInfoErrorUIMap();
	}
	

	public OrderDetailsPage goToOrderDetailsPage() {
		controls.ErrorOk.click();
		return new OrderDetailsPage();
	}
	
	public String getErrorMessage() {
		return controls.ErrorMessage.getText();
		
	}
	
	
}