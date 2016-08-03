package com.softserve.edu.controls;

public interface ITextInput extends IClickable {

	String getText();
	boolean isDisplayed();
	//
	void clear();
	void sendKeys(String text);
	boolean isEnabled();
	void submit();
}
