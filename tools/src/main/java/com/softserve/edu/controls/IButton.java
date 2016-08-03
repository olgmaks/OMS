package com.softserve.edu.controls;

public interface IButton extends IClickable {

	String getText();
	boolean isDisplayed();
	//
	boolean isEnabled();
	void submit();
}
