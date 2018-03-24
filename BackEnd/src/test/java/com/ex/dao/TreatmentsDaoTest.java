package com.ex.dao;

import com.ex.beans.Treatments;
import com.ex.beans.Visit;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TreatmentsDaoTest {

    @Test
    public void maintest() {
        TreatmentsDao treatmentsDao = new TreatmentsDao();

        Treatments treatments = new Treatments();

        // todo set needed values
        Visit v = new Visit();
        v.setVisitId(9999);
        treatments.setVisitId(v);

        // create test
        treatments = treatmentsDao.create(treatments);
        Assert.assertNotNull(treatments);

        // find by id test
        List<Treatments> found = treatmentsDao.findByTreatmentId(treatments.getTreatmentId());
        Assert.assertNotNull(found);
        Assert.assertEquals(treatments, found.get(0));

        // todo any other methods tested here


        // update test
        // todo actually change a value

        Treatments updated = treatmentsDao.update(treatments);
        List<Treatments> updatedFound = treatmentsDao.findByTreatmentId(treatments.getTreatmentId());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(treatments, updatedFound.get(0));

        // delete test
        treatmentsDao.delete(treatments);

        // find all test
        List<Treatments> all = treatmentsDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(treatments));

    }

}