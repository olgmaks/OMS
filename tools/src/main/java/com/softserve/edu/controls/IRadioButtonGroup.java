package com.softserve.edu.controls;

import java.util.List;

public interface IRadioButtonGroup {

	String getText(); // getValue() checked
	boolean isDisplayed();
	//
	boolean isChecked();
	//
	void selectByText(String text);
	void selectByValue(String value);
	void selectByIndex(int index);
	//
	List<IRadioButton> getRadioButtonGroup();
}
