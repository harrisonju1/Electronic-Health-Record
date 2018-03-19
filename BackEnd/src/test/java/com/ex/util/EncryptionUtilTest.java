package com.ex.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptionUtilTest {

    @Test
    public void encrypt() {
        String val = "hello world! 9910";
        String e = EncryptionUtil.encrypt(val);
//        System.out.println(e);
        String d = EncryptionUtil.decrypt(e);
//        System.out.println(d);
        Assert.assertNotEquals(val, e);
        Assert.assertEquals(val, d);
    }
}