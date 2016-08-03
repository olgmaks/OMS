package com.softserve.edu.controls;

import com.softserve.edu.engine.ControlLocation;
import com.softserve.edu.engine.ControlWrapper;

public class TextInput implements ITextInput {

	private ControlWrapper control;

	private TextInput(ControlWrapper control) {
		this.control = control;
	}

	public static ITextInput getById(String id) {
		return get(ControlLocation.getById(id));
	}

	public static ITextInput getByName(String name) {
		return get(ControlLocation.getByName(name));
	}

	public static ITextInput getByXpath(String xpath) {
		return get(ControlLocation.getByXPath(xpath));
	}

    // TODO
    // public static ITextInput getByCss(...)

	private static ITextInput get(ControlLocation controlLocation) {
		return new TextInput(new ControlWrapper(controlLocation));
	}

    public String getText() {
        return control.getText();
    }

    public boolean isDisplayed(){
		return control.isDisplayed();
	}

    public void clear() {
        control.clear();
    }

    public void sendKeys(String text) {
        if (text != null) {
            click();
            clear();
            control.sendKeys(text);
        }
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
