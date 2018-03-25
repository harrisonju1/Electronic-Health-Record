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

        // set needed values


        // create test
        symptoms = symptomsDao.create(symptoms);
        Assert.assertNotNull(symptoms);

        // find by id test
        List<Symptoms> found = symptomsDao.findBySymptomId(symptoms.getSymptom_id());
        Assert.assertNotNull(found);
        Assert.assertEquals(symptoms, found.get(0));

        // test other methods


        // update test
        // todo change a value

        Symptoms updated = symptomsDao.update(symptoms);
        List<Symptoms> updatedFound = symptomsDao.findBySymptomId(symptoms.getSymptom_id());
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