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
        v.setVisit_date(Date.from(Instant.now()));
        v = visitDao.create(v);
        prescription.setVisit(v);

        // create test
        prescription = prescriptionDao.create(prescription);
        Assert.assertNotNull(prescription);

        // find by id test
        List<Prescriptions> found = prescriptionDao.findByPrescriptionsId(prescription.getPrescription_id());
        Assert.assertNotNull(found);
        Assert.assertEquals(prescription.getPrescription_id(), found.get(0).getPrescription_id());

        // test other methods


        // update test
        // todo change a value

        Prescriptions updated = prescriptionDao.update(prescription);
        List<Prescriptions> updatedFound = prescriptionDao.findByPrescriptionsId(prescription.getPrescription_id());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(prescription.getPrescription_id(), updatedFound.get(0).getPrescription_id());

        // delete test
        prescriptionDao.delete(prescription);
        visitDao.delete(v);

        // find all test
        List<Prescriptions> all = prescriptionDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(prescription));

    }

}