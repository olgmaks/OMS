package com.softserve.edu.uimaps;

import com.softserve.edu.controls.Button;
import com.softserve.edu.controls.IButton;
import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.ITextInput;
import com.softserve.edu.controls.Label;
import com.softserve.edu.controls.Link;
import com.softserve.edu.controls.TextInput;

public class CreateNewUserUIMap {
	public final ILink logout;
	public final ITextInput login;
	public final ITextInput firstName;
	public final ITextInput lastName;
	public final ITextInput password;
	public final ITextInput confirmPassword;
	public final ITextInput email;
	// private final ISelect region;
	// private final IRadioButtonGroup role;
	public final IButton create;
	public final IButton cancel;
	public final ILabel infoLine;		//@ikarptc 

	// private final IButton cancelButton;

	public CreateNewUserUIMap() {
		this.logout = Link.getByXpath("//a[@href='/OMS/logout.htm']");
		this.login = TextInput.getById("login");
		this.firstName = TextInput.getById("firstName");
		this.lastName = TextInput.getById("lastName");
		this.password = TextInput.getById("password");
		this.confirmPassword = TextInput.getById("confirmPassword");
		this.email = TextInput.getById("email");
		this.create = Button.getByXpath("//input[@value='Create']");
		this.cancel = Button.getByXpath("//input[@value='Cancel']");
		this.infoLine = Label.getByXpath("//*[@id='edit']/h3");
	}
	 //@mlevktc
	public boolean isDisableValidators() {
		boolean isValidatorInvisible = true;
		isValidatorInvisible = isValidatorInvisible && Label.isInvisibleById("nameError");
		isValidatorInvisible = isValidatorInvisible && Label.isInvisibleById("firstNameError");
		isValidatorInvisible = isValidatorInvisible && Label.isInvisibleById("lastNameError");
		isValidatorInvisible = isValidatorInvisible && Label.isInvisibleById("passwordError");
		isValidatorInvisible = isValidatorInvisible && Label.isInvisibleById("confirmError");
		isValidatorInvisible = isValidatorInvisible && Label.isInvisibleById("emailError");
		return isValidatorInvisible;
	}
	
        //@mlevktc    
    	public boolean isInvalidLogin(){
    	boolean isLoginInvalid = true;
    	isLoginInvalid = isLoginInvalid && Label.isVisibleById("nameError");
    	return isLoginInvalid;
    }

}
