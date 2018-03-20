package com.ex.dao;

import com.ex.beans.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void create() {
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.create(user);
        User result = userDao.findOne(user.getId());
        Assert.assertEquals(user, result);
        userDao.delete(user);
    }

    @Test
    public void update() {
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.create(user);

        user.setPassword("testpassupdate");
        user.setRole("testroleupdate");
        user.setUsername("testusernameupdate");

        user = userDao.update(user);

        User result = userDao.findOne(user.getId());
        Assert.assertEquals(user, result);
        userDao.delete(user);
    }

    @Test
    public void findOne() {
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.create(user);

        User result = userDao.findOne(user.getId());
        Assert.assertEquals(user, result);
        userDao.delete(user);
    }

    // @Test
    // public void findOne1() {
    //     UserDao userDao = new UserDao();
    //     User user = new User();
    //     user.setUsername("testunamefind1");
    //     user = userDao.create(user);

    //     User result = userDao.findOne(user.getUsername());
    //     Assert.assertEquals(user, result);
    //     userDao.delete(user);
    // }

    // @Test
    // public void findAll() {
    //     UserDao userDao = new UserDao();
    //     List<User> allbefore = userDao.findAll();

    //     User user = new User();
    //     user = userDao.create(user);
    //     User user2 = new User();
    //     user2 = userDao.create(user2);

    //     allbefore.add(user);
    //     allbefore.add(user2);

    //     List<User> allresult = userDao.findAll();
    //     Assert.assertArrayEquals(allbefore.toArray(), allresult.toArray());
    //     userDao.delete(user);
    //     userDao.delete(user2);
    // }

    @Test
    public void delete() {
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.create(user);
        userDao.delete(user);
        User result = userDao.findOne(user.getId());
        Assert.assertNull(result);
    }
}