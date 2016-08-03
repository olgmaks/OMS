package com.softserve.edu.controls;

public interface ICheckBox extends IClickable {

	String getText();
	boolean isDisplayed();
	//
	boolean isChecked();
	void submit();
}
