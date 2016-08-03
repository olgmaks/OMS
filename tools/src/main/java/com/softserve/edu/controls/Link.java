package com.softserve.edu.controls;

import com.softserve.edu.engine.ControlLocation;
import com.softserve.edu.engine.ControlWrapper;

public class Link implements ILink {

	private ControlWrapper control;

	private Link(ControlWrapper control) {
		this.control = control;
	}

	public static ILink getById(String id) {
		return get(ControlLocation.getById(id));
	}

	public static ILink getByName(String name) {
		return get(ControlLocation.getByName(name));
	}

	public static ILink getByXpath(String xpath) {
		return get(ControlLocation.getByXPath(xpath));
	}

	public static ILink getByLinkText(String linkText) {
		return get(ControlLocation.getByLinkText(linkText));
	}

	// bkliutc todo interface
	public static ILink getByObject(ITableCell iTableCell) {
		return new Link(iTableCell.getControl());
	}

	// TODO
	// public static ILink getByCss(...)

	public static ILink get(ControlLocation controlLocation) {
		return new Link(new ControlWrapper(controlLocation));
	}

	public String getText() {
		return control.getText();
	}

	public boolean isDisplayed() {
		return control.isDisplayed();
	}

	public String getUrl() {
		return control.getUrl();
	}

	public void click() {
		control.click();
	}

	public void submit() {
		control.submit();
	}
}
