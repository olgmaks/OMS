package com.softserve.edu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
	private static final String TEST_PROPERTIES_FILE_NAME = "/test.properties";
	private static final String TEST_PROPERTIES_STATUS = "status";
	private static final String TEST_PROPERTIES_EXCEPTION = TEST_PROPERTIES_FILE_NAME
			+ " could not be read";

	// @Test
	public void testClassTests() {
		Tools tools = new Tools();
		Pages pages = new Pages();
		Assert.assertEquals(12, tools.add(5, 7), 0.00001);
		Assert.assertEquals(6, pages.avg(5, 7), 0.00001);
	}

	@Test
	public void testPropertiesFileAccessTests() throws IOException {
		Properties properties = new Properties();
		String propertieStatus;
		InputStream fileInputStream = AppTest.this.getClass()
				.getResourceAsStream(TEST_PROPERTIES_FILE_NAME);
		properties.load(fileInputStream);
		propertieStatus = properties.getProperty(TEST_PROPERTIES_STATUS,
				TEST_PROPERTIES_EXCEPTION);
		System.out.println("\n***** propertieStatus=" + propertieStatus);
		Assert.assertEquals("run", propertieStatus);
	}
}
