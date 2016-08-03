package com.softserve.edu.uimaps;


import com.softserve.edu.controls.Button;
import com.softserve.edu.controls.IButton;
import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.Label;



public class CardInfoErrorUIMap {
	
	public final IButton ErrorOk;
	public final ILabel ErrorMessage;
		
	public CardInfoErrorUIMap() {
		this.ErrorOk = Button.getById("closeBtn");
		this.ErrorMessage = Label.getByXpath("//div[@id='alertBox']//p");
	}
	
	
	
	
	
	
}
