package com.softserve.edu.uimaps;

import com.softserve.edu.controls.Button;
import com.softserve.edu.controls.IButton;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.Link;
/**
 * @author bkliutc
 */
public class CreateNewOrderPageUIMap {

	public final IButton addItem;
	public final IButton first;
	public final IButton backward;
	public final IButton forward;
	public final IButton last;
	public final ILink logOut;

	//public final TableRowCreateNewOrderPage tableRow;

	public CreateNewOrderPageUIMap() {
		
		//boolean isTableEmpty;
		
		this.addItem = Button.getById("addItem");
		this.first = Button.getByName("First");
		this.backward = Button.getByName("Backward");
		this.forward = Button.getByName("Forward");
		this.last = Button.getByName("Last");
		this.logOut = Link.getByXpath("//a[@href='/OMS/logout.htm']");

//		if (isTableEmpty) {
//			this.tableRow = new TableRowCreateNewOrderPage();
//		} else
//			this.tableRow = null;
	}
}