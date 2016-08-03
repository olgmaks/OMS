package com.softserve.edu.service;

import com.softserve.edu.dao.DatabaseUtils;
import com.softserve.edu.dao.RoleDao;
import com.softserve.edu.dao.UserDao;
import com.softserve.edu.entity.RoleDB;
import com.softserve.edu.entity.UserDB;

public class AdminService {
    UserDB user;

    public AdminService(String login) {
        user = new UserDao().getUserByLogin(login);
    }
    
    public String getLoginUserDB() {
        return this.user.getLogin();
    }

    public String getPasswordUserDB() {
        return this.user.getPassword();
    }

    public String getNameUserDB() {
        return this.user.getFirstName();
    }

    public String getEmailUserDB() {
        return this.user.getEmail();
    }

    public Long getRoleUserDB() {
        return this.user.getRole();
    }

    public String getRoleNameUserDB() {
        RoleDB role = new RoleDao().getRoleById(this.user.getRole());
        return role.getRoleName();
    }

    public void closeConnection() {
        DatabaseUtils.getInstance().closeConnection();
    }

}