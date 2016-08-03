package com.softserve.edu.uimaps;

import com.softserve.edu.controls.Alert;
import com.softserve.edu.controls.Button;
import com.softserve.edu.controls.IAlert;
import com.softserve.edu.controls.IButton;
import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.ISelect;
import com.softserve.edu.controls.ITable;
import com.softserve.edu.controls.ITextInput;
import com.softserve.edu.controls.Label;
import com.softserve.edu.controls.Link;
import com.softserve.edu.controls.Select;
import com.softserve.edu.controls.Table;
import com.softserve.edu.controls.TextInput;

/**
 * 
 * @author rromaniktc
 * @author obelitc
 * 
 */
public class OrderingPageUIMap {
	public final ILink logout;
	public final ILink createNewOrder;
	public final ILink userInfo;
	public final ILink ordering;
	public final ILabel filterOrdersBy;
	public final ILabel searchForOrdersBy;
	public final ISelect filterBy;
	public final ISelect filterValue;
	public final ISelect search;
	public final ITextInput searchValue;
	public final IButton apply;
	public final ITable ordersTable;
	public final IAlert alert;

	public OrderingPageUIMap() {
		this.logout = Link.getByXpath("//a[@href='/OMS/logout.htm']");
		this.createNewOrder = Link
				.getByXpath("//a[@href='orderItemsCreate.htm']");
		this.userInfo = Link.getByLinkText("User Info");
		this.ordering = Link.getByLinkText("Ordering");
		this.filterOrdersBy = Label
				.getByXpath("//form[@id='searchFilter']//td[1]");
		this.searchForOrdersBy = Label
				.getByXpath("//form[@id='searchFilter']//tr[2]/td[1]");
		this.filterBy = Select.getById("filterBy");
		this.filterValue = Select.getById("filterValue");
		this.search = Select.getById("search");
		this.searchValue = TextInput.getById("searchValue");
		this.apply = Button.getByName("Apply");
		this.ordersTable = Table.getById("list");
		//this.ordersTable = Table.getByXpath("//div[@id='list']");
		this.alert = new Alert();
	}

}
