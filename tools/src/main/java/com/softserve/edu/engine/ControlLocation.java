package com.softserve.edu.engine;

import org.openqa.selenium.By;

public class ControlLocation {
	private final By by;
	private final String value;

	private ControlLocation(By by, String value) {
		this.by = by;
		this.value = value;
	}

	public static ControlLocation getById(String id) {
		return new ControlLocation(new By.ById(id), id);
	}

	public static ControlLocation getByName(String name) {
		return new ControlLocation(new By.ByName(name), name);
	}

	public static ControlLocation getByXPath(String xpath) {
		return new ControlLocation(new By.ByXPath(xpath), xpath);
	}
	public static ControlLocation getByTagName(String tagName) {
		return new ControlLocation(new By.ByTagName(tagName), tagName);
	}
	
	public static ControlLocation getByLinkText(String linkText) {
		return new ControlLocation(new By.ByLinkText(linkText), linkText);
	}
	

	// TODO
	// public static ControlLocation getByCss(...)

	protected By getBy() {
		return by;
	}

	protected String getValue() {
		return value;
	}

}
