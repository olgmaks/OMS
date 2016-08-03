package com.softserve.edu.engine;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtils {
	private static WebDriver driver;
	private static final long IMPLICITLY_WAIT_TIMEOUT = 20;
	private static final Object SYNC_ROOT = new Object();

	private WebDriverUtils() {
	}

	protected static WebDriver getWebDriver() {
		if (driver == null) {
			synchronized (SYNC_ROOT) {
				if (driver == null) {
					// TODO Develop Other WebDrivers, Read from pom.xml
					driver = new FirefoxDriver();
					driver.manage()
							.timeouts()
							.implicitlyWait(getImplicitlyWaitTimeout(),
									TimeUnit.SECONDS);
					driver.manage().window().maximize();
				}
			}
		}
		return driver;
	}

	public static long getImplicitlyWaitTimeout() {
		return IMPLICITLY_WAIT_TIMEOUT;
	}

	public static void stop() {
		if (driver != null) {
			driver.quit();
		}
		driver = null;
	}

	public static void load(String path) {
		getWebDriver().get(path);
	}

	public static void refresh() {
		getWebDriver().navigate().refresh();
	}

	public static void alertAccept() {
		getWebDriver().switchTo().alert().accept();
	}

	public static void alertDismiss() {
		getWebDriver().switchTo().alert().dismiss();
	}
	
	public static String getAlertText() {
		return getWebDriver().switchTo().alert().getText();
	}
	
	public static void previousPage() {
		getWebDriver().navigate().back();
	}
	public static void forwardPage() {
		getWebDriver().navigate().forward();
	}
}
