package com.softserve.edu;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.softserve.edu.dao.UserDao;
import com.softserve.edu.entity.UserDB;

public class DatabaseTest {

    @Test
    public void testDatabase() {
        System.out.println("\n+++DataBaseTest");
        UserDB user = new UserDB(0L, "1", "1", "1", "1", "1", 0L);
        user = new UserDao().getUserByLogin("iva");
        System.out.println("\n+++userFirstName=" + user.getFirstName());
        List<UserDB> users = new UserDao().getAllUsers();
        for(Iterator<UserDB> iterator = users.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next().toString());
            }
        System.out.println("\n\n\n");
    }
}
