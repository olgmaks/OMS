package com.softserve.edu.uimaps;

import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.Link;

public class AdminHomePageUIMap extends HomePageUIMap {

	public final ILink administration;

	public AdminHomePageUIMap() {
		super();
		this.administration = Link.getByXpath("//a[@href='/OMS/users.htm']");
	}
}