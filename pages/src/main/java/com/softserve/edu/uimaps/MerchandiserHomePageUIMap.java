package com.softserve.edu.uimaps;

import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.Link;


//Added by Ostap Voitsekhovs'kyi
public class MerchandiserHomePageUIMap extends HomePageUIMap {
	public final ILink ordering;

	public MerchandiserHomePageUIMap() {
		super();
		this.ordering = Link.getByXpath("//a[@href='/OMS/order.htm']");
	}

}
