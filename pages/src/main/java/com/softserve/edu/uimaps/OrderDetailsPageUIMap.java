package com.softserve.edu.uimaps;

import com.softserve.edu.controls.Button;
import com.softserve.edu.controls.IButton;
import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.ISelect;
import com.softserve.edu.controls.ITextInput;
import com.softserve.edu.controls.Label;
import com.softserve.edu.controls.Link;
import com.softserve.edu.controls.Select;
import com.softserve.edu.controls.TextInput;
import com.softserve.edu.custom_controls.IPruductTableOrderDetailsPage;
import com.softserve.edu.custom_controls.ProductTableOrderDetailsPage;

/**
 * 
 * @author bkliutc
 * @author izadortc
 * 
 */
public class OrderDetailsPageUIMap {
	public final ILink ordering;
	public final ILink userInfoLink;
	public final ILink logOut;

	public final IButton addItem;
	public final IPruductTableOrderDetailsPage resultTable;
	public final IButton first;
	public final IButton backward;
	public final IButton forward;
	public final IButton last;

	public final ILabel asignee;

	public final ISelect creditcardtype;
	public final ITextInput creditcardnumber;
	public final ITextInput cvv;
	public final ISelect expirymonth;
	public final ISelect expiryyear;
	public final ITextInput startdatemaestro;
	public final ITextInput issuenumbermaestro;

	public final IButton saveButton;
	public final IButton orderButton;
	public final IButton cancelButton;

	public OrderDetailsPageUIMap() {
		this.ordering = Link.getByXpath("//a[@href='/OMS/order.htm']");
		this.userInfoLink = Link.getByLinkText("User Info");
		this.logOut = Link.getByXpath("//a[@href='/OMS/logout.htm']");

		this.addItem = Button.getById("addItem");
		this.resultTable = ProductTableOrderDetailsPage
				.getByXpath("//div[@id='list']/table");
		this.first = Button.getByName("First");
		this.backward = Button.getByName("Backward");
		this.forward = Button.getByName("Forward");
		this.last = Button.getByName("Last");

		this.asignee = Label.getById("assignee");

		this.creditcardtype = Select.getById("cardTypes");
		this.creditcardnumber = TextInput.getById("cardNum");
		this.cvv = TextInput.getById("cvv2");
		this.expirymonth = Select.getById("newCreditCardMonth");
		this.expiryyear = Select.getById("newCreditCardYear");
		this.startdatemaestro = TextInput.getById("startDate2");
		this.issuenumbermaestro = TextInput.getById("issueNumber2");

		this.saveButton = Button.getById("save");
		this.orderButton = Button.getById("orderButton");
		this.cancelButton = Button.getById("cancelButton");

	}

}
