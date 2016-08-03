package com.softserve.edu.uimaps;

import com.softserve.edu.controls.Button;
import com.softserve.edu.controls.IButton;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.ITextInput;
import com.softserve.edu.controls.Link;
import com.softserve.edu.controls.TextInput;

/**
 * 
@author nkramtc
 * 
 */

public class AddProductPageUIMap {
	 public final ILink logout;
	 public final ITextInput name;
	 public final ITextInput description;
	 public final ITextInput price;
	 public final IButton submit;
	/*...TODO*/
	
	

	public AddProductPageUIMap() {
		 this.logout = Link.getByXpath("//a[@href='/OMS/logout.htm']");
		 /*...TODO*/
		 this.name = TextInput.getById("name");
		 this.description = TextInput.getById("description");
		 this.price = TextInput.getById("price");
		 this.submit = Button.getByXpath("//*[@id='productModel']/input[2]");
		 //TODO NK: probably, add cancel button reference
		 


	}

}