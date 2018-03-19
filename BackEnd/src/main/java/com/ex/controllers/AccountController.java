package com.ex.controllers;

import com.ex.beans.Doctor;
import com.ex.beans.PatientInfo;
import com.ex.beans.PatientProfile;
import com.ex.beans.User;
import com.ex.dao.DoctorsDao;
import com.ex.dao.PatientProfileDao;
import com.ex.dao.UserDao;
import com.ex.util.EncryptionUtil;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    // checks to make sure the username and password match
    // returns the user if true
    // otherwise returns null
    @RequestMapping("/api/authorize")
    Object authorize(@RequestBody String encred){
        String cred = EncryptionUtil.decrypt(encred);
        System.out.println("got "+encred+" to "+cred);
        try {
            String[] uandp = cred.split(":");
            if (uandp.length<2)
                return null;
            String username = uandp[0];
            String password = uandp[1];
            System.out.println("login attempt: u:" + username + ", p:" + password);
            User found = new UserDao().findOne(username);
            if (found != null && found.getPassword().equals(password)) {
                return found;
            }
        } catch (Exception e) {e.printStackTrace();}
        return null;
    }

    // adds or updates the patient profile to the database
    // returns error message if failed, or returns the id on success
    @RequestMapping(value = "/api/form/patient", method = RequestMethod.POST)
    Object submitPatientProfile(@RequestBody PatientInfo patientInfo) {
        try {
            int doctor_id = patientInfo.getDoctor_id();
            DoctorsDao doctordao = new DoctorsDao();
            Doctor doctor =  doctordao.getByDoctorId(doctor_id);
            String first_name = patientInfo.getFirst_name();
            String last_name = patientInfo.getLast_name();
            int ssn = patientInfo.getSsn();
            Date dob = patientInfo.getDob();
            String phone_number = patientInfo.getPhone_number();
            String email = patientInfo.getEmail();
            String marital_status = patientInfo.getMarital_status();
            String gender = patientInfo.getGender();
            String ethnicity = patientInfo.getEthnicity();
            String occupation = patientInfo.getOccupation();
            String address = patientInfo.getAddress();
            String city = patientInfo.getCity();
            String state = patientInfo.getState();
            int zipcode = patientInfo.getZipcode();
            String insurance_provider = patientInfo.getInsurance_provider();
            int insurance_id = patientInfo.getInsurance_id();
            PatientProfile profile = new PatientProfile(doctor, first_name, last_name, ssn, dob, phone_number, email, marital_status, gender, ethnicity, occupation, address, city, state, zipcode, insurance_provider, insurance_id);
            PatientProfileDao createProfile = new PatientProfileDao();
            createProfile.create(profile);

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR:FAILED TO CREATE PATIENT PROFILE " + e.getStackTrace();
        }
        return null;
    }

    @RequestMapping(value="/api/form/patient/update", method = RequestMethod.POST)
    Object editPatientProfile(@RequestBody PatientInfo patientInfo){
        try{
            int doctor_id = patientInfo.getDoctor_id();
            DoctorsDao doctordao = new DoctorsDao();
            Doctor doctor =  doctordao.getByDoctorId(doctor_id);
            String first_name = patientInfo.getFirst_name();
            String last_name = patientInfo.getLast_name();
            int ssn = patientInfo.getSsn();
            Date dob = patientInfo.getDob();
            String phone_number = patientInfo.getPhone_number();
            String email = patientInfo.getEmail();
            String marital_status = patientInfo.getMarital_status();
            String gender = patientInfo.getGender();
            String ethnicity = patientInfo.getEthnicity();
            String occupation = patientInfo.getOccupation();
            String address = patientInfo.getAddress();
            String city = patientInfo.getCity();
            String state = patientInfo.getState();
            int zipcode = patientInfo.getZipcode();
            String insurance_provider = patientInfo.getInsurance_provider();
            int insurance_id = patientInfo.getInsurance_id();
            PatientProfile profile = new PatientProfile(doctor, first_name, last_name, ssn, dob, phone_number, email, marital_status, gender, ethnicity, occupation, address, city, state, zipcode, insurance_provider, insurance_id);
            PatientProfileDao updateProfile = new PatientProfileDao();
            updateProfile.update(profile);
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
    @RequestMapping(value = "/api/form/patient/all", method = RequestMethod.GET)
    Object getAllPatientProfile(){
        List<PatientInfo> sendProfiles= new ArrayList<>();
        try{
            PatientProfileDao getProfiles = new PatientProfileDao();
            List<PatientProfile> allProfiles;
            allProfiles = getProfiles.findAll();

            for (int i =0; i < allProfiles.size(); i++){
                PatientInfo p = new PatientInfo(allProfiles.get(i));
                sendProfiles.add(p);
            }

            return sendProfiles;
        } catch (Exception e){
            e.printStackTrace();
            return "ERROR:FAILED TO RETRIEVE PATIENT PROFILES " + e.getStackTrace();
        }
    }
    @RequestMapping(value="/api/form/patient", method = RequestMethod.GET)
    public @RequestBody
    Object getByPatientId(@RequestParam int patient_id){
        try{
            PatientProfileDao getProfile = new PatientProfileDao();
            PatientProfile getProfile1= getProfile.findOneByPatientId(patient_id);
            PatientInfo profile = new PatientInfo(getProfile1);
            System.out.println(profile);
            return profile;
        } catch (Exception e){
            e.printStackTrace();
            return "ERROR:FAILED TO RETRIEVE PATIENT PROFILE " + e.getStackTrace();
        }
    }
}
