package com.ex.controllers;

import com.ex.beans.*;
import com.ex.dao.*;
import com.ex.util.EncryptionUtil;
import com.ex.util.PdfMaker;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://universal-healthcare-force.s3-website-us-east-1.amazonaws.com"})
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

            pdf.addText("Visit ID: "+visitDetails.visit_id);
            
            pdf.addText("Doctor ID: "+visitDetails.doctor_id);
            pdf.addText("Patient ID: "+visitDetails.patient_id);

            // add lists to pdf
            pdf.addText("Diagnosis:");
            pdf.addList(visitDetails.diagnosis, false);
            
            pdf.addText("Symptoms:");
            pdf.addList(visitDetails.symptoms, false);
            
            pdf.addText("Prescriptions:");
            pdf.addList(visitDetails.prescriptions, false);
            
            pdf.addText("Treatments:");
            pdf.addList(visitDetails.treatments, false);
            
            pdf.addText("Tests:");
            pdf.addList(visitDetails.tests, false);
            
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
            profile.setPatient_id(patient_id);
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

            //diagnosis initialize
            DiagnosisDao diagnosisDao = new DiagnosisDao();
            Diagnosis diagnosis = new Diagnosis (pp, d, visit, "No Diagnosis");
            diagnosisDao.create(diagnosis);

            //Symptoms initialize
            SymptomsDao symptomsDao = new SymptomsDao();
            Symptoms symptoms = new Symptoms(pp,d,visit,"No Symptoms");
            symptomsDao.create(symptoms);

            //Treatments initialize
            TreatmentsDao treatmentsDao = new TreatmentsDao();
            Treatments treatments = new Treatments(d, pp, "No Treatments", visit);
            treatmentsDao.create(treatments);

            //tests initialize
            TestsDao testsDao = new TestsDao();
            Tests tests = new Tests(pp, d , visit, "No Tests");
            testsDao.create(tests);

            //Prescriptions initialize
            PrescriptionsDao prescriptionsDao = new PrescriptionsDao();
            Prescriptions prescriptions = new Prescriptions(pp, d, visit, "No Prescriptions");
            prescriptionsDao.create(prescriptions);

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

            //get patient for other fields and patient_id
            PatientProfile pp = visit.getPatient();

            //get Doctor for doctor id
            Doctor doctor = pp.getDoctor();

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

            VisitDetails visitDetails = new VisitDetails(visit_id, doctor.getDoctor_id(), pp.getPatient_id(), diagnosisList, symptomList, prescriptionsList, treatmentsList, testsList);
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

