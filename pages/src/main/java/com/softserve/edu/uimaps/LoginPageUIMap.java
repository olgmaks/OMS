package com.softserve.edu.uimaps;

import com.softserve.edu.controls.Button;
import com.softserve.edu.controls.CheckBox;
import com.softserve.edu.controls.IButton;
import com.softserve.edu.controls.ICheckBox;
import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ITextInput;
import com.softserve.edu.controls.Label;
import com.softserve.edu.controls.TextInput;

public class LoginPageUIMap {
	public final ITextInput login;
	public final ITextInput password;
	public final ICheckBox rememberMeCheckBox;
	public final IButton submitQuery;
	public final IButton reset;


	public LoginPageUIMap() {
		this.login = TextInput.getByName("j_username");
		this.password = TextInput.getByName("j_password");
		this.rememberMeCheckBox = CheckBox
				.getByName("_spring_security_remember_me");
		this.submitQuery = Button.getByName("submit");
		this.reset = Button.getByName("reset"); 

	}
	//
	public ILabel getActualErrorMessage() {
		return Label.getByXpath("//div/fieldset/font");
	}
	


}
