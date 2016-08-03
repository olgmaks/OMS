package com.softserve.edu.uipages;

import com.softserve.edu.uimaps.HomePageUIMap;
import com.softserve.edu.uimaps.SupervisorHomePageUIMap;

/**
 * 
 * @author nkramtc  
 * 
 */

public class SupervisorHomePage extends HomePage {

	private SupervisorHomePageUIMap controls;

	public SupervisorHomePage() {
		controls = new SupervisorHomePageUIMap();
	}

	protected HomePageUIMap getControls() {
		return controls;
	}

	/**
	 * Redirects to the ItemManagementPage
	 * 
	 * @return ItemManagementPage
	 */
	public ItemManagementPage goToItemManagementPage() {
		controls.itemManagement.click();
		return new ItemManagementPage();
	}
}