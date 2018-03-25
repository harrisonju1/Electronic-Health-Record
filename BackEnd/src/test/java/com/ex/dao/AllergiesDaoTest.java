package com.ex.dao;

import com.ex.beans.Allergies;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AllergiesDaoTest {

    @Test
    public void maintest() {
        AllergiesDao allergiesDao = new AllergiesDao();

        Allergies allergies = new Allergies();

        // set needed values


        // create test
        allergies = allergiesDao.create(allergies);
        Assert.assertNotNull(allergies);

        // find by id test
//        List<Allergies> found = allergiesDao.findByTestId(allergies.getTestId());
//        Assert.assertNotNull(found);
//        Assert.assertEquals(allergies, found.get(0));

        // test other methods


        // update test
        // todo change a value

        Allergies updated = allergiesDao.update(allergies);
//        List<Allergies> updatedFound = allergiesDao.fin(allergies.getTestId());
//        Assert.assertNotNull(updatedFound);
//        Assert.assertEquals(allergies, updatedFound.get(0));

        // delete test
        allergiesDao.delete(allergies);

        // find all test
        List<Allergies> all = allergiesDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(allergies));

    }

}