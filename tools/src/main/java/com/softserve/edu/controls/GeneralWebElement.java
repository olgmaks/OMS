package com.softserve.edu.controls;

import com.softserve.edu.engine.ControlLocation;
import com.softserve.edu.engine.ControlWrapper;

public class GeneralWebElement implements IGeneralWebElement {
	private ControlWrapper control;

	public GeneralWebElement(ControlWrapper control) {
		this.control = control;
	}
	@Override
	public ControlWrapper getControl() {
		
		return control;
	}
	public static IGeneralWebElement getById(String id) {
		return get(ControlLocation.getById(id));
	}

	public static IGeneralWebElement getByName(String name) {
		return get(ControlLocation.getByName(name));
	}

	public static IGeneralWebElement getByXpath(String xpath) {
		return get(ControlLocation.getByXPath(xpath));
	}

	public static IGeneralWebElement getByLinkText(String linkText) {
		return get(ControlLocation.getByLinkText(linkText));
	}

	public static IGeneralWebElement getByIdFromWebElement(String id,
			ControlWrapper controlWrapper) {
		return get(ControlLocation.getById(id),controlWrapper);
	}

	public static IGeneralWebElement getByNameFromWebElement(String name,
			ControlWrapper controlWrapper) {
		return get(ControlLocation.getByName(name),controlWrapper);
	}

	public static IGeneralWebElement getByXpathFromWebElement(String xpath,
			ControlWrapper controlWrapper) {
		return get(ControlLocation.getByXPath(xpath),controlWrapper);
	}

	public static IGeneralWebElement getByLinkTextFromWebElement(
			String linkText, ControlWrapper controlWrapper) {
		return get(ControlLocation.getByLinkText(linkText),controlWrapper);
	}

	// bkliutc todo interface
	public static IGeneralWebElement getByObject(ITableCell iTableCell) {
		return new GeneralWebElement(iTableCell.getControl());
	}

	// TODO
	// public static ILink getByCss(...)

	public static IGeneralWebElement get(ControlLocation controlLocation) {
		return new GeneralWebElement(new ControlWrapper(controlLocation));
	}

	public static IGeneralWebElement get(ControlLocation controlLocation,
			ControlWrapper controlWrapper) {
		return new GeneralWebElement(new ControlWrapper(controlLocation,
				controlWrapper));
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
