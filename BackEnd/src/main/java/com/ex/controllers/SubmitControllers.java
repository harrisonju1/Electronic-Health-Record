package com.ex.controllers;

import com.ex.beans.*;
import com.ex.dao.*;
import com.ex.util.EncryptionUtil;
import com.ex.util.PdfMaker;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://universal-healthcare-force.s3-website-us-east-1.amazonaws.com"})
public class SubmitControllers {

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



}
