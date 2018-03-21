package com.ex.beans;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class VisitDetails {
    public int visit_id;
    public int doctor_id;
    public int patient_id;
    public List<String> diagnosis;
    public List<String> symptoms;
    public List<String> prescriptions;
    public List<String> treatments;
    public List<String> tests;

    public VisitDetails() {
    }

    public VisitDetails(int visit_id, int doctor_id, int patient_id, List<String> diagnosis, List<String> symptoms, List<String> prescriptions, List<String> treatments, List<String> tests) {
        this.visit_id = visit_id;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.diagnosis = diagnosis;
        this.symptoms = symptoms;
        this.prescriptions = prescriptions;
        this.treatments = treatments;
        this.tests = tests;
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

    public List<String> getDiagnosisList() {
        return diagnosis;
    }

    public void setDiagnosisList(List<String> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<String> getSymptomsList() {
        return symptoms;
    }

    public void setSymptomsList(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public List<String> getPrescriptionsList() {
        return prescriptions;
    }

    public void setPrescriptionsList(List<String> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<String> getTreatmentsList() {
        return treatments;
    }

    public void setTreatmentsList(List<String> treatments) {
        this.treatments = treatments;
    }

    public List<String> getTestsList() {
        return tests;
    }

    public void setTestsList(List<String> tests) {
        this.tests = tests;
    }
}
