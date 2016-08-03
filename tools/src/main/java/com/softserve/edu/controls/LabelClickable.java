package com.softserve.edu.controls;

import com.softserve.edu.engine.ControlLocation;
import com.softserve.edu.engine.ControlWrapper;

public class LabelClickable extends Label {

	private LabelClickable(ControlWrapper control,
			ControlLocation controlLocation) {
		super(control, controlLocation);
	}

	public void click() {
		getControl().click();
	}
}
