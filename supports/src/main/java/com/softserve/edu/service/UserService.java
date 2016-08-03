package com.softserve.edu.service;

import com.softserve.edu.dao.RoleDao;
import com.softserve.edu.dao.UserDao;
import com.softserve.edu.entity.RoleDB;
import com.softserve.edu.entity.UserDB;

public class UserService {
	// TODO Insert, Update, Delete
	UserDao userDao;
	RoleDao roleDao;
	UserDB userDB;
	RoleDB roleDB;

	public UserService(String login) {
		userDao = new UserDao();
		roleDao = new RoleDao();
		userDB = userDao.getUserByLogin(login);
		roleDB = roleDao.getRoleById(this.getRoleIdUserDB());
	}

	public String getLoginUserDB() {
		return this.userDB.getLogin();
	}

	public String getPasswordUserDB() {
		return this.userDB.getPassword();
	}

	public String getNameUserDB() {
		return this.userDB.getFirstName();
	}

	public String getEmailUserDB() {
		return this.userDB.getEmail();
	}

	public Long getRoleIdUserDB() {
		return this.userDB.getRole();
	}

	public String getRoleNameUserDB() {
		return this.roleDB.getRoleName();
	}

	public boolean deleteUserDB() {
		boolean result = this.userDao.deleteUserById(userDB.getId());
		// TODO
		this.userDB = null;
		return result;
	}

}
