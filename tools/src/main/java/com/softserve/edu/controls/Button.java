package com.softserve.edu.controls;

import com.softserve.edu.engine.ControlLocation;
import com.softserve.edu.engine.ControlWrapper;

public class Button implements IButton {

	private ControlWrapper control;

	private Button(ControlWrapper control) {
		this.control = control;
	}

	public static IButton getById(String id) {
		return get(ControlLocation.getById(id));
	}

	public static IButton getByName(String name) {
		return get(ControlLocation.getByName(name));
	}

	public static IButton getByXpath(String xpath) {
		return get(ControlLocation.getByXPath(xpath));
	}

	// TODO
	// public static IButton getByCss(...)

	private static IButton get(ControlLocation controlLocation) {
		return new Button(new ControlWrapper(controlLocation));
	}

	public String getText() {
		return control.getText();
	}

	public boolean isDisplayed() {
		return control.isDisplayed();
	}

	public boolean isEnabled() {
		return control.isEnabled();
	}

	public void submit() {
		control.submit();
	}

	public void click() {
		control.click();
	}
}
