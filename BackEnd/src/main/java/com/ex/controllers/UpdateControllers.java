package com.ex.controllers;


import com.ex.beans.*;
import com.ex.dao.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://universal-healthcare-force.s3-website-us-east-1.amazonaws.com"})
public class UpdateControllers {
    @RequestMapping(value = "/api/form/patient/update", method = RequestMethod.POST)
    Object updatePatient(@RequestBody PatientInfo patientInfo) {
        try {
            int doctor_id = patientInfo.getDoctor_id();
            DoctorsDao doctordao = new DoctorsDao();
            Doctor doctor = doctordao.getByDoctorId(doctor_id);
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
            int patient_id = patientInfo.getPatient_id();
            profile.setPatient_id(patient_id);
            updateProfile.update(profile);
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR:FAILED TO UPDATE PATIENT PROFILE " + e.getStackTrace();
        }
        return null;
    }



    @RequestMapping(value = "/api/form/visit/update", method = RequestMethod.POST)
    Object updateVisitDetail(@RequestBody VisitDetails visitDetails) {
        try {
            //get patient
            PatientProfileDao patientProfileDao = new PatientProfileDao();
            PatientProfile profile = patientProfileDao.findOneByPatientId(visitDetails.getPatient_id());

            DoctorsDao doctorsDao = new DoctorsDao();
            Doctor doctor = doctorsDao.getByDoctorId(visitDetails.getDoctor_id());

            VisitDao visitDao = new VisitDao();
            Visit visit = visitDao.findByVisitId(visitDetails.getVisit_id());

            //update diagnosis
            //initialize all variables for diagnosis
            DiagnosisDao diagnosisDao = new DiagnosisDao();
            List<String> diagnosisList = visitDetails.getDiagnosis();
            //if diagnosis is null or empty string, skip.

            if(diagnosisList.size() == 0){
                String diagnosis = "No Diagnosis";
                Diagnosis diagnosisBean = diagnosisDao.findByVisit(visit).get(0);
                diagnosisBean.setDiagnosis(diagnosis);
                diagnosisDao.update(diagnosisBean);
            }
            else if(diagnosisList.size() > 0) {
                String diagnosis = "";
                if (diagnosisList.size() == 1){
                    diagnosis = diagnosisList.get(0);
                }
                else {
                    for (int i = 0; i < diagnosisList.size(); i++) {
                        diagnosis = diagnosisList.get(i) + "," + diagnosis;
                    }
                }
                Diagnosis diagnosisBean = diagnosisDao.findByVisit(visit).get(0);
                diagnosisBean.setDiagnosis(diagnosis);
                diagnosisDao.update(diagnosisBean);
            }

            //update symptoms
            SymptomsDao symptomsDao = new SymptomsDao();
            List<String> symptomsList = visitDetails.getSymptoms();
            //if symptoms list is greater than one, add to string to add to database
            if (symptomsList.size() == 0){
                String symptoms = "No Symptoms";
                Symptoms symptomsBean = symptomsDao.findByVisit(visit).get(0);
                symptomsBean.setSymptoms(symptoms);
                symptomsDao.update(symptomsBean);
            }
            else if(symptomsList.size() > 0){
                String symptoms = "";
                if (symptomsList.size() == 1){
                    symptoms = symptomsList.get(0);
                    Symptoms symptomBean = symptomsDao.findByVisit(visit).get(0);
                    symptomBean.setSymptoms(symptoms);
                    symptomsDao.update(symptomBean);
                }
                else {
                    for (int i = 0; i < symptomsList.size(); i++) {
                        symptoms = symptomsList.get(i) + "," + symptoms ;
                    }
                }
                Symptoms symptomBean = symptomsDao.findByVisit(visit).get(0);
                symptomBean.setSymptoms(symptoms);
                symptomsDao.update(symptomBean);
            }

            //update prescription
            PrescriptionsDao prescriptionsDao = new PrescriptionsDao();
            List<String> prescriptionsList = visitDetails.getPrescriptions();
            if (prescriptionsList.size() == 0){
                String prescriptions = "No Prescriptions";
                Prescriptions prescriptionBean = prescriptionsDao.findByVisit(visit).get(0);
                prescriptionBean.setDrugs(prescriptions);
                prescriptionsDao.update(prescriptionBean);
            }
            else if(prescriptionsList.size() > 0){
                String prescriptions ="";
                if (prescriptionsList.size() == 1){
                    prescriptions = prescriptionsList.get(0);
                }
                else {
                    for (int i = 0; i < prescriptionsList.size(); i++) {
                        prescriptions = prescriptionsList.get(i) + "," + prescriptions;
                    }
                }
                Prescriptions prescriptionBean = prescriptionsDao.findByVisit(visit).get(0);
                prescriptionBean.setDrugs(prescriptions);
                prescriptionsDao.update(prescriptionBean);
            }

            //update tests
            TestsDao testsDao = new TestsDao();
            List<String> testsList = visitDetails.getTests();
            if (testsList.size() == 0){
                String tests = "No Test Ran";
                Tests testsBean = testsDao.findByVisit(visit).get(0);
                testsBean.setTest(tests);
                testsDao.update(testsBean);
            }
            else if(testsList.size() > 0){
                String tests = "";
                if (testsList.size() == 1){
                    tests = testsList.get(0);
                }
                else {
                    for (int i = 0; i < testsList.size(); i++) {
                        tests = testsList.get(i) + "," + tests;
                    }
                }
                Tests testsBean = testsDao.findByVisit(visit).get(0);
                testsBean.setTest(tests);
                testsDao.update(testsBean);
            }

            //update treatments
            TreatmentsDao treatmentsDao = new TreatmentsDao();
            List<String> treatmentsList = visitDetails.getTreatments();
            if (treatmentsList.size() == 0){
                String treatments = "No Treatments";
                Treatments treatmentsBean = treatmentsDao.findByVisit(visit).get(0);
                treatmentsBean.setTreatment(treatments);
                treatmentsDao.update(treatmentsBean);
            }
            else if(treatmentsList.size() > 0){
                String treatments = "";
                if (treatmentsList.size() == 1){
                    treatments = treatmentsList.get(0);
                }
                else {
                    for (int i = 0; i < treatmentsList.size(); i++) {
                        treatments = treatmentsList.get(i) + "," + treatments ;
                    }
                }
                Treatments treatmentsBean = treatmentsDao.findByVisit(visit).get(0);
                treatmentsBean.setTreatment(treatments);
                treatmentsDao.update(treatmentsBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: FAILED TO UPDATE VISIT DETAILS " + e.getStackTrace();
        }
        return null;
    }
}
