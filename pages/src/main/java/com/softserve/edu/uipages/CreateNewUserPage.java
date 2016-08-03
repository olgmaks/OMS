package com.softserve.edu.uipages;

import com.softserve.edu.controls.ILabel;
import com.softserve.edu.data.User;
import com.softserve.edu.uimaps.CreateNewUserUIMap;

public class CreateNewUserPage {

    private CreateNewUserUIMap controls;

    public CreateNewUserPage() {
        controls = new CreateNewUserUIMap();
    }

    public LoginPage logout() {
        controls.logout.click();
        return new LoginPage();
    }

    private void setLogin(String login) {
        controls.login.sendKeys(login);
    }

    private void setFirstName(String firstName) {
        controls.firstName.sendKeys(firstName);
    }

    private void setLastName(String lastName) {
        controls.lastName.sendKeys(lastName);
    }

    private void setPassword(String password) {
        controls.password.sendKeys(password);
    }

    private void setConfirmPassword(String confirmPassword) {
        controls.confirmPassword.sendKeys(confirmPassword);
    }

    private void setEmail(String email) {
        controls.email.sendKeys(email);
    }

    public AdministrationPage createNewUser(User user) {
        setLogin(user.getLogin());
        setFirstName(user.getName());
        setLastName(user.getName());
        setPassword(user.getPassword());
        setConfirmPassword(user.getPassword());
        setEmail(user.getEmail());
        //
        if (controls.isDisableValidators()) {
            controls.create.click();
        } else {
        	// TODO Logs User Cannot be Created
        	controls.cancel.click();
        	// TODO throw Exception Test Failed
        }
        return new AdministrationPage();
    }
    	
    public ILabel getInfoLine() {
		return 	controls.infoLine;
	}
    
    public AdministrationPage checkLogin(User user){
    	setLogin(user.getLogin());
    	if (controls.isInvalidLogin()) {
    		controls.cancel.click();
        } else {
        	// TODO Logs User Cannot be Created
        	createNewUser(user);
        	// TODO throw Exception Test Failed
        }
    	return new AdministrationPage();
    }
}
