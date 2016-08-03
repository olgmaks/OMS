package com.softserve.edu.uipages;

import com.softserve.edu.uimaps.CustomerHomePageUIMap;
import com.softserve.edu.uimaps.HomePageUIMap;

public class CustomerHomePage extends HomePage {

	private CustomerHomePageUIMap controls;

	public CustomerHomePage() {
		controls = new CustomerHomePageUIMap();
	}

	protected HomePageUIMap getControls() {
		return controls;
	}
	
	/**
	 * Redirects to the OrderingPage
	 * 
	 * @return OrderingPage
	 */
	public OrderingPage goToOrderingPage() {
		controls.ordering.click();
		return new OrderingPage();
	}
}
