package com.softserve.edu.controls;

public interface IRadioButton extends IClickable {

	String getText(); // getValue()
	boolean isDisplayed();
	//
	boolean isChecked();
	void submit();
}
