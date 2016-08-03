package com.softserve.edu.uimaps;

import com.softserve.edu.controls.*;

/**
 * 
 @author nkramtc, istebktc
 * 
 */

public class ItemManagementPageUIMap {
    public final ILink logout;
    public final ILabel appointmentTitle;
    public final ISelect dropdown;
    public final IButton searchButton;
    public final ILabel showItemsSwitch;
    public final ILabel name;
    public final ILabel description;
    public final ILabel price;
    public final ILabel addProduct;
    public final ILabel productsFoundCounter;
    public final ILabel currentPageNumber;
    public final ILabel totalPageNumber;
    public final ILabel createReport;
    public final ILabel userInfoTab;
    public final ILabel firstEditLink;
    public final ILabel firstDeleteLink;
    public final ITextInput searchField;
    public final ILabel firstProductName;
    public final ILink addProductLink;

    public ItemManagementPageUIMap() {
        this.logout = Link.getByXpath("//a[@href='/OMS/logout.htm']");
        this.appointmentTitle = Label.getByXpath(".//*[@id='list']/h2");
        this.dropdown = Select.getById("field");
        this.searchButton = Button.getByName("search");
        this.showItemsSwitch = LabelClickable.getByXpath(".//*[@id='list']/p/a");
        this.name = LabelClickable.getByXpath(".//*[@id='table']/thead/tr/th[1]/a");
        this.description = LabelClickable.getByXpath(".//*[@id='table']/thead/tr/th[2]/a");
        this.price = LabelClickable.getByXpath(".//*[@id='table']/thead/tr/th[3]/a");
        this.addProduct = LabelClickable.getByXpath(".//*[@id='list']/a");
        this.productsFoundCounter = Label.getById("recordsFound");
        this.currentPageNumber = Label.getById("pageNumber");
        this.totalPageNumber = Label.getById("pageCount");
        this.createReport = LabelClickable.getByXpath(".//*[@id='list']/h5/a");
        this.userInfoTab = LabelClickable.getByXpath(".//*[@id='nav']/li[2]/a");
        this.firstEditLink = LabelClickable.getByXpath(".//*[@id='table']/tbody/tr[1]/td[4]/a");
        this.firstDeleteLink = LabelClickable.getByXpath(".//*[@id='table']/tbody/tr[1]/td[5]/a");
        this.searchField = TextInput.getById("searchField");
        this.firstProductName = Label.getByXpath(".//*[@id='table']/tbody/tr/td[1]");
        this.addProductLink = Link.getByXpath(".//*[@id='list']/a");
    }
}