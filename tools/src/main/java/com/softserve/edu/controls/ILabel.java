package com.softserve.edu.controls;

public interface ILabel {

	String getText();
	boolean isDisplayed();
	boolean isInvisible();
	//izadorozhnyi
	void sendText(String text);
}
