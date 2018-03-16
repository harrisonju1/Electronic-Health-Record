package com.ex.controllers;

import com.ex.beans.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountControllerTest {

    @Test
    public void authorize() {
        AccountController accountController = new AccountController();
        String uname = "root";
        String cred = uname+":"+"root";
        Object user = accountController.authorize(cred);
        Assert.assertNotNull(user);
        Assert.assertEquals("root", ((User)user).getUsername());
    }
}