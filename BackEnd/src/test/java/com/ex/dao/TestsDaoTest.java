package com.ex.dao;

import com.ex.beans.Tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestsDaoTest {

    @Test
    public void maintest() {
        TestsDao testsDao = new TestsDao();

        Tests tests = new Tests();

        // set needed values


        // create test
        tests = testsDao.create(tests);
        Assert.assertNotNull(tests);

        // find by id test
        List<Tests> found = testsDao.findByTestId(tests.getTestId());
        Assert.assertNotNull(found);
        Assert.assertEquals(tests, found.get(0));

        // test other methods


        // update test
        // todo change a value

        Tests updated = testsDao.update(tests);
        List<Tests> updatedFound = testsDao.findByTestId(tests.getTestId());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(tests, updatedFound.get(0));

        // delete test
        testsDao.delete(tests);

        // find all test
        List<Tests> all = testsDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(tests));

    }

}