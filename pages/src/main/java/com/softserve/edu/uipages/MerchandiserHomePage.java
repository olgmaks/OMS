package com.softserve.edu.uipages;

import com.softserve.edu.uimaps.HomePageUIMap;
import com.softserve.edu.uimaps.MerchandiserHomePageUIMap;

//Added by Ostap Voitsekhovs'kyi

public class MerchandiserHomePage extends HomePage  {
	private MerchandiserHomePageUIMap controls;

	public MerchandiserHomePage() {
		controls = new MerchandiserHomePageUIMap();
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
