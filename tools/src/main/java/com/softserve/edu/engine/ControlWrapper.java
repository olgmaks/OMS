package com.softserve.edu.engine;

import org.openqa.selenium.WebElement;

public class ControlWrapper {

	private WebElement webElement;

	// TODO Refactor ControlWrapper(ControlLocation controlLocation)
	// public ControlWrapper(WebElement webElement) {
	// this.webElement = webElement;
	// }

	public ControlWrapper(ControlLocation controlLocation) {
		this.webElement = ContextVisible.get().getWebElement(controlLocation);
	}
	
	/**
	 * 
	 * @param webElement
	 * 
	 * @author rromaniktc
	 * @author obelitc
	 */
	//TODO this methods has to be package-access
	ControlWrapper(WebElement webElement) {
		this.webElement = webElement;
	}
	public ControlWrapper(ControlLocation controlLocation, ControlWrapper controlWrapper) {
		this.webElement = controlWrapper.getWebElement().findElement(controlLocation.getBy());
	}
	final WebElement getWebElement() {
		return webElement;
	}

	public final void click() {
		getWebElement().click();
	}

	public final boolean isSelected() {
		return getWebElement().isSelected();
	}

	public final boolean isDisplayed() {
		return getWebElement().isDisplayed();
	}

	public final boolean isEnabled() {
		return getWebElement().isEnabled();
	}

	public final String getText() {
		return getWebElement().getText();
	}

	public final void sendKeys(String text) {
		getWebElement().sendKeys(text);
	}

	public final void submit() {
		getWebElement().submit();
	}

	public String getUrl() {
		return getWebElement().getAttribute("href");
	}

	public final void clear() {
		getWebElement().clear();
	}
}
