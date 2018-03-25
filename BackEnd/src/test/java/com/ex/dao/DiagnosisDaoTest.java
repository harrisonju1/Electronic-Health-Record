package com.ex.dao;

import com.ex.beans.Diagnosis;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DiagnosisDaoTest {

    @Test
    public void maintest() {
        DiagnosisDao diagnosisDao = new DiagnosisDao();

        Diagnosis diagnosis = new Diagnosis();

        // set needed values


        // create test
        diagnosis = diagnosisDao.create(diagnosis);
        Assert.assertNotNull(diagnosis);

        // find by id test
        List<Diagnosis> found = diagnosisDao.findByDiagnosisId(diagnosis.getDiagnosisId());
        Assert.assertNotNull(found);
        Assert.assertEquals(diagnosis, found.get(0));

        // test other methods


        // update test
        // todo change a value

        Diagnosis updated = diagnosisDao.update(diagnosis);
        List<Diagnosis> updatedFound = diagnosisDao.findByDiagnosisId(diagnosis.getDiagnosisId());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(diagnosis, updatedFound.get(0));

        // delete test
        diagnosisDao.delete(diagnosis);

        // find all test
        List<Diagnosis> all = diagnosisDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(diagnosis));

    }

}