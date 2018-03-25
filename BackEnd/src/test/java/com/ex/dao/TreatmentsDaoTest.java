package com.ex.dao;

import com.ex.beans.Treatments;
import com.ex.beans.Visit;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class TreatmentsDaoTest {

    @Test
    public void maintest() {
        TreatmentsDao treatmentsDao = new TreatmentsDao();

        Treatments treatments = new Treatments();

        // set needed values
        Visit v = new Visit();
        VisitDao visitDao = new VisitDao();
        v.setVisitDate(Date.from(Instant.now()));
        v = visitDao.create(v);
        treatments.setVisitId(v);

        // create test
        treatments = treatmentsDao.create(treatments);
        Assert.assertNotNull(treatments);

        // find by id test
        List<Treatments> found = treatmentsDao.findByTreatmentId(treatments.getTreatmentId());
        Assert.assertNotNull(found);
        Assert.assertEquals(treatments.getTreatmentId(), found.get(0).getTreatmentId());

        // test other methods


        // update test
        // todo change a value

        Treatments updated = treatmentsDao.update(treatments);
        List<Treatments> updatedFound = treatmentsDao.findByTreatmentId(treatments.getTreatmentId());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(treatments.getTreatmentId(), updatedFound.get(0).getTreatmentId());

        // delete test
        treatmentsDao.delete(treatments);
        visitDao.delete(v);

        // find all test
        List<Treatments> all = treatmentsDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(treatments));

    }

}