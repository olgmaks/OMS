package com.softserve.edu.controls;

import com.softserve.edu.engine.ControlWrapper;

public interface IGeneralWebElement {
	String getText();
	boolean isDisplayed();
	//
	String getUrl();
	void submit();
	ControlWrapper getControl();
}
