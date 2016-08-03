package com.softserve.edu.uipages;

import com.softserve.edu.uimaps.AdminHomePageUIMap;
import com.softserve.edu.uimaps.HomePageUIMap;

public class AdminHomePage extends HomePage {

	private AdminHomePageUIMap controls;

	public AdminHomePage() {
		controls = new AdminHomePageUIMap();
	}

	protected HomePageUIMap getControls() {
		return controls;
	}
	
	/**
	 * Redirects to the AdministrationPage
	 * 
	 * @return AdministrationPage
	 */
	public AdministrationPage goToAdministrationPage() {
		controls.administration.click();
		return new AdministrationPage();
	}

	// Added by Ostap Voitsekhovs'kyi
	// Method for changing language on AdminHomePage
	/**
	 * Changes language on page
	 * 
	 * @return AdminHomePage
	 */
	public AdminHomePage changeLanguage() {
		if (controls.languageToUS.getText().equals("en"))
			controls.languageToUA.click();
		else
			controls.languageToUS.click();
		return new AdminHomePage();
	}
}