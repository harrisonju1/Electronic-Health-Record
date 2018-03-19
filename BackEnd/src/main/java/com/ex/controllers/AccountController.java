package com.ex.controllers;

import com.ex.beans.Doctor;
import com.ex.beans.PatientProfile;
import com.ex.beans.User;
import com.ex.dao.DoctorsDao;
import com.ex.dao.PatientProfileDao;
import com.ex.dao.UserDao;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    // checks to make sure the username and password match
    // returns the user if true
    // otherwise returns null
    @RequestMapping("/api/authorize")
    Object authorize(@RequestBody String cred){
        String username = cred.split(":")[0];
        String password = cred.split(":")[1];
        System.out.println("login attempt: u:"+username+", p:"+password);
        User found = new UserDao().findOne(username);
        if (found!=null && found.getPassword().equals(password)) {
            return found;
        }
        return null;
    }

    // adds or updates the patient profile to the database
    // returns error message if failed, or returns the id on success
    @RequestMapping(value = "/api/form/patient", method = RequestMethod.POST)
    Object submitPatientProfile(@RequestBody PatientProfile patientInfo) {
        try {
//            Doctor doctor = patientInfo.getDoctor();
//            String first_name = patientInfo.getFirstName();
//            String last_name = patientInfo.getLastName();
//            int ssn = patientInfo.getSsn();
//            Date dob = patientInfo.getDob();
//            String phone = patientInfo.getPhone_number();
//            String email = patientInfo.getEmail();
//            String marital_status= patientInfo.getMarital_status();
//            String gender = patientInfo.getGender();
//            String ethnicity = patientInfo.getEthnicity();
//            String occupation = patientInfo.getOccupation();
//            String address = patientInfo.getAddress();
//            String city = patientInfo.getCity();
//            String state = patientInfo.getState();
//            int zipcode = patientInfo.getZipcode();
//            String insurance = patientInfo.getInsurance_provider();
//            int insurance_id = patientInfo.getInsuranceId();
//            PatientProfile profile = new PatientProfile(doctor, first_name, last_name, ssn,dob,phone,email
//            ,marital_status,gender,ethnicity,occupation,address,city,state,zipcode,insurance,insurance_id);
//            PatientProfile profile = new PatientProfile();

            patientInfo.setDoctorId(new DoctorsDao().create(patientInfo.getDoctor()));
            PatientProfile patientProfile = new PatientProfileDao().create((PatientProfile) patientInfo);
            System.out.println(patientInfo);
            System.out.println(patientInfo.getPatientId());
//            new PatientProfileDao().create(patientInfo);
            System.out.println(patientInfo.getPatientId());
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR:FAILED TO CREATE PATIENT PROFILE " + e.getStackTrace();
        }
        return null;
    }

    @RequestMapping(value="/api/patientprofile/edit", method = RequestMethod.POST)
    Object editPatientProfile(@RequestBody Object patientInfo){
        try{
            PatientProfile patientProfile = new PatientProfileDao().update((PatientProfile) patientInfo);
        } catch (Exception e){
            e.printStackTrace();
            return "ERROR:FAILED TO UPDATE PATIENT PROFILE " + e.getStackTrace();
        }
        return null;
    }

    // returns the patient profile with the username or id from the database
    @RequestMapping(value = "/api/patientprofile/view", method = RequestMethod.GET)
    Object viewPatientProfile(@RequestBody Object identifier) {
        //todo

        return null;
    }
}
