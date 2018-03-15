package com.ex.dao;

import com.ex.beans.*;
import java.util.List;
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
        Assert.assertEquals(profile, result);
    }

    @Test
    public void update() {
        PatientProfileDao profileDao = new PatientProfileDao();
        PatientProfile profile = new PatientProfile();
        profile = profileDao.create(profile);

        profile.setDoctor_id(1);
        profile.setUser_id(1);
        profile.setDob(null);
        profile.setPhone_number(123);
        profile.setEmail("test@test.com");
        profile.setMarital_status("the 10th gender");
        profile.setEthnicity("nordic");
        profile.setOccupation("Hammer King");
        profile.setAddress("Natalie Portman's address");
        profile.setCity("Asgard");
        profile.setState("the state of moving atm");
        profile.setZipcode(48102);
        profile.setInsurance_provider("Odin");
        profile.setInsurance_id(123);

        PatientProfile result = profileDao.findOneByPatientId(profile.getPatient_id());
        Assert.assertEquals(profile, result);

    }

    @Test
    public void findOneByPatientId(){
        PatientProfileDao profileDao = new PatientProfileDao();
        PatientProfile profile = new PatientProfile();
        profile = profileDao.create(profile);

        PatientProfile result = profileDao.findOneByPatientId(profile.getPatient_id());
        Assert.assertEquals(profile, result);
    }

    @Test
    public void findOneByUserId(){
        PatientProfileDao profileDao = new PatientProfileDao();
        PatientProfile profile = new PatientProfile();
        profile = profileDao.create(profile);

        PatientProfile result = profileDao.findOneByPatientId(profile.getUser_id());
        Assert.assertEquals(profile, result);
    }

    @Test
    public void findOneByDoctorId(){
        PatientProfileDao profileDao = new PatientProfileDao();
        PatientProfile profile = new PatientProfile();
        profile = profileDao.create(profile);

        PatientProfile result = profileDao.findOneByPatientId(profile.getDoctor_id());
        Assert.assertEquals(profile, result);
    }

    @Test
    public void findAll(){
        PatientProfileDao profileDao = new PatientProfileDao();
        PatientProfile profile = new PatientProfile();
        profile = profileDao.create(profile);
        PatientProfile profile2 = new PatientProfile();
        profile2 = profileDao.create(profile2);

        List<PatientProfile> all = profileDao.findAll();
        Assert.assertArrayEquals(new PatientProfile[]{profile,profile2}, all.toArray());
    }

    @Test
    public void delete(){
        PatientProfileDao profileDao = new PatientProfileDao();
        PatientProfile profile = new PatientProfile();
        profile = profileDao.create(profile);
        profileDao.delete(profile);
        PatientProfile result = profileDao.findOneByPatientId(profile.getPatient_id());
        Assert.assertNull(result);
    }

}