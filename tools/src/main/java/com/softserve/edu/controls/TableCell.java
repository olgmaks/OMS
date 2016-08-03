package com.softserve.edu.controls;

import com.softserve.edu.engine.ControlLocation;
import com.softserve.edu.engine.ControlWrapper;

/**
 * The <code>TableCell</code> class represents a simple cell of a Table
 * 
 * @author rromaniktc
 * @author obelitc
 * 
 */
public class TableCell implements ITableCell {
	private ControlWrapper control;

	TableCell(ControlWrapper control) {
		this.control = control;
	}

	public static ITableCell get(ControlLocation controlLocation) {
		return new TableCell(new ControlWrapper(controlLocation));
	}

	public ControlWrapper getControl() {
		return control;
	}

	public void click() {
		this.control.click();
	}

	public String getText() {
		return this.control.getText();
	}
}
