package com.softserve.edu.uimaps;

import com.softserve.edu.controls.Button;
import com.softserve.edu.controls.IButton;
import com.softserve.edu.controls.IGeneralWebElement;
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
 * @author bkliutc
 * @author ostapwd
 *
 */
public class AddItemPageUIMap {

	public final ISelect searchProperty;
	public final ITextInput searchValue;
	public final IButton search;
	public final ITable table;

	public final ILabel labelItem;
	public final ILabel labelPrice;
	public final ITextInput quantity;
	public final ISelect selectDimension;
	public final IButton done;
	public final IButton cancel;

	public IGeneralWebElement generalWebElement = null;
	public ILink select = null;

	public final ILink logout;

	public AddItemPageUIMap() {

		this.searchProperty = Select.getById("searchProperty");
		this.searchValue = TextInput.getById("searchValue");
		this.search = Button
				.getByXpath("//input[@type='submit' and @value='Search']");
		this.table = Table.getByXpath("//div[@id='list']//table");

		this.labelItem = Label
				.getByXpath("//form[@id='doneForm']//table//tr[1]//td[2]");
		this.labelPrice = Label
				.getByXpath("//form[@id='doneForm']//table//tr[2]//td[2]");
		this.quantity = TextInput
				.getByXpath("//input[@id='quantity' and @type='text']");
		this.selectDimension = Select
				.getByXpath("//form[@id='doneForm']//table//tr[4]//td[2]//select");
		this.done = Button.getByXpath("//input[@value='Done']");
		this.cancel = Button.getByXpath("//input[@value='Cancel']");

		this.logout = Link.getByXpath("//a[@href='/OMS/logout.htm']");
	}

	public AddItemPageUIMap(String id) {
		this();
		this.select = Link.getById(id);
	}

}