package com.ex.dao;

import com.ex.beans.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

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

    @Test
    public void findOne1() {
        UserDao userDao = new UserDao();
        User user = new User();
        Random r = new Random();
        user.setUsername("testunamefind" + r.nextDouble());
        user = userDao.create(user);

        User result = userDao.findOne(user.getUsername());
        Assert.assertEquals(user, result);
        userDao.delete(user);
    }

    @Test
    public void findAll() {
        UserDao userDao = new UserDao();
        List<User> allbefore = userDao.findAll();

        User user = new User();
        user = userDao.create(user);
        User user2 = new User();
        user2 = userDao.create(user2);

        allbefore.add(user);
        allbefore.add(user2);

        List<User> allresult = userDao.findAll();
        Assert.assertNotNull(allresult);
        Assert.assertTrue(allresult.size()>=2);
        userDao.delete(user);
        userDao.delete(user2);
    }

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