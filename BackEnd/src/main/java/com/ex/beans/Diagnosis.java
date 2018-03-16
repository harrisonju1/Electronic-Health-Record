package com.ex.beans;

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
    @JoinColumn(name="patient_id")
    private PatientProfile patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="visit_id")
    private Visit visit;

    private Date visit_date;

    @Column(name="diagnosis")
    private String diagnosis;

    public Diagnosis() {
    }

    public Diagnosis(PatientProfile patient, Doctor doctor, Visit visit, Date visit_date, String diagnosis) {
        this.patient = patient;
        this.doctor = doctor;
        this.visit = visit;
        this.visit_date = visit_date;
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

    public Date getVisitDate() {
        return visit_date;
    }

    public void setVisitDate(Date visit_date) {
        this.visit_date = visit_date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosis_id=" + diagnosis_id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", visit_date=" + visit_date +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis1 = (Diagnosis) o;
        return diagnosis_id == diagnosis1.diagnosis_id &&
                patient == diagnosis1.patient &&
                doctor == diagnosis1.doctor &&
                visit == diagnosis1.visit &&
                Objects.equals(visit_date, diagnosis1.visit_date) &&
                Objects.equals(diagnosis, diagnosis1.diagnosis);
    }

    @Override
    public int hashCode() {

        return Objects.hash(diagnosis_id, patient, doctor, visit, visit_date, diagnosis);
    }
}
