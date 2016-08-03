package com.softserve.edu.controls;

public interface ILink extends IClickable {

	String getText();
	boolean isDisplayed();
	//
	String getUrl();
	void submit();
}
