package com.softserve.edu.controls;

import com.softserve.edu.engine.ContextVisible;
import com.softserve.edu.engine.ControlLocation;
import com.softserve.edu.engine.ControlWrapper;

public class Label implements ILabel {

	private ControlWrapper control;
	private ControlLocation controlLocation;

	Label(ControlWrapper control, ControlLocation controlLocation) {
		this.control = control;
		this.controlLocation = controlLocation;
	}

	public static ILabel getById(String id) {
		return get(ControlLocation.getById(id));
	}

	public static ILabel getByName(String name) {
		return get(ControlLocation.getByName(name));
	}

	public static ILabel getByXpath(String xpath) {
		return get(ControlLocation.getByXPath(xpath));
	}

	// bklitc todi interface
	public static ILabel getByObject(ITableCell iTableCell) {
		return new Label(iTableCell.getControl(), null);
	}

	// TODO
	// public static ILabel getByCss(...)
	public static boolean isInvisibleById(String id) {
		return check(ControlLocation.getById(id));
	}

	public static boolean isVisibleById(String id) {
		return checkVisibility(ControlLocation.getById(id));
	}
	private static ILabel get(ControlLocation controlLocation) {
		return new Label(new ControlWrapper(controlLocation), controlLocation);
	}

	private static boolean check(ControlLocation controlLocation) {
		return ContextVisible.get().isInvisibleWebElement(controlLocation);
	}

	private static boolean checkVisibility(ControlLocation controlLocation) {
		return ContextVisible.get().isVisibleWebElement(controlLocation);
	}
  //izadorozhnyi
    public void click() {
        control.click();
    }
    
    public void sendText(String text) {
        if (text != null) {
            click();
            control.sendKeys(text);
                   }
    }
    
	ControlWrapper getControl() {
		return control;
	}

	public String getText() {
		return control.getText();
	}

	public boolean isDisplayed() {
		return control.isDisplayed();
	}

	public boolean isInvisible() {
		return check(this.controlLocation);
	}
}
