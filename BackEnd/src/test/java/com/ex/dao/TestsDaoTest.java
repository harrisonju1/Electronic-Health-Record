package com.ex.dao;

import com.ex.beans.Tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestsDaoTest {

    @Test
    public void test() {
        TestsDao testsDao = new TestsDao();
        Tests tests = new Tests();

        // create test
        tests = testsDao.create(tests);
        Assert.assertNotNull(tests);

        // find by id test
        List<Tests> found = testsDao.findByTestId(tests.getTestId());
        Assert.assertNotNull(found);
        Assert.assertEquals(tests, found);

        // update test
//        tests.
        Tests updated = testsDao.update(tests);

        // delete test
        testsDao.delete(tests);

        // find all test
        List<Tests> all = testsDao.findAll();

    }

}