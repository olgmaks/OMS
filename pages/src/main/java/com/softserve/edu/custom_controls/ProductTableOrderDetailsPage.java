package com.softserve.edu.custom_controls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.softserve.edu.controls.ITable;
import com.softserve.edu.controls.ITableRow;
import com.softserve.edu.controls.Table;

/**
 * The <code>ProductTableOrderDetailsPage</code> class represents the table of
 * custom control rows on 'Order details' page
 * 
 * @author bkliutc
 *
 */
public class ProductTableOrderDetailsPage implements
		IPruductTableOrderDetailsPage {
	/**
	 * All table's rows keeps in this list
	 */
	private List<IProductRowOrderDetailsPage> resultList;

	private ProductTableOrderDetailsPage(ITable table) {
		this.resultList = new ArrayList<IProductRowOrderDetailsPage>();
		List<ITableRow> list = table.getTableRows();
		for (ITableRow row : list) {
			this.resultList
					.add(ProductRowOrderDetailsPage.getFromTableRow(row));
		}

	}

	public static IPruductTableOrderDetailsPage getByXpath(String xpath) {
		return new ProductTableOrderDetailsPage(Table.getByXpath(xpath));

	}

	/**
	 * Return row of controls by given index
	 */
	public IProductRowOrderDetailsPage getRow(int index) {
		return resultList.get(index);
	}

	/**
	 * Return List<Strings> which represents all values in 'Item Number' column
	 */
	public List<String> getAllItemNumbers() {
		List<String> list = new ArrayList<String>();
		Iterator<IProductRowOrderDetailsPage> iterator = resultList.iterator();
		if (iterator.hasNext()) {
			iterator.next();
		}
		while (iterator.hasNext()) {
			list.add(iterator.next().getNumber());
		}
		return list;
	}

	/**
	 * Return index of the first occurrence row with given ID in table, or 0 if
	 * occurrence is not found
	 */
	public int indexOfRowByItemNumber(String number) {
		int index = getAllItemNumbers().indexOf(number);
		index++;
		return index;
	}

	/**
	 * Return List<Strings> which represents all values in 'Item Name' column
	 */
	public List<String> getAllItemNames() {
		List<String> list = new ArrayList<String>();
		Iterator<IProductRowOrderDetailsPage> iterator = resultList.iterator();
		if (iterator.hasNext()) {
			iterator.next();
		}
		while (iterator.hasNext()) {
			list.add(iterator.next().getName());
		}

		return list;

	}

	/**
	 * Return index of the first occurrence row with given name in table, or 0
	 * if occurrence is not found
	 */
	public int indexOfRowByItemName(String name) {
		int index = getAllItemNames().indexOf(name);
		index++;
		return index;
	}
}
