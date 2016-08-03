package com.softserve.edu.engine;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextVisible {
	private final String ERROR_NOT_FOUND = "WebElement is not found ";
	private final String ERROR_STILL_VISIBLE = "WebElement is Still Visible ";

	private ContextVisible() {
	}

	public static ContextVisible get() {
		return new ContextVisible();
	}

	protected WebElement getWebElement(ControlLocation controlLocation) {
		WebElement webElement = new WebDriverWait(
				WebDriverUtils.getWebDriver(),
				WebDriverUtils.getImplicitlyWaitTimeout())
				.until(ExpectedConditions
						.visibilityOfElementLocated(controlLocation.getBy()));
		if (webElement == null) {
			// TODO Develop My Exception and Logs
			throw new RuntimeException(ERROR_NOT_FOUND
					+ controlLocation.getValue());
		}
		return webElement;
	}

	/**
	 * Looks for HTML web elements on a page on the basis of the given
	 * ControlLocation and returns List of WebElements found.
	 * 
	 * @return webElements The list of WebElements
	 * 
	 * @author obelitc
	 * @author rromaniktc
	 */
	List<WebElement> getWebElements(ControlLocation controlLocation) {
		List<WebElement> webElements = new WebDriverWait(
				WebDriverUtils.getWebDriver(),
				WebDriverUtils.getImplicitlyWaitTimeout())
				.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(controlLocation
								.getBy()));
		if (webElements == null) {
			// TODO Develop My Exception and Logs
			throw new RuntimeException(ERROR_NOT_FOUND
					+ controlLocation.getValue());
		}
		return webElements;
	}

	/**
	 * Looks for HTML web elements which are located in given web element. These
	 * elements are looked for by tag name and are returned as List of
	 * WebElements found.
	 * 
	 * @return webElements The list of WebElements
	 * 
	 * @author obelitc
	 * 
	 */
	List<WebElement> getWebElements(ControlWrapper control, String tag) {
		List<WebElement> webElements = new WebDriverWait(
				WebDriverUtils.getWebDriver(),
				WebDriverUtils.getImplicitlyWaitTimeout())
				.until(ExpectedConditions.visibilityOfAllElements(control
						.getWebElement().findElements(By.tagName(tag))));
		return webElements;
	}

	protected Select getSelectWebElement(ControlLocation controlLocation) {
		return new Select(getWebElement(controlLocation));
	}

	public boolean isTextPresent(String text) {
		Boolean invisibilityWebElement = WebDriverUtils.getWebDriver()
				.getPageSource().contains(text);
		return invisibilityWebElement;

	}

	public boolean isInvisibleWebElement(ControlLocation controlLocation) {
		Boolean invisibilityWebElement = new WebDriverWait(
				WebDriverUtils.getWebDriver(),
				WebDriverUtils.getImplicitlyWaitTimeout())
				.until(ExpectedConditions
						.invisibilityOfElementLocated(controlLocation.getBy()));
		if (!invisibilityWebElement) {
			// TODO Develop My Exception and Logs
			throw new RuntimeException(ERROR_STILL_VISIBLE
					+ controlLocation.getValue());
		}
		return invisibilityWebElement;
	}

	public boolean isVisibleWebElement(ControlLocation controlLocation) {
		Boolean visibilityWebElement = new WebDriverWait(
				WebDriverUtils.getWebDriver(),
				WebDriverUtils.getImplicitlyWaitTimeout()).until(
				ExpectedConditions.visibilityOfElementLocated(controlLocation
						.getBy())).isDisplayed();
		if (!visibilityWebElement) {
			// TODO Develop My Exception and Logs
			throw new RuntimeException(ERROR_STILL_VISIBLE
					+ controlLocation.getValue());
		}
		return visibilityWebElement;
	}
	//
	// TODO Develop isVisibleTitle(String)
}
