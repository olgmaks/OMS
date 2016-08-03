package com.softserve.edu.controls;

import java.util.LinkedList;
import java.util.List;

import com.softserve.edu.engine.ControlListWrapper;
import com.softserve.edu.engine.ControlLocation;
import com.softserve.edu.engine.ControlWrapper;

/**
 * The <code>Table</code> class represents the table of rectangular form with
 * simple (not compound) cells
 * 
 * @author rromaniktc
 * @author obelitc
 * 
 */
public class Table implements ITable {

	private ControlWrapper control;
	private static String idT;
	private String id;

	/**
	 * tableRows keeps all rows of this table instance.
	 */
	private List<ITableRow> tableRows;

	/**
	 * Initializes new table instance besed on the given control.
	 * 
	 * @param control
	 */
	private Table(ControlWrapper control) {
		this.control = control;
		this.id = idT;
		initTable();
	}

	/**
	 * Creates an instance of the class Table based on ControlListWrapper.
	 * 
	 * @param controlList
	 */
	private Table(ControlListWrapper controlList) {
		List<ControlWrapper> controls = controlList.getControls();
		this.tableRows = new LinkedList<ITableRow>();
		// Creates head row
		this.tableRows.add(new TableRow(controls.get(0), "th"));
		controls.remove(0);
		// Creates other rows
		for (ControlWrapper c : controls) {
			this.tableRows.add(new TableRow(c, "td"));
		}
	}

	/**
	 * Returns an instance of the table based on the given id.
	 * 
	 * @param id
	 * @return
	 */
	public static ITable getById(String id) {
		idT = id;
		return get(ControlLocation.getById(id));
	}

	/**
	 * Returns an instance of the table based on the given xpath.
	 * 
	 * @param xpath
	 * @return
	 */
	public static ITable getByXpath(String xpath) {
		xpath += "//tr";
		return get2(ControlLocation.getByXPath(xpath));
	}

	
	private static ITable get(ControlLocation controlLocation) {
		return new Table(new ControlWrapper(controlLocation));
	}

	/**
	 * Returns Table instance based on ControlLocation.
	 * 
	 * @param controlLocation
	 * @return
	 */
	private static ITable get2(ControlLocation controlLocation) {
		return new Table(new ControlListWrapper(controlLocation));
	}

	ControlWrapper getControl() {
		return control;
	}

	/**
	 * Returns list of table rows.
	 */
	public List<ITableRow> getTableRows() {
		return tableRows;
	}

	public int getRowAmount() {
		return tableRows.size();
	}

	public int getColumnAmount() {
		return tableRows.get(0).size();
	}

	public ITableCell getCell(int row, int column) {
		return tableRows.get(row).getCell(column);
	}

	/**
	 * Initializes all the rows and their cells for the given table.
	 */
	private void initTable() {
		tableRows = new LinkedList<ITableRow>(); // List of table rows

		// xpath to all rows in the table relative to that table's id
		String rowXpath = "//div[@id='" + this.id + "']//tr";

		// for each row wrapped by ControlWrapper
		// (i) feed that row with list of cells
		// (ii) add that row to list of rows
		for (ControlWrapper cw : new ControlListWrapper(
				ControlLocation.getByXPath(rowXpath)).getControls()) {

			TableRow tr = new TableRow(cw);

			List<ITableCell> tcl = new LinkedList<ITableCell>();

			if (tableRows.size() == 0)
				// first line is the head of the table represented by tag "th"
				for (ControlWrapper cwc : new ControlListWrapper(
						ControlLocation.getByXPath(rowXpath + "["
								+ (1 + tableRows.size()) + "]/th"))
						.getControls()) {
					tcl.add(new TableCell(cwc));
				}
			else
				// next goes usual table rows represented by tag "td"
				for (ControlWrapper cwc : new ControlListWrapper(
						ControlLocation.getByXPath(rowXpath + "["
								+ (1 + tableRows.size()) + "]/td"))
						.getControls()) {
					tcl.add(new TableCell(cwc));
				}

			tr.setCells(tcl); // set cells for the given TableRow tr
			tableRows.add(tr); // add that row to the list
		}
	}
}