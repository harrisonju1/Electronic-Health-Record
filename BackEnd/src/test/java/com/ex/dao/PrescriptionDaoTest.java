package com.ex.dao;

import com.ex.beans.Prescriptions;
import com.ex.beans.Visit;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PrescriptionDaoTest {

    @Test
    public void maintest() {
        PrescriptionsDao prescriptionDao = new PrescriptionsDao();

        Prescriptions prescription = new Prescriptions();

        // todo set needed values
        Visit v = new Visit();
        v.setVisitId(9999);
        prescription.setVisitId(v);

        // create test
        prescription = prescriptionDao.create(prescription);
        Assert.assertNotNull(prescription);

        // find by id test
        List<Prescriptions> found = prescriptionDao.findByPrescriptionsId(prescription.getPrescriptionId());
        Assert.assertNotNull(found);
        Assert.assertEquals(prescription, found.get(0));

        // todo any other methods tested here


        // update test
        // todo actually change a value

        Prescriptions updated = prescriptionDao.update(prescription);
        List<Prescriptions> updatedFound = prescriptionDao.findByPrescriptionsId(prescription.getPrescriptionId());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(prescription, updatedFound.get(0));

        // delete test
        prescriptionDao.delete(prescription);

        // find all test
        List<Prescriptions> all = prescriptionDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(prescription));

    }

}