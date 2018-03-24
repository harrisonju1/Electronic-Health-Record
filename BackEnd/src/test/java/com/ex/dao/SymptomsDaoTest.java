package com.ex.dao;

import com.ex.beans.Symptoms;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SymptomsDaoTest {

    @Test
    public void maintest() {
        SymptomsDao symptomsDao = new SymptomsDao();

        Symptoms symptoms = new Symptoms();

        // todo set needed values


        // create test
        symptoms = symptomsDao.create(symptoms);
        Assert.assertNotNull(symptoms);

        // find by id test
        List<Symptoms> found = symptomsDao.findBySymptomId(symptoms.getSymptomId());
        Assert.assertNotNull(found);
        Assert.assertEquals(symptoms, found.get(0));

        // todo any other methods tested here


        // update test
        // todo actually change a value

        Symptoms updated = symptomsDao.update(symptoms);
        List<Symptoms> updatedFound = symptomsDao.findBySymptomId(symptoms.getSymptomId());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(symptoms, updatedFound.get(0));

        // delete test
        symptomsDao.delete(symptoms);

        // find all test
        List<Symptoms> all = symptomsDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(symptoms));

    }

}