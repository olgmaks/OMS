package com.softserve.edu.engine;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * The <code>ControlListWrapper</code> class represents a wrapper for a list of
 * HTML web elements
 * 
 * @author rromaniktc
 * @author obelitc
 * 
 */
public class ControlListWrapper {
	// private List<WebElement> webElements;
	private List<ControlWrapper> controls;

	/**
	 * Initializes a newly created {@code ControlListWrapper} so that it
	 * represents a List of HTML web elements found on the basis of the given
	 * ControlLocation
	 * 
	 * @param controlLocation
	 */
	public ControlListWrapper(ControlLocation controlLocation) {
		List<WebElement> webElements = ContextVisible.get().getWebElements(
				controlLocation);

		this.controls = wrap(webElements);
	}

	/**
	 * Disassembles given web element on smaller web elements. Disassembling
	 * happens on web elements that match the received tag. 
	 * 
	 * @param control
	 * @param subTag
	 */
	public ControlListWrapper(ControlWrapper control, String subTag) {
		List<WebElement> subElements = ContextVisible.get().getWebElements(
				control, subTag);

		this.controls = wrap(subElements);
	}

	/**
	 * Returns the list of HTML web elements wrappers represented by
	 * <code>ControlWrapper</code>
	 * 
	 * @return controls
	 */
	public List<ControlWrapper> getControls() {
		return controls;
	}

	/**
	 * Wraps each element from the specified list of HTML web elements by
	 * calling a constructor of <code>ControlWrapper</code>
	 * 
	 * @param elements
	 *            The list of HTML web elements found by a testing tool, e.g.
	 *            Selenium
	 * @return controlList The list of wrapped controls
	 */
	private List<ControlWrapper> wrap(List<WebElement> elements) {
		List<ControlWrapper> controlList = new LinkedList<ControlWrapper>();

		for (WebElement e : elements) {
			controlList.add(new ControlWrapper(e));
		}
		return controlList;
	}
}
