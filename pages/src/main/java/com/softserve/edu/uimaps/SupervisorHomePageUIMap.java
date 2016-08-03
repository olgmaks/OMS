package com.softserve.edu.uimaps;

import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.Link;

/**
 * 
 * @author nkramtc, istebktc
 * 
 */

public class SupervisorHomePageUIMap extends HomePageUIMap {

	public final ILink itemManagement;

	public SupervisorHomePageUIMap() {
		super();
		this.itemManagement = Link
				.getByXpath("//a[@href='/OMS/itemManagement.htm']");
	}
}
