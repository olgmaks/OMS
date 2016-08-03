package com.softserve.edu.data;

public class UrlRepository {

	private static final String LOCAL_URL = "http://localhost:8080/OMS/login.htm";

	private UrlRepository() {
	}

	public static String getLocalUrl() {
		return LOCAL_URL;
	}
}
