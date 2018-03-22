package com.ex.controllers;

import com.ex.beans.*;
import com.ex.dao.*;
import com.ex.util.EncryptionUtil;
import com.ex.util.PdfMaker;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
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
    @RequestMapping("/api/pdf")
    String getPDF() {
        return new PdfMaker()
                .add(new Paragraph("Sample paragraph text"))
//                .add(Image.getInstance(""))
                .finishDocument();
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
            System.out.println(profile);
            updateProfile.update(profile);
            System.out.println(profile);
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
    Object getVisitDetailByPatient(@RequestParam int visit_id) {
        try {
            VisitDao visitDao = new VisitDao();
            Visit visit = visitDao.findByVisitId(visit_id);

            //get patient for other fields and patient_id
            PatientProfile pp = visit.getPatient();

            //get Doctor for doctor id
            Doctor doctor = pp.getDoctor();

            //get list of diagnosis by patient
            DiagnosisDao diagnosisDao = new DiagnosisDao();
            List<Diagnosis> d = diagnosisDao.findByVisit(visit);
            String toSplit = d.get(0).getDiagnosis();
            List<String> diagnosisList = new ArrayList<>(Arrays.asList(toSplit.split(",")));

            //get list of symptoms by patient
            SymptomsDao symptomsDao = new SymptomsDao();
            List<Symptoms> s = symptomsDao.findByVisit(visit);
            toSplit = s.get(0).getSymptoms();
            List<String> symptomList = new ArrayList<>(Arrays.asList(toSplit.split(",")));

            //get list of prescriptions
            PrescriptionsDao prescriptionsDao = new PrescriptionsDao();
            List<Prescriptions> allPrescriptions = prescriptionsDao.findByVisit(visit);
            toSplit = allPrescriptions.get(0).getDrugs();
            List<String> prescriptionsList = new ArrayList<>(Arrays.asList(toSplit.split(",")));

            //get list of treatments
            TreatmentsDao treatmentsDao = new TreatmentsDao();
            List<Treatments> allTreatments = treatmentsDao.findByVisit(visit);
            toSplit = allTreatments.get(0).getTreatment();
            List<String> treatmentsList = new ArrayList<>(Arrays.asList(toSplit.split(",")));

            //get list of tests
            TestsDao testsDao = new TestsDao();
            List<Tests> allTests = testsDao.findByVisit(visit);
            toSplit = allTests.get(0).getTest();
            List<String> testsList = new ArrayList<>(Arrays.asList(toSplit.split(",")));

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
            List<String> diagnosisList = visitDetails.getDiagnosisList();
            String diagnosis ="";
            for (int i = 0; i < diagnosisList.size(); i++){
                diagnosis = diagnosis + "," +diagnosisList.get(i);
            }
            DiagnosisDao dd = new DiagnosisDao();
            List<Diagnosis> d = dd.findByVisit(visit);
            Diagnosis diag = d.get(0);
            diag.setDiagnosis(diagnosis);
            System.out.println(diag);
            dd.update(diag);

            //update symptoms
            List<String> symptomsList = visitDetails.getSymptomsList();
            String symptoms = "";
            for (int i = 0; i < symptomsList.size(); i++){
                symptoms = symptoms + "," + symptomsList.get(i);
            }
            SymptomsDao s = new SymptomsDao();
            List<Symptoms> symptoms1 = s.findByVisit(visit);
            Symptoms symptom3 = symptoms1.get(0);
            symptom3.setSymptoms(symptoms);
            s.update(symptom3);

            //update prescriptions
            List<String> prescriptionsList = visitDetails.getPrescriptionsList();
            String prescriptions = "";
            for (int i = 0; i < prescriptionsList.size(); i++){
                prescriptions = prescriptions + "," + prescriptionsList.get(i);
            }
            PrescriptionsDao prescriptionsDao = new PrescriptionsDao();
            List<Prescriptions> pl = prescriptionsDao.findByVisit(visit);
            Prescriptions prescriptions1 = pl.get(0);
            prescriptions1.setDrugs(prescriptions);
            prescriptionsDao.update(prescriptions1);

            //update treatment
            List<String> treatmentsList = visitDetails.getTreatmentsList();
            String treatments = "";
            for (int i = 0; i <treatmentsList.size(); i++){
                treatments = treatments + "," + treatmentsList.get(i);
            }
            TreatmentsDao treatmentsDao = new TreatmentsDao();
            List<Treatments> treatmentsList1 = treatmentsDao.findByVisit(visit);



            //update tests
            List<String> testsList = visitDetails.getTestsList();
            String tests = "";
            for (int i = 0; i < testsList.size(); i++){
                tests = tests + "," + testsList.get(i);
            }
            TestsDao testsDao = new TestsDao();
            List<Tests> testBean = testsDao.findByVisit(visit);

            testsDao.update(testBean.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: FAILED TO UPDATE VISIT DETAILS " + e.getStackTrace();
        }
        return null;
    }
}

