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

public class AdministrationPageUIMap {
	public final ILink logout;
	public final ILink createNewUser;
	public final ITextInput searchField;
	public final ISelect field;
	public final ISelect condition;
	public final IAlert alert;
	public final ILabel appointmentTitle;
	public final ITable usersTable;
	public final IButton firstButton;
	public final IButton backwardButton;
	public final IButton forwardButton;
	public final IButton lastButton;
	public final ILabel numberOfFoundUsers;

	public AdministrationPageUIMap() {
		this.logout = Link.getByXpath("//a[@href='/OMS/logout.htm']");
		this.createNewUser = Link.getByXpath("//a[@href='addUser.htm']");
		this.searchField = TextInput.getById("searchField");
		this.field = Select.getById("field");
		this.condition = Select.getById("condition");
		this.alert = new Alert();
		this.appointmentTitle = Label.getByXpath("//div [@id='list'] //h2");
		this.usersTable = Table.getByXpath("//*[@id='table']");
		this.firstButton = Button.getById("first");
		this.backwardButton = Button.getById("previous");
		this.forwardButton = Button.getById("next");
		this.lastButton = Button.getById("last");
		this.numberOfFoundUsers = Label.getById("usersFound");
	}
}
