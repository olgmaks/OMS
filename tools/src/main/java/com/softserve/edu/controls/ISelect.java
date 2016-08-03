package com.softserve.edu.controls;

import java.util.ArrayList;

public interface ISelect {

	void selectByText(String text);
	void selectByValue(String value);
	void selectByIndex(int index);
	String getValue();
	ArrayList<String> getAllValues();
}
