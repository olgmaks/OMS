package com.softserve.edu.uimaps;

import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.Label;
import com.softserve.edu.controls.Link;

public abstract class HomePageUIMap {

	public final ILink logout;
	public final ILabel firstName;
	public final ILabel role;
	public final ILink languageToUA;
	public final ILink languageToUS;

	public HomePageUIMap() {
		this.logout = Link.getByXpath("//a[@href='/OMS/logout.htm']");
		// this.administration =
		// Link.getByXpath("//a[text()='Administration']");

		
		
		// Changed by Ostap Voitsekhovs'kyi
		// I have to change the xpath expression because after changing language
		// lable 'Role' changes to 'Роль' and 'First name' to 'Ім'я'
		
		// this.role = Label
		// .getByXpath("//td[text()='Role']/following-sibling::td");
		// this.firstName = Label
		// .getByXpath("//td[text()='First name']/following-sibling::td");

		this.role = Label.getByXpath("//table/tbody/tr[4]/td[2]");
		this.firstName = Label.getByXpath("//table/tbody/tr[1]/td[2]");

		// Added by Ostap Voitsekhovs'kyi
		// This links are used for changing language, are displayed on HomePage
		// of every user
		this.languageToUA = Link.getByXpath("//a[@href='?lang=uk_UA']");
		this.languageToUS = Link.getByXpath("//a[@href='?lang=en_US']");
	}
}
