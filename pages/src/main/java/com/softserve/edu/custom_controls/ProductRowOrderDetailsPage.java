package com.softserve.edu.custom_controls;

import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.ITableRow;
import com.softserve.edu.controls.Label;
import com.softserve.edu.controls.Link;

/**
 * The <code>ProductRowOrderDetailsPage</code> class represents the structure of
 * common controls on 'Order details' page
 * 
 * @author bkliutc
 *
 */
public class ProductRowOrderDetailsPage implements IProductRowOrderDetailsPage {
	private ILabel itemNumber;
	private ILabel itemName;
	private ILabel itemDescription;
	private ILabel itemDimension;
	private ILabel itemPrice;
	private ILabel itemQuantity;
	private ILabel itemPricePerLine;
	private ILink itemEdit;
	private ILink itemDelete;

	/**
	 * The <code>ProductRowOrderDetailsPage</code> constructor represents the
	 * structure of parsing common web elements to custom control
	 * 
	 * @author bkliutc
	 *
	 */
	private ProductRowOrderDetailsPage(ITableRow tableRow) {
		this.itemNumber = Label.getByObject(tableRow.getCell(0));
		this.itemName = Label.getByObject(tableRow.getCell(1));
		this.itemDescription = Label.getByObject(tableRow.getCell(2));
		this.itemDimension = Label.getByObject(tableRow.getCell(3));
		this.itemPrice = Label.getByObject(tableRow.getCell(4));
		this.itemQuantity = Label.getByObject(tableRow.getCell(5));
		this.itemPricePerLine = Label.getByObject(tableRow.getCell(6));
		this.itemEdit = Link.getByObject(tableRow.getCell(7));
		this.itemDelete = Link.getByObject(tableRow.getCell(8));
	}

	public static IProductRowOrderDetailsPage getFromTableRow(ITableRow tableRow) {
		return new ProductRowOrderDetailsPage(tableRow);
	}

	public String getNumber() {
		return itemNumber.getText();
	}

	public String getName() {
		return itemName.getText();
	}

	public String getDescription() {
		return itemDescription.getText();
	}

	public String getDimension() {
		return itemDimension.getText();
	}

	public String getPrice() {
		return itemPrice.getText();
	}

	public String getQuantity() {
		return itemQuantity.getText();
	}

	public String getPricePerLine() {
		return itemPricePerLine.getText();
	}

	public void clickEdit() {
		itemEdit.click();
	}

	public void clickDelete() {
		itemDelete.click();
	}

}
