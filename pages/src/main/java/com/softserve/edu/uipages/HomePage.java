package com.softserve.edu.uipages;

import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.uimaps.HomePageUIMap;

public abstract class HomePage {

	protected abstract HomePageUIMap getControls();

	public LoginPage logout() {
		getControls().logout.click();
		return new LoginPage();
	}

	public ILabel getName() {
		return getControls().firstName;
	}

	public ILabel getRole() {
		return getControls().role;
	}
	public ILink getLinkLanguageUS(){
		return getControls().languageToUS;
	}
	public ILink getLinkLanguageUA(){
		return getControls().languageToUA;
	}
}
