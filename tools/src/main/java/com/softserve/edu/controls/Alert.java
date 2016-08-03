package com.softserve.edu.controls;

import com.softserve.edu.engine.WebDriverUtils;

public class Alert implements IAlert {

	public String getText() {
		return WebDriverUtils.getAlertText();
	}
	public void alertAccept() {
		WebDriverUtils.alertAccept();
	}

	public void alertDismiss() {
		WebDriverUtils.alertDismiss();
	}
}
