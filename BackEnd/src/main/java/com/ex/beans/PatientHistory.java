package com.ex.beans;

import javax.persistence.*;
import java.util.*;
import org.json.simple.JSONObject;


@Entity
@Table(name="patienthistory")
public class PatientHistory {
    @Id
    @Column(name="history_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int historyId;

    @Column(name="patient_id")
    private int patientId;

    @Column(name="doctor_id")
    private int doctorId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="allergies")
    private String allergies[];

    @Column(name="visit_reason")
    private String visitReason;

    @Column(name="symptoms")
    private JSONObject symptoms;

    @Column(name="tests")
    private JSONObject tests;

    @Column(name="treatment_history")
    private JSONObject treatmentHistory;

    @Column(name="drug_history")
    private JSONObject drugHistory;

    @Column(name="current_prescription")
    private String currentPrescription;

    public PatientHistory() {
    }

    public PatientHistory(int patientId, int doctorId, String firstName, String lastName, int age, String[] allergies, String visitReason, JSONObject symptoms, JSONObject tests, JSONObject treatmentHistory, JSONObject drugHistory, String currentPrescription) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.allergies = allergies;
        this.visitReason = visitReason;
        this.symptoms = symptoms;
        this.tests = tests;
        this.treatmentHistory = treatmentHistory;
        this.drugHistory = drugHistory;
        this.currentPrescription = currentPrescription;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getAllergies() {
        return allergies;
    }

    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    public JSONObject getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(JSONObject symptoms) {
        this.symptoms = symptoms;
    }

    public JSONObject getTests() {
        return tests;
    }

    public void setTests(JSONObject tests) {
        this.tests = tests;
    }

    public JSONObject getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(JSONObject treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    public JSONObject getDrugHistory() {
        return drugHistory;
    }

    public void setDrugHistory(JSONObject drugHistory) {
        this.drugHistory = drugHistory;
    }

    public String getCurrentPrescription() {
        return currentPrescription;
    }

    public void setCurrentPrescription(String currentPrescription) {
        this.currentPrescription = currentPrescription;
    }

    @Override
    public String toString() {
        return "PatientHistory{" +
                "historyId=" + historyId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", allergies=" + Arrays.toString(allergies) +
                ", visitReason='" + visitReason + '\'' +
                ", symptoms=" + symptoms +
                ", tests=" + tests +
                ", treatmentHistory=" + treatmentHistory +
                ", drugHistory=" + drugHistory +
                ", currentPrescription='" + currentPrescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientHistory that = (PatientHistory) o;
        return historyId == that.historyId &&
                patientId == that.patientId &&
                doctorId == that.doctorId &&
                age == that.age &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Arrays.equals(allergies, that.allergies) &&
                Objects.equals(visitReason, that.visitReason) &&
                Objects.equals(symptoms, that.symptoms) &&
                Objects.equals(tests, that.tests) &&
                Objects.equals(treatmentHistory, that.treatmentHistory) &&
                Objects.equals(drugHistory, that.drugHistory) &&
                Objects.equals(currentPrescription, that.currentPrescription);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(historyId, patientId, doctorId, firstName, lastName, age, visitReason, symptoms, tests, treatmentHistory, drugHistory, currentPrescription);
        result = 31 * result + Arrays.hashCode(allergies);
        return result;
    }
}
