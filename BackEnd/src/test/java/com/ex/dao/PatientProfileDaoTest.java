package com.ex.dao;

import com.ex.beans.PatientInfo;
import com.ex.beans.PatientProfile;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PatientProfileDaoTest {

    @Test
    public void maintest() {
        PatientProfileDao patientProfileDao = new PatientProfileDao();

        PatientProfile patientProfile = new PatientProfile();

        // set needed values


        // create test
        PatientInfo patientInfo = patientProfileDao.create(patientProfile);
        patientProfile.setPatientId(patientInfo.patient_id);
        Assert.assertNotNull(patientProfile);

        // find by id test
        PatientProfile found = patientProfileDao.findOneByPatientId(patientProfile.getPatientId());
        Assert.assertNotNull(found);
        Assert.assertEquals(patientProfile, found);

        // test other methods


        // update test
        // todo change a value

        PatientProfile updated = patientProfileDao.update(patientProfile);
        PatientProfile updateFound = patientProfileDao.findOneByPatientId(patientProfile.getPatientId());
        Assert.assertNotNull(updateFound);
        Assert.assertEquals(patientProfile, updateFound);

        // delete test
        patientProfileDao.delete(patientProfile);

        // find all test
        List<PatientProfile> all = patientProfileDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(patientProfile));

    }

}