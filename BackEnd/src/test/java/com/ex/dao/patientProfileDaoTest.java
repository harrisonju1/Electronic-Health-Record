package com.ex.dao;

import com.ex.beans.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class patientProfileDaoTest {
    @Before
    public void before(){
        final PatientProfileDao profileDao= new PatientProfileDao();
        profileDao.findAll().forEach((p)->{
            profileDao.delete(p);
        });
    }

    @Test
    public void create(){
        PatientProfileDao profileDao = new PatientProfileDao();
        PatientProfile profile = new PatientProfile();
        profile = profileDao.create(profile);
        PatientProfile result = profileDao.findOneByPatientId(profile.getPatient_id());
    }

    @Test
    public void update() {
        PatientProfileDao profileDao = new PatientProfileDao();
        PatientProfile profile = new PatientProfile();
        profile = profileDao.create(profile);

//        patient_id SERIAL PRIMARY KEY,
//        doctor_id int REFERENCES doctors (doctor_id),
//                first_name varchar(25),
//                last_name varchar(25),
//                ssn int,
//        dob date,
//        phone_number int,
//        email varchar(55),
//                marital_status varchar(20),
//                gender varchar(55),
//                ethnicity varchar(55),
//                occupation varchar(25),
//                address varchar(55),
//                city varchar(25),
//                state varchar(25),
//                zipcode varchar(25),
//                insurance_provider varchar(55),
//                insurance_id int
//
//        user.setFirstName("testfnameupdate");
//        user.setLastName("testlnameupdate");
//        user.setPassword("testpassupdate");
//        user.setRole("testroleupdate");
//        user.setUsername("testusernameupdate");
//
//        user = userDao.update(user);
        profile.setPatient_id(1);
        profile.setDoctor_id(1);
        profile.setUser

        PatientProfile result = profileDao.findOneByPatientId(profile.getPatient_id());
        Assert.assertEquals(profile, result);

    }


}
