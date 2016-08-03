package com.softserve.edu;

public class RunnerPage {

	private static RunnerPageUIMap controls;
	private static final Object SYNC_RUNNER = new Object();

	private RunnerPage() {
	}

	private static RunnerPageUIMap getRunnerPageUIMap() {
		if (controls == null) {
			synchronized (SYNC_RUNNER) {
				if (controls == null) {
					controls = new RunnerPageUIMap();
				}
			}
		}
		return controls;
	}

	public static void stop() {
		getRunnerPageUIMap().runner.stop();
	}

	public static void load(String path) {
		getRunnerPageUIMap().runner.load(path);
	}

	public static void refresh() {
		getRunnerPageUIMap().runner.refresh();
	}
	public static void previousPage() {
		getRunnerPageUIMap().runner.previousPage();
	}
	public static void forwardPage() {
		getRunnerPageUIMap().runner.forwardPage();
	}
}
