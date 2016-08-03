package com.softserve.edu.service;

import com.softserve.edu.dao.DatabaseUtils;

public final class DatabaseService {

	private DatabaseService() {
	}

	public static void closeConnection() {
        DatabaseUtils.getInstance().closeConnection();
    }
}
