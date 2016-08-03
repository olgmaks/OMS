package com.softserve.edu.controls;

import com.softserve.edu.engine.WebDriverUtils;

public class Runner implements IRunner {

	public void stop() {
		WebDriverUtils.stop();
	}

	public void load(String path) {
		WebDriverUtils.load(path);
	}

	public void refresh() {
		WebDriverUtils.refresh();
	}
	public void previousPage() {
		WebDriverUtils.previousPage();
	}
	public void forwardPage() {
		WebDriverUtils.forwardPage();
	}
}
