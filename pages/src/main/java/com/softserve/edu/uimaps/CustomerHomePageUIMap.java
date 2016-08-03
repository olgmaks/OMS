package com.softserve.edu.uimaps;

import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.Link;

public class CustomerHomePageUIMap extends HomePageUIMap {

	public final ILink ordering;

	public CustomerHomePageUIMap() {
		super();
		this.ordering = Link.getByXpath("//a[@href='/OMS/order.htm']");
	}
}
