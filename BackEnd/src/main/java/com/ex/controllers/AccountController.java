package com.ex.controllers;

import com.ex.beans.*;
import com.ex.dao.*;
import com.ex.util.EncryptionUtil;
import com.ex.util.PdfMaker;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    // checks to make sure the username and password match
    // returns the user if true
    // otherwise returns null
    @RequestMapping("/api/authorize")
    Object authorize(@RequestBody String encred) {
        String cred = EncryptionUtil.decrypt(encred);
        System.out.println("got " + encred + " to " + cred);
        try {
            String[] uandp = cred.split(":");
            if (uandp.length < 2)
                return null;
            String username = uandp[0];
            String password = uandp[1];
            System.out.println("login attempt: u:" + username + ", p:" + password);
            User found = new UserDao().findOne(username);
            if (found != null && found.getPassword().equals(password)) {
                return found;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // returns the data for a pdf
    @RequestMapping("/pdftest")
    String getPDF1() {
        return "<a href=\"http://localhost:8090/api/pdf/visitdetails\">View pdf</a>";
    }
    // returns the pdf for visit details
    @RequestMapping(value = "/api/pdf/visitdetails", produces = "application/pdf")
    Object getPDF(@RequestBody VisitDetails visitDetails) {
        try {
            // create a new pdf for this visit details
            PdfMaker pdf = new PdfMaker();
            pdf.setTitle("Visit Details");

            pdf.add(new Paragraph("Visit ID: "+visitDetails.visit_id));
            pdf.add(new Paragraph("Doctor ID: "+visitDetails.doctor_id));
            pdf.add(new Paragraph("Patient ID: "+visitDetails.patient_id));

            // add lists to pdf
            pdf.add(new Paragraph("Diagnosis"));
            com.itextpdf.text.List diagnosislist = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
            for(int i=0;i<visitDetails.diagnosis.size();i++) {
                diagnosislist.add(visitDetails.diagnosis.get(i));
            }
            pdf.add(diagnosislist);
            pdf.add(new Paragraph("Symptoms"));
            com.itextpdf.text.List symptomslist = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
            for(int i=0;i<visitDetails.symptoms.size();i++) {
                symptomslist.add(visitDetails.symptoms.get(i));
                pdf.add(new Paragraph("Diagnosis"));
            }
            pdf.add(symptomslist);
            pdf.add(new Paragraph("Prescriptions"));
            com.itextpdf.text.List prescriptionslist = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
            for(int i=0;i<visitDetails.prescriptions.size();i++) {
                prescriptionslist.add(visitDetails.prescriptions.get(i));
            }
            pdf.add(prescriptionslist);
            pdf.add(new Paragraph("Treatments"));
            com.itextpdf.text.List treatmentslist = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
            for(int i=0;i<visitDetails.treatments.size();i++) {
                treatmentslist.add(visitDetails.treatments.get(i));
            }
            pdf.add(treatmentslist);
            pdf.add(new Paragraph("Tests"));
            com.itextpdf.text.List testslist = new com.itextpdf.text.List(com.itextpdf.text.List.UNORDERED);
            for(int i=0;i<visitDetails.tests.size();i++) {
                testslist.add(visitDetails.tests.get(i));
            }
            pdf.add(testslist);

            return pdf.finishDocument();
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR:FAILED TO CREATE PATIENT DETAILS PDF" + e.getStackTrace();
        }
    }

    // adds or updates the patient profile to the database
    // returns error message if failed, or returns the id on success
    @RequestMapping(value = "/api/form/patient", method = RequestMethod.POST)
    Object submitPatientProfile(@RequestBody PatientInfo patientInfo) {
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
            PatientProfileDao createProfile = new PatientProfileDao();
            createProfile.create(profile);

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR:FAILED TO CREATE PATIENT PROFILE " + e.getStackTrace();
        }
        return null;
    }

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
            profile.setPatientId(patient_id);
            updateProfile.update(profile);
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR:FAILED TO UPDATE PATIENT PROFILE " + e.getStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/api/form/patient/all", method = RequestMethod.GET)
    Object getAllPatientProfile() {
        List<PatientInfo> sendProfiles = new ArrayList<>();
        try {
            PatientProfileDao getProfiles = new PatientProfileDao();
            List<PatientProfile> allProfiles;
            allProfiles = getProfiles.findAll();

            for (int i = 0; i < allProfiles.size(); i++) {
                PatientInfo p = new PatientInfo(allProfiles.get(i));
                sendProfiles.add(p);
            }

            return sendProfiles;
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR:FAILED TO RETRIEVE PATIENT PROFILES " + e.getStackTrace();
        }
    }

    @RequestMapping(value = "/api/form/patient", method = RequestMethod.GET)
    Object getByPatientId(@RequestParam int patient_id) {
        try {
            PatientProfileDao getProfile = new PatientProfileDao();
            PatientProfile getProfile1 = getProfile.findOneByPatientId(patient_id);
            PatientInfo profile = new PatientInfo(getProfile1);
            return profile;
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR:FAILED TO RETRIEVE PATIENT PROFILE " + e.getStackTrace();
        }
    }

    @RequestMapping(value = "/api/form/doctor", method = RequestMethod.GET)
    Object getDoctor(@RequestParam int doctor_id) {
        try {
            DoctorsDao getDoctor = new DoctorsDao();
            Doctor doctor = getDoctor.getByDoctorId(doctor_id);
            return doctor;
        } catch (Exception e) {
            e.printStackTrace();
            ;
            return "ERROR:FAILED TO RETRIEVE DOCTOR " + e.getStackTrace();
        }
    }

    @RequestMapping(value = "/api/form/visit", method = RequestMethod.POST)
    Object createAppointment(@RequestBody VisitInfo visitInfo) {
        try {
            PatientProfileDao pd = new PatientProfileDao();
            PatientProfile pp = pd.findOneByPatientId(visitInfo.getPatient_id());
            DoctorsDao dd = new DoctorsDao();
            Doctor d = dd.getByDoctorId(visitInfo.getDoctor_id());
            Visit visit = new Visit(visitInfo.getVisit_date(), pp, d, visitInfo.getVisit_reason());
            VisitDao visitDao = new VisitDao();
            visitDao.create(visit);
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: FAILED TO RETRIEVE VISIT " + e.getStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/api/form/visit", method = RequestMethod.GET)
    Object getAllVisits(@RequestParam int patient_id) {
        try {
            PatientProfileDao pd = new PatientProfileDao();
            PatientProfile pp = pd.findOneByPatientId(patient_id);
            VisitDao visitDao = new VisitDao();
            List<Visit> allVisits = visitDao.findByPatientId(pp);
            List<VisitInfo> patientVisits = new ArrayList<>();
            for (int i = 0; i < allVisits.size(); i++) {
                VisitInfo vi = new VisitInfo(allVisits.get(i));
                patientVisits.add(vi);
            }
            return patientVisits;
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: FAILED TO RETRIEVE ALL VISITS " + e.getStackTrace();
        }
    }

    @RequestMapping(value = "api/form/visit/details", method = RequestMethod.GET)
    Object getVisitDetailByVisit(@RequestParam int visit_id) {
        try {
            VisitDao visitDao = new VisitDao();
            Visit visit = visitDao.findByVisitId(visit_id);
            System.out.println("visit id is not null \n");

            //get patient for other fields and patient_id
            PatientProfile pp = visit.getPatient();
            System.out.println("patient profile is not null \n");

            //get Doctor for doctor id
            Doctor doctor = pp.getDoctor();
            System.out.println("doctor is not null \n");

            //get list of diagnosis by patient
            DiagnosisDao diagnosisDao = new DiagnosisDao();
            List<Diagnosis> d = diagnosisDao.findByVisit(visit);
            String toSplit = "";
            List<String> diagnosisList = new ArrayList<>();
            if (d.size() != 0) {
                toSplit = d.get(0).getDiagnosis();
                diagnosisList = new ArrayList<>(Arrays.asList(toSplit.split(",")));
            }
//            System.out.println("diagnosis is not null \n");
            //get list of symptoms by patient
            SymptomsDao symptomsDao = new SymptomsDao();
            List<Symptoms> s = symptomsDao.findByVisit(visit);
            List<String> symptomList = new ArrayList<>();
            toSplit = "";
            if (s.size() != 0 && toSplit != null) {
                toSplit = s.get(0).getSymptoms();
                symptomList = new ArrayList<>(Arrays.asList(toSplit.split(",")));
            }
            System.out.println("symptoms is not null \n");

            //get list of prescriptions
            PrescriptionsDao prescriptionsDao = new PrescriptionsDao();
            List<Prescriptions> allPrescriptions = prescriptionsDao.findByVisit(visit);
            List<String> prescriptionsList = new ArrayList<>();
            toSplit = "";
            if (allPrescriptions.size() != 0 && toSplit != null){
                toSplit = allPrescriptions.get(0).getDrugs();
                prescriptionsList = new ArrayList<>(Arrays.asList(toSplit.split(",")));
            }
            System.out.println("prescriptions is not null \n");

            //get list of treatments
            TreatmentsDao treatmentsDao = new TreatmentsDao();
            List<Treatments> allTreatments = treatmentsDao.findByVisit(visit);
            List<String> treatmentsList = new ArrayList<>();
            if (allTreatments.size() != 0 && toSplit != null){
                toSplit = allTreatments.get(0).getTreatment();
                treatmentsList = new ArrayList<>(Arrays.asList(toSplit.split(",")));
            }
            System.out.println("treatments is not null \n");

            //get list of tests
            TestsDao testsDao = new TestsDao();
            List<Tests> allTests = testsDao.findByVisit(visit);
            List<String> testsList = new ArrayList<>();
            toSplit = "";
            if (allTests.size() != 0 && toSplit != null){
                toSplit = allTests.get(0).getTest();
                testsList = new ArrayList<>(Arrays.asList(toSplit.split(",")));
            }
            System.out.println("tests are not null \n");

            VisitDetails visitDetails = new VisitDetails(visit_id, doctor.getDoctor_id(), pp.getPatientId(), diagnosisList, symptomList, prescriptionsList, treatmentsList, testsList);
            return visitDetails;

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: FAILED TO RETRIEVE ALL VISIT DETAILS " + e.getStackTrace();
        }
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
            if(diagnosisList.size() > 1) {
                String diagnosis = "";
                for (int i = 1; i < diagnosisList.size(); i++) {
                    diagnosis = diagnosis + "," + diagnosisList.get(i);
                }
                Diagnosis diagnosisBean = new Diagnosis(profile, doctor, visit, diagnosis);
                diagnosisDao.update(diagnosisBean);
            }

            //update symptoms
            SymptomsDao symptomsDao = new SymptomsDao();
            List<String> symptomsList = visitDetails.getSymptoms();
            //if symptoms list is greater than one, add to string to add to database
            if(symptomsList.size() > 1){
                String symptoms = "";
                for (int i = 1; i < symptomsList.size(); i++){
                    symptoms = symptoms + "," + symptomsList.get(i);
                }
                Symptoms symptomBean = new Symptoms(profile, doctor, visit, symptoms);
                symptomsDao.update(symptomBean);
            }

            //update prescription
            PrescriptionsDao prescriptionsDao = new PrescriptionsDao();
            List<String> prescriptionsList = visitDetails.getPrescriptions();
            if(prescriptionsList.size() > 1){
                String prescriptions ="";
                for (int i = 1; i < prescriptionsList.size(); i++){
                    prescriptions = prescriptions + "," + prescriptionsList.get(i);
                }
                Prescriptions prescriptionBean = new Prescriptions(profile, doctor, visit, prescriptions);
                prescriptionsDao.update(prescriptionBean);
            }

            //update tests
            TestsDao testsDao = new TestsDao();
            List<String> testsList = visitDetails.getTests();
            if(testsList.size() > 1){
                String tests = "";
                for (int i = 1; i < testsList.size(); i++){
                    tests = tests + "," + testsList.get(i);
                }
                Tests testsBean = new Tests(profile, doctor, visit, tests);
                testsDao.update(testsBean);
            }

            //update treatments
            TreatmentsDao treatmentsDao = new TreatmentsDao();
            List<String> treatmentsList = visitDetails.getTreatments();
            if(treatmentsList.size() > 1){
                String treatments = "";
                for (int i = 1; i < treatmentsList.size(); i++){
                    treatments = treatments + "," + treatmentsList.get(i);
                }
                Treatments treatmentsBean = new Treatments(doctor, profile, treatments, visit);
                treatmentsDao.update(treatmentsBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: FAILED TO UPDATE VISIT DETAILS " + e.getStackTrace();
        }
        return null;
    }
}

