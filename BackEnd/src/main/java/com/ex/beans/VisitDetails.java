package com.ex.beans;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class VisitDetails {
    public int visit_id;
    public Date visit_date;
    public int patient_id;
    public List<Diagnosis> diagnosisList;
    public List<Symptoms> symptomsList;
    public List<Prescriptions> prescriptionsList;
    public List<Treatments> treatmentsList;
    public List<Tests> testsList;

    public VisitDetails() {
    }

    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(int visit_id) {
        this.visit_id = visit_id;
    }

    public Date getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(Date visit_date) {
        this.visit_date = visit_date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitDetails that = (VisitDetails) o;
        return visit_id == that.visit_id &&
                patient_id == that.patient_id &&
                Objects.equals(visit_date, that.visit_date) &&
                Objects.equals(diagnosisList, that.diagnosisList) &&
                Objects.equals(symptomsList, that.symptomsList) &&
                Objects.equals(prescriptionsList, that.prescriptionsList) &&
                Objects.equals(treatmentsList, that.treatmentsList) &&
                Objects.equals(testsList, that.testsList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(visit_id, visit_date, patient_id, diagnosisList, symptomsList, prescriptionsList, treatmentsList, testsList);
    }

    @Override
    public String toString() {
        return "VisitDetails{" +
                "visit_id=" + visit_id +
                ", visit_date=" + visit_date +
                ", patient_id=" + patient_id +
                ", diagnosisList=" + diagnosisList +
                ", symptomsList=" + symptomsList +
                ", prescriptionsList=" + prescriptionsList +
                ", treatmentsList=" + treatmentsList +
                ", testsList=" + testsList +
                '}';
    }
}
