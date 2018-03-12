package com.ex.dao;

import com.ex.beans.User;
import org.junit.Assert;
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
    }

    @Test
    public void update() {
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.create(user);

        user.setFirstName("testfnameupdate");
        user.setLastName("testlnameupdate");
        user.setPassword("testpassupdate");
        user.setRole("testroleupdate");
        user.setUsername("testusernameupdate");

        user = userDao.update(user);

        User result = userDao.findOne(user.getId());
        Assert.assertEquals(user, result);
    }

    @Test
    public void findOne() {
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.create(user);

        User result = userDao.findOne(user.getId());
        Assert.assertEquals(user, result);
    }

    @Test
    public void findOne1() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("testunamefind");
        user = userDao.create(user);

        User result = userDao.findOne(user.getUsername());
        Assert.assertEquals(user, result);
    }

    @Test
    public void findAll() {
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.create(user);
        User user2 = new User();
        user = userDao.create(user);

        List<User> all = userDao.findAll();
        Assert.assertArrayEquals(new User[]{user, user2}, all.toArray());
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