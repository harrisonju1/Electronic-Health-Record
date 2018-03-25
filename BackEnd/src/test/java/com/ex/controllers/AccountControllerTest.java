package com.ex.controllers;

import com.ex.beans.Doctor;
import com.ex.beans.PatientProfile;
import com.ex.beans.User;
import com.ex.dao.DoctorsDao;
import com.ex.dao.PatientProfileDao;
import com.ex.dao.UserDao;
import com.ex.util.EncryptionUtil;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.*;

public class AccountControllerTest {

    @Test
    public void authorize() {
        AccountController accountController = new AccountController();

        String uname = "root";
        String cred = uname+":"+"root";
        cred = EncryptionUtil.encrypt(cred);
        Object user = accountController.authorize(cred);
       Assert.assertNotNull(user);
       Assert.assertEquals("root", ((User)user).getUsername());
    }

//    @Test
//    public void submitFormTest() {
//        AccountController accountController = new AccountController();
//
//        PatientProfile req = new PatientProfile();
////        req.setUserId(1);
//        Doctor doc = new Doctor("dfname2", "dlname2", "");
//        req.setDoctorId(doc);
//        req.setFirstName("firstNamesubtest");
//        req.setLastName("lastNamesubtest");
//        req.setSsn(123456789);
//        req.setDob(Date.from(Instant.now()));
//        req.setPhone_number("5553333999");
//        req.setEmail("emailsubtest");
//        req.setMarital_status("marital_statussubtest");
//        req.setGender("gendersubtest");
//        req.setEthnicity("ethnicitysubtest");
//        req.setOccupation("occupationsubtest");
//        req.setAddress("addresssubtest");
//        req.setCity("citysubtest");
//        req.setState("statesubtest");
//        req.setZipcode(55555);
//        req.setInsurance_provider("insurance_providersubtest");
//        req.setInsuranceId(59);
//        Object result = accountController.submitPatientProfile(req);
//        Assert.assertTrue(result instanceof Integer);
//        req.setPatient_id((Integer) result);
//        PatientProfile indb = new PatientProfileDao().findOneByPatientId(req.getPatientId());
//        Assert.assertEquals(req, indb);
//        // todo also test update
//        // todo and delete it
//    }
//    @Test
//    public void viewFormTest() {
//        AccountController accountController = new AccountController();
//        PatientProfile pp = new PatientProfile();
//        User user = new User();
//        new UserDao().create(user);
//        pp.setUserId(user.getId());
//        Doctor doc = new Doctor("dfname", "dlname", "");
//        new DoctorsDao().create(doc);
//        pp.setDoctorId(doc);
//        pp.setFirstName("firstNamevwtest");
//        pp.setLastName("lastNamevwtest");
//        pp.setSsn(123456789);
//        pp.setDob(Date.from(Instant.now()));
//        pp.setPhone_number("5553333929");
//        pp.setEmail("emailvwtest");
//        pp.setMarital_status("maritalvwtest");
//        pp.setGender("gendervwtest");
//        pp.setEthnicity("ethnicityvwtest");
//        pp.setOccupation("occupationvwtest");
//        pp.setAddress("addressvwtest");
//        pp.setCity("cityvwtest");
//        pp.setState("statevwtest");
//        pp.setZipcode(55552);
//        pp.setInsurance_provider("insurance_providervwtest");
//        pp.setInsuranceId(21);
//        pp = new PatientProfileDao().create(pp);
//
//        Object profile = accountController.viewPatientProfile(pp.getPatientId());
//
//        new PatientProfileDao().delete(pp);
//        Assert.assertEquals(pp, (PatientProfile) profile);
//        //todo test other identifiers (username, ssn?)
//    }
}