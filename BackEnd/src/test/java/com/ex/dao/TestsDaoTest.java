package com.ex.dao;

import com.ex.beans.Tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestsDaoTest {

    TestsDao testsDao = new TestsDao();
    Tests exTests = null;

    @Before
    public void before() {
        exTests = new Tests();
        testsDao.create(exTests);
    }

    @After
    public void after() {
        testsDao.delete(exTests);
    }

    @Test
    public void create() {
        Tests tests = new Tests();
        tests = testsDao.create(tests);
        List<Tests> byTestId = testsDao.findByTestId(tests.getTestId());
        Assert.assertNotNull(byTestId);
        Assert.assertEquals(tests, byTestId);
    }

    @Test
    public void update() {
    }

    @Test
    public void findByTestId() {
    }

    @Test
    public void findByPatient() {
    }

    @Test
    public void findByVisit() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void delete() {
    }
}