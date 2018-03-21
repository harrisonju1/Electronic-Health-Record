package com.ex.beans;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class VisitDetails {
    public int visit_id;
    public int doctor_id;
    public int patient_id;
    public List<Diagnosis> diagnosisList;
    public List<Symptoms> symptomsList;
    public List<Prescriptions> prescriptionsList;
    public List<Treatments> treatmentsList;
    public List<Tests> testsList;

    public VisitDetails() {
    }

    public VisitDetails(int visit_id, int doctor_id, int patient_id, List<Diagnosis> diagnosisList, List<Symptoms> symptomsList, List<Prescriptions> prescriptionsList, List<Treatments> treatmentsList, List<Tests> testsList) {
        this.visit_id = visit_id;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.diagnosisList = diagnosisList;
        this.symptomsList = symptomsList;
        this.prescriptionsList = prescriptionsList;
        this.treatmentsList = treatmentsList;
        this.testsList = testsList;
    }

    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(int visit_id) {
        this.visit_id = visit_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public List<Diagnosis> getDiagnosisList() {
        return diagnosisList;
    }

    public void setDiagnosisList(List<Diagnosis> diagnosisList) {
        this.diagnosisList = diagnosisList;
    }

    public List<Symptoms> getSymptomsList() {
        return symptomsList;
    }

    public void setSymptomsList(List<Symptoms> symptomsList) {
        this.symptomsList = symptomsList;
    }

    public List<Prescriptions> getPrescriptionsList() {
        return prescriptionsList;
    }

    public void setPrescriptionsList(List<Prescriptions> prescriptionsList) {
        this.prescriptionsList = prescriptionsList;
    }

    public List<Treatments> getTreatmentsList() {
        return treatmentsList;
    }

    public void setTreatmentsList(List<Treatments> treatmentsList) {
        this.treatmentsList = treatmentsList;
    }

    public List<Tests> getTestsList() {
        return testsList;
    }

    public void setTestsList(List<Tests> testsList) {
        this.testsList = testsList;
    }
}
