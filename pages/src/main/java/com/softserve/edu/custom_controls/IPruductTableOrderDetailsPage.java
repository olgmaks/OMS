package com.softserve.edu.custom_controls;

import java.util.List;

/**
 * 
 * @author bkliutc
 *
 */
public interface IPruductTableOrderDetailsPage {

	IProductRowOrderDetailsPage getRow(int index);

	List<String> getAllItemNumbers();

	int indexOfRowByItemNumber(String number);

	List<String> getAllItemNames();

	int indexOfRowByItemName(String name);

}
