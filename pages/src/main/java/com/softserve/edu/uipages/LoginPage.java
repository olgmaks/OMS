package com.softserve.edu.uipages;

import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ITextInput;
import com.softserve.edu.data.User;
import com.softserve.edu.uimaps.LoginPageUIMap;

public class LoginPage {
		
	private LoginPageUIMap controls;
	
	public final String EXPECTED_ERROR_MESSAGE_WITHOUT_LOGIN = "Please enter user name";
	public final String EXPECTED_ERROR_MESSAGE_WITHOUT_PASSWORD = "Please enter password";
	public final String EXPECTED_ERROR_MESSAGE_INCORECT_LOGIN = "Such user does not exist in the system - please try again";
	public final String EXPECTED_ERROR_MESSAGE_INCORECT_PASSWORD = "Password is incorrect - please try again";
	
	public LoginPage() {
		controls = new LoginPageUIMap();
	}

	public ILabel getActualErrorMessage() {
		return controls.getActualErrorMessage();
	}

	public ITextInput getLogin() {
		return controls.login;
	}

	public ITextInput getPassword() {
		return controls.password;
	}

	private void setLoginData(User user) {
		controls.login.sendKeys(user.getLogin());
		controls.password.sendKeys(user.getPassword());
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		controls.password.submit();
	}

	private void setAndRememberLoginData(User user) {
		controls.login.sendKeys(user.getLogin());
		controls.password.sendKeys(user.getPassword());
		controls.rememberMeCheckBox.click();
		controls.submitQuery.click();
	}

	private void resetLoginData(User user) {
		controls.login.sendKeys(user.getLogin());
		controls.password.sendKeys(user.getPassword());
		controls.rememberMeCheckBox.click();
		controls.reset.click();
	}

	public LoginPage unSuccesfulLogin(User invalidUser) {
		setLoginData(invalidUser);
		// controls = new LoginPageUIMap();
		// return this;
		return new LoginPage();
	}

	public LoginPage successResetLogin(User user) {
		resetLoginData(user);
		// return new LoginPage();
		return this;
	}

	public AdminHomePage successAdminLogin(User adminUser) {
		setLoginData(adminUser);
		return new AdminHomePage();
	}

	public AdminHomePage successAndRememberedAdminLogin(User adminUser) {
		setAndRememberLoginData(adminUser);
		return new AdminHomePage();
	}

	//
	public CustomerHomePage successCustomerLogin(User customerUser) {
		setLoginData(customerUser);
		return new CustomerHomePage();
	}

	//
	// public CustomerHomePage successAndRememberedCustomerLogin(User user){
	// setAndRememberLoginData(user);
	// return new CustomerHomePage();
	// }
	//
	public MerchandiserHomePage successMerchandiserLogin(User user) {
		setLoginData(user);
		return new MerchandiserHomePage();
	}

	public MerchandiserHomePage successAndRememberedMerchandiserLogin(User user) {
		setAndRememberLoginData(user);
		return new MerchandiserHomePage();
	}

	public SupervisorHomePage successSupervisorLogin(User user) {
		setLoginData(user);
		return new SupervisorHomePage();
	}

	public SupervisorHomePage successAndRememberedSupervisorLogin(User user) {
		setAndRememberLoginData(user);
		return new SupervisorHomePage();
	}

	// public MerchandiserHomePage successMerchandiserLogin(User user){
	// setLoginData(user);
	// return new MerchandiserHomePage();
	// }
	//
	// public MerchandiserHomePage successAndRememberedMerchandiserLogin(User
	// user){
	// setAndRememberLoginData(user);
	// return new MerchandiserHomePage();
	// }
}
