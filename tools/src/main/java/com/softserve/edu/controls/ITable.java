package com.softserve.edu.controls;

import java.util.List;

/**
 * 
 * @author rromaniktc
 * @author obelitc
 *
 */
public interface ITable {
	List<ITableRow> getTableRows();
	
	int getRowAmount();
	int getColumnAmount();
	ITableCell getCell(int row, int column);
}