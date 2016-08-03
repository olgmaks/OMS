package com.softserve.edu.controls;

import java.util.ArrayList;

import com.softserve.edu.engine.ControlLocation;
import com.softserve.edu.engine.SelectWrapper;

public class Select implements ISelect {

	private SelectWrapper control;

	private Select(SelectWrapper control) {
		this.control = control;
	}

	public static ISelect getById(String id) {
		return get(ControlLocation.getById(id));
	}

	public static ISelect getByName(String name) {
		return get(ControlLocation.getByName(name));
	}

	public static ISelect getByXpath(String xpath) {
		return get(ControlLocation.getByXPath(xpath));
	}

	// TODO
	// public static ISelect getByCss(...)

	private static ISelect get(ControlLocation controlLocation) {
		return new Select(new SelectWrapper(controlLocation));
	}

	public void selectByText(String text) {
		control.selectByText(text);
	}

	public void selectByValue(String value) {
		control.selectByValue(value);
	}

	public void selectByIndex(int index) {
		control.selectByIndex(index);
	}

	public String getValue() {
		return control.getValue();
	}

	public ArrayList<String> getAllValues() {
		return control.getAllValues();
	}
}
