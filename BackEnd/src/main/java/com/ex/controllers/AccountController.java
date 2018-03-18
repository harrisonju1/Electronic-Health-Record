package com.ex.controllers;

import com.ex.beans.PatientProfile;
import com.ex.beans.User;
import com.ex.dao.DoctorsDao;
import com.ex.dao.PatientProfileDao;
import com.ex.dao.UserDao;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
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
    @RequestMapping(value = "/api/patientprofile/submit", method = RequestMethod.POST)
    Object submitPatientProfile(@RequestBody Object patientInfo) {
        //todo update
        try {
            PatientProfile profile = (PatientProfile) patientInfo;
            profile.setDoctorId(new DoctorsDao().create(profile.getDoctor()));
            PatientProfile patientProfile = new PatientProfileDao().create((PatientProfile) patientInfo);
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
