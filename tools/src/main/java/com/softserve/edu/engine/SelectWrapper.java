package com.softserve.edu.engine;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectWrapper {

	private Select selectWebElement;

	// public SelectWrapper(Select selectWebElement) {
	// this.selectWebElement = selectWebElement;
	// }

	public SelectWrapper(ControlLocation controlLocation) {
		this.selectWebElement = ContextVisible.get().getSelectWebElement(
				controlLocation);
	}

	private final Select getSelectWebElement() {
		return selectWebElement;
	}

	public final void selectByText(String text) {
		getSelectWebElement().selectByVisibleText(text);
	}

	public final void selectByValue(String value) {
		getSelectWebElement().selectByValue(value);
	}

	public final void selectByIndex(int index) {
		getSelectWebElement().selectByIndex(index);
	}

	public final String getValue() {
		return getSelectWebElement().getFirstSelectedOption().getText();
	}

	public ArrayList<String> getAllValues() {
		Iterator<WebElement> i = getSelectWebElement().getOptions().iterator();
		ArrayList<String> list = new ArrayList<String>();
		while (i.hasNext()) {
			list.add(i.next().getText());
		}

		return list;
	}
}
