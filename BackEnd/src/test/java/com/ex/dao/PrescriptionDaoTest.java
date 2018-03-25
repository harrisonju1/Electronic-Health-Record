package com.ex.dao;

import com.ex.beans.Prescriptions;
import com.ex.beans.Visit;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class PrescriptionDaoTest {

    @Test
    public void maintest() {
        PrescriptionsDao prescriptionDao = new PrescriptionsDao();

        Prescriptions prescription = new Prescriptions();

        // set needed values
        Visit v = new Visit();
        VisitDao visitDao = new VisitDao();
        v.setVisitDate(Date.from(Instant.now()));
        v = visitDao.create(v);
        prescription.setVisitId(v);

        // create test
        prescription = prescriptionDao.create(prescription);
        Assert.assertNotNull(prescription);

        // find by id test
        List<Prescriptions> found = prescriptionDao.findByPrescriptionsId(prescription.getPrescriptionId());
        Assert.assertNotNull(found);
        Assert.assertEquals(prescription.getPrescriptionId(), found.get(0).getPrescriptionId());

        // test other methods


        // update test
        // todo change a value

        Prescriptions updated = prescriptionDao.update(prescription);
        List<Prescriptions> updatedFound = prescriptionDao.findByPrescriptionsId(prescription.getPrescriptionId());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(prescription.getPrescriptionId(), updatedFound.get(0).getPrescriptionId());

        // delete test
        prescriptionDao.delete(prescription);
        visitDao.delete(v);

        // find all test
        List<Prescriptions> all = prescriptionDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(prescription));

    }

}