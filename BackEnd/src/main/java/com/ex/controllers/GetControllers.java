package com.ex.controllers;

import com.ex.beans.*;
import com.ex.dao.*;
import com.ex.util.PdfMaker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://universal-healthcare-force.s3-website-us-east-1.amazonaws.com"})
public class GetControllers {

    // returns the pdf for visit details
    @RequestMapping(value = "/api/pdf/visitdetails", produces = "application/pdf")
    Object getPDF(@RequestBody VisitDetails visitDetails) {

        try {
            // create a new pdf for this visit details
            PdfMaker pdf = new PdfMaker();
            pdf.setTitle("=========== VISIT DETAILS ===========");

            pdf.addText("============================== VISIT DETAILS ==============================");

            pdf.addText("                                                                 Visit ID: "+visitDetails.visit_id + "                                                       ");

            pdf.addText("                                                                 Doctor ID: "+visitDetails.doctor_id + "                                                       ");

            pdf.addText("                                                                 Patient ID: "+visitDetails.patient_id + "                                                       ");

            pdf.addText("==========================================================================");
            pdf.addText("          ");
            // add lists to pdf
            pdf.addText("DIAGNOSIS");
            pdf.addList(visitDetails.diagnosis, false);

            pdf.addText("--------------------------------------------------------------------------------------------------------------------------------");

            pdf.addText("SYMPTOMS");
            pdf.addList(visitDetails.symptoms, false);

            pdf.addText("--------------------------------------------------------------------------------------------------------------------------------");

            pdf.addText("PRESCRIPTIONS");
            pdf.addList(visitDetails.prescriptions, false);

            pdf.addText("--------------------------------------------------------------------------------------------------------------------------------");

            pdf.addText("TREATMENTS");
            pdf.addList(visitDetails.treatments, false);

            pdf.addText("--------------------------------------------------------------------------------------------------------------------------------");

            pdf.addText("TESTS");
            pdf.addList(visitDetails.tests, false);

            pdf.addText("--------------------------------------------------------------------------------------------------------------------------------");

            return pdf.finishDocument();
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR:FAILED TO CREATE PATIENT DETAILS PDF" + e.getStackTrace();
        }
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

            //get list of prescriptions
            PrescriptionsDao prescriptionsDao = new PrescriptionsDao();
            List<Prescriptions> allPrescriptions = prescriptionsDao.findByVisit(visit);
            List<String> prescriptionsList = new ArrayList<>();
            toSplit = "";
            if (allPrescriptions.size() != 0 && toSplit != null){
                toSplit = allPrescriptions.get(0).getDrugs();
                prescriptionsList = new ArrayList<>(Arrays.asList(toSplit.split(",")));
            }

            //get list of treatments
            TreatmentsDao treatmentsDao = new TreatmentsDao();
            List<Treatments> allTreatments = treatmentsDao.findByVisit(visit);
            List<String> treatmentsList = new ArrayList<>();
            if (allTreatments.size() != 0 && toSplit != null){
                toSplit = allTreatments.get(0).getTreatment();
                treatmentsList = new ArrayList<>(Arrays.asList(toSplit.split(",")));
            }

            //get list of tests
            TestsDao testsDao = new TestsDao();
            List<Tests> allTests = testsDao.findByVisit(visit);
            List<String> testsList = new ArrayList<>();
            toSplit = "";
            if (allTests.size() != 0 && toSplit != null){
                toSplit = allTests.get(0).getTest();
                testsList = new ArrayList<>(Arrays.asList(toSplit.split(",")));
            }

            VisitDetails visitDetails = new VisitDetails(visit_id, doctor.getDoctor_id(), pp.getPatient_id(), diagnosisList, symptomList, prescriptionsList, treatmentsList, testsList);
            return visitDetails;

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: FAILED TO RETRIEVE ALL VISIT DETAILS " + e.getStackTrace();
        }
    }


}
