package com.ex.dao;

import com.ex.beans.Doctor;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class DoctorsDaoTest {

    @Test
    public void maintest() {
        DoctorsDao doctorDao = new DoctorsDao();

        Doctor doctor = new Doctor();

        // set needed values
        doctor.setDoctor_id(new Random().nextInt());
        doctor.setFirst_name("fname");
        doctor.setLast_name("lname");
        doctor.setField("fieldtest");

        // create test
        doctor = doctorDao.create(doctor);
        Assert.assertNotNull(doctor);

        // find by id test
        Doctor found = doctorDao.getByDoctorId(doctor.getDoctor_id());
        Assert.assertNotNull(found);
        Assert.assertEquals(doctor, found);

        // test other methods


        // update test
        // todo change a value

        Doctor updated = doctorDao.update(doctor);
        Doctor updatedFound = doctorDao.getByDoctorId(doctor.getDoctor_id());
        Assert.assertNotNull(updatedFound);
        Assert.assertEquals(doctor, updatedFound);

        // delete test
        doctorDao.delete(doctor);

        // find all test
        List<Doctor> all = doctorDao.findAll();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.contains(doctor));

    }

}