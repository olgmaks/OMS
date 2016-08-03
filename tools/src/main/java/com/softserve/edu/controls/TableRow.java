package com.softserve.edu.controls;

import java.util.LinkedList;
import java.util.List;

import com.softserve.edu.engine.ControlListWrapper;
import com.softserve.edu.engine.ControlWrapper;

/**
 * The <code>TableRow</code> class represents the row of cells of the table
 * 
 * @author rromaniktc
 * @author obelitc
 *
 */
public class TableRow implements ITableRow {

	private ControlWrapper control;
	private List<ITableCell> cells;

	TableRow(ControlWrapper control) {
		this.control = control;
	}
	
	/**
	 * The <code>TableRow</code> class represents the row of cells of the table
	 * 
	 * @param control
	 * @param td
	 */
	TableRow(ControlWrapper control, String td) {
		ControlListWrapper cells = new ControlListWrapper(control, td);
		this.cells = new LinkedList<ITableCell>();
		for (ControlWrapper c : cells.getControls()) {
			this.cells.add(new TableCell(c));
		}
	}

	public int size() {
		return this.cells.size();
	}

	ControlWrapper getControl() {
		return control;
	}

	void setCells(List<ITableCell> cells) {
		this.cells = cells;
	}
	
	public ITableCell getCell(int num) {
		return cells.get(num);
	}

}