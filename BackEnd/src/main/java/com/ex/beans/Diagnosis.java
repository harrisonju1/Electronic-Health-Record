package com.ex.beans;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="diagnosis")
public class Diagnosis {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int diagnosis_id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="patient_id")
    private PatientProfile patient;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="visit_id")
    private Visit visit;

    @Column(name="diagnosis")
    private String diagnosis;

    public Diagnosis() {
    }

    public Diagnosis(PatientProfile patient, Doctor doctor, Visit visit, String diagnosis) {
        this.patient = patient;
        this.doctor = doctor;
        this.visit = visit;
        this.diagnosis = diagnosis;
    }

    public int getDiagnosisId() {
        return diagnosis_id;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosis_id = diagnosis_id;
    }

    public PatientProfile getPatient() {
        return patient;
    }

    public void setPatient(PatientProfile patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisitId(Visit visit) {
        this.visit = visit;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis1 = (Diagnosis) o;
        return diagnosis_id == diagnosis1.diagnosis_id &&
                Objects.equals(patient, diagnosis1.patient) &&
                Objects.equals(doctor, diagnosis1.doctor) &&
                Objects.equals(visit, diagnosis1.visit) &&
                Objects.equals(diagnosis, diagnosis1.diagnosis);
    }

    @Override
    public int hashCode() {

        return Objects.hash(diagnosis_id, patient, doctor, visit, diagnosis);
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosis_id=" + diagnosis_id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
