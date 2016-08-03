package com.softserve.edu.custom_controls;

/**
 * 
 * @author bkliutc
 *
 */
public interface IProductRowOrderDetailsPage {

	String getNumber();

	String getName();

	String getDescription();

	String getDimension();

	String getPrice();

	String getQuantity();

	String getPricePerLine();

	void clickEdit();

	void clickDelete();
}
