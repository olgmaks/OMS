package com.softserve.edu.controls;

import com.softserve.edu.engine.ControlLocation;
import com.softserve.edu.engine.ControlWrapper;

public class CheckBox implements ICheckBox {

	private ControlWrapper control;

	private CheckBox(ControlWrapper control) {
		this.control = control;
	}

	public static ICheckBox getById(String id) {
		return get(ControlLocation.getById(id));
	}

	public static ICheckBox getByName(String name) {
		return get(ControlLocation.getByName(name));
	}

	public static ICheckBox getByXpath(String xpath) {
		return get(ControlLocation.getByXPath(xpath));
	}

	// TODO
	// public static ICheckBox getByCss(...)

	private static ICheckBox get(ControlLocation controlLocation) {
		return new CheckBox(new ControlWrapper(controlLocation));
	}

	public String getText() {
		return control.getText();
	}

	public boolean isDisplayed() {
		return control.isDisplayed();
	}

	public boolean isChecked() {
		return control.isSelected();
	}

	public void submit() {
		control.submit();
	}

	public void click() {
		control.click();
	}
}
