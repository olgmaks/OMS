package com.softserve.edu.uipages;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.ITable;
import com.softserve.edu.controls.ITableRow;
import com.softserve.edu.data.SearchFilters;
import com.softserve.edu.data.User;
import com.softserve.edu.uimaps.AdministrationPageUIMap;
import com.softserve.edu.uimaps.AdministrationPageUIMapAjax;

public class AdministrationPage {

	public static final int FIRST_NAME_COLUMN = 0;
	public static final int LAST_NAME_COLUMN = 1;
	public static final int LOGIN_COLUMN = 2;
	public static final int ROLE_COLUMN = 3;
	public static final int REGION_COLUMN = 4;
	public static final int EDIT_COLUMN = 5;
	public static final int DELETE_COLUMN = 6;
	private AdministrationPageUIMap controls;
	private AdministrationPageUIMapAjax controlsAjax;

	public AdministrationPage() {
		controls = new AdministrationPageUIMap();
		controlsAjax = new AdministrationPageUIMapAjax();
	}

	public LoginPage logout() {
		controls.logout.click();
		return new LoginPage();
	}

	public CreateNewUserPage gotoCreateNewUserPage() {
		controls.createNewUser.click();
		return new CreateNewUserPage();
	}

	public void searchBy(SearchFilters.Field field,
			SearchFilters.Condition condition, String text) {
		this.controls.field.selectByText(field.toString());
		this.controls.condition.selectByText(condition.toString());
		this.controls.searchField.sendKeys(text);
		// Create Specify Component controlsAjax
		this.controlsAjax = new AdministrationPageUIMapAjax(field, text);
	}

	public void deleteUser(User user) {
		// searchBy(SearchFilters.Field.LOGIN_NAME,
		// SearchFilters.Condition.EQUALS, user.getLogin());
		searchBy(SearchFilters.Field.LOGIN_NAME,
				SearchFilters.Condition.STARTS_WITH, user.getLogin());
		controlsAjax.delete.click();
		// TODO Change alert method
		// controls.alert.alertAccept();
		// this.controls = new AdministrationPageUIMap();
		controls.alert.alertDismiss();
		this.controlsAjax = new AdministrationPageUIMapAjax();
	}

	public ILabel getFirstName() {
		return controlsAjax.firstName;
	}

	public ILink getDelete() {
		return controlsAjax.delete;
	}

	public String getFieldValue() {
		return controls.field.getValue();
	}

	public String getConditionValue() {
		return controls.condition.getValue();
	}

	public ArrayList<String> getAllFieldValues() {
		return controls.field.getAllValues();
	}

	public ArrayList<String> getAllConditionValues() {
		return controls.condition.getAllValues();
	}

	public ILabel getAppointmentTitle() {
		return controls.appointmentTitle;
	}

	public ITable getTable() {
		return controls.usersTable;
	}

	public List<ITableRow> getTableRows() {
		return controls.usersTable.getTableRows();
	}


	public void clickCell(int row, int column) {

		getTableRows().get(row).getCell(column).click();
	}

	public List<String> getColumn(int column) {
		List<String> tableColumn = new LinkedList<String>();
		for (int i = 0; i < getTableRows().size(); i++)
			tableColumn.add(getTableRows().get(i).getCell(column).getText());

		return tableColumn;
	}

	public List<String> getAllFirstNames() {
		List<String> firstNames = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			firstNames.add(getTableRows().get(i).getCell(FIRST_NAME_COLUMN)
					.getText());

		return firstNames;
	}

	public List<String> getAllLastNames() {
		List<String> lastNames = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			lastNames.add(getTableRows().get(i).getCell(LAST_NAME_COLUMN)
					.getText());

		return lastNames;
	}

	public List<String> getAllLogins() {
		List<String> logins = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			logins.add(getTableRows().get(i).getCell(LOGIN_COLUMN).getText());

		return logins;
	}

	public List<String> getAllRoles() {
		List<String> roles = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			roles.add(getTableRows().get(i).getCell(ROLE_COLUMN).getText());

		return roles;
	}

	public List<String> getAllRegion() {
		List<String> regions = new LinkedList<String>();
		for (int i = 1; i < getTableRows().size(); i++)
			regions.add(getTableRows().get(i).getCell(REGION_COLUMN).getText());

		return regions;
	}

	public AdministrationPage clickColumnHead(int column) {
		controls.usersTable.getCell(0, column).click();
		return new AdministrationPage();
	}

	public AdministrationPage clickUserDelete(int row) {
		controls.usersTable.getCell(row + 1, 6).click();
		controls.alert.alertAccept();
		return new AdministrationPage();
	}

	public AdministrationPage clickUserEdit(int row) {
		controls.usersTable.getCell(row + 1, 5).click();
		controls.alert.alertAccept();
		return new AdministrationPage();
	}

	public AdministrationPage firstButtonClick() {
		controls.firstButton.click();
		return new AdministrationPage();
	}

	public AdministrationPage backwardButtonClick() {
		controls.backwardButton.click();
		return new AdministrationPage();
	}

	public AdministrationPage forwardButtonClick() {
		controls.forwardButton.click();
		return new AdministrationPage();
	}

	public AdministrationPage lastButtonClick() {
		controls.lastButton.click();
		return new AdministrationPage();
	}

	public String getNumberOfFoundUsers() {
		return controls.numberOfFoundUsers.getText();
	}

}
