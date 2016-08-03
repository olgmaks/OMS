package com.softserve.edu.uimaps;

import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.Label;
import com.softserve.edu.controls.Link;
import com.softserve.edu.data.SearchFilters;

public class AdministrationPageUIMapAjax {
	private final String ERROR_CREATE = "\nUnknown Variable field";
	public final ILabel usersFound;
	public final ILabel firstName;
	public final ILabel login;
	public final ILink delete;

	public AdministrationPageUIMapAjax() {
		this.usersFound = Label.getById("usersFound");
		if (Integer.parseInt(usersFound.getText()) > 0) {
			this.firstName = Label.getByXpath("//tbody/tr[1]/td[1]");
			this.login = Label.getByXpath("//tbody/tr[1]/td[3]");
			this.delete = Link.getByXpath("//tbody/tr[1]/td[7]/a");
		} else {
			this.firstName = Label.getByXpath("//thead/tr[1]/th[1]");
			this.login = Label.getByXpath("//thead/tr[1]/th[3]");
			this.delete = Link.getByXpath("//thead/tr[1]/th[1]/a");
		}
	}

	public AdministrationPageUIMapAjax(SearchFilters.Field field, String text) {
		String column = "//tbody/tr[1]/td[%s][text()='%s']";
		this.usersFound = Label.getById("usersFound");
		//
		if (Integer.parseInt(usersFound.getText()) > 0) {
			if (field == SearchFilters.Field.FIRST_NAME) {
				this.firstName = Label.getByXpath(String.format(column, "1", text));
				this.login = Label.getByXpath("//tbody/tr[1]/td[3]");
			} else if (field == SearchFilters.Field.LOGIN_NAME) {
				this.login = Label.getByXpath(String.format(column, "3", text));
				this.firstName = Label.getByXpath("//tbody/tr[1]/td[1]");
			} else {
				// TODO Develop My Exception and Logs
				throw new RuntimeException(ERROR_CREATE);
			}
			this.delete = Link.getByXpath("//tbody/tr[1]/td[7]/a");
		} else {
			this.firstName = Label.getByXpath("//thead/tr[1]/th[1]");
			this.login = Label.getByXpath("//thead/tr[1]/th[3]");
			this.delete = Link.getByXpath("//thead/tr[1]/th[1]/a");
		}
	}
}
