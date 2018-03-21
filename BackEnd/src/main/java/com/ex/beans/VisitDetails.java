package com.ex.beans;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class VisitDetails {
    public int visit_id;
    public int doctor_id;
    public int patient_id;
    public List<String> diagnosisList;
    public List<String> symptomsList;
    public List<String> prescriptionsList;
    public List<String> treatmentsList;
    public List<String> testsList;

    public VisitDetails() {
    }

    public VisitDetails(int visit_id, int doctor_id, int patient_id, List<String> diagnosisList, List<String> symptomsList, List<String> prescriptionsList, List<String> treatmentsList, List<String> testsList) {
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

    public List<String> getDiagnosisList() {
        return diagnosisList;
    }

    public void setDiagnosisList(List<String> diagnosisList) {
        this.diagnosisList = diagnosisList;
    }

    public List<String> getSymptomsList() {
        return symptomsList;
    }

    public void setSymptomsList(List<String> symptomsList) {
        this.symptomsList = symptomsList;
    }

    public List<String> getPrescriptionsList() {
        return prescriptionsList;
    }

    public void setPrescriptionsList(List<String> prescriptionsList) {
        this.prescriptionsList = prescriptionsList;
    }

    public List<String> getTreatmentsList() {
        return treatmentsList;
    }

    public void setTreatmentsList(List<String> treatmentsList) {
        this.treatmentsList = treatmentsList;
    }

    public List<String> getTestsList() {
        return testsList;
    }

    public void setTestsList(List<String> testsList) {
        this.testsList = testsList;
    }
}
