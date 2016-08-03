package com.softserve.edu.controls;

import com.softserve.edu.engine.ControlWrapper;

/**
 * 
 * @author rromaniktc
 * @author obelitc
 * 
 */
public interface ITableCell {
	String getText();

	void click();

	ControlWrapper getControl();

}
