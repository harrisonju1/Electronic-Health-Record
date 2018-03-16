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
    private int diagnosisId;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private PatientProfile patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="visit_id")
    private Visit visit;

    private Date visitDate;

    @Column(name="diagnosis")
    private String diagnosis;

    public Diagnosis() {
    }

    public Diagnosis(PatientProfile patient, Doctor doctor, Visit visit, Date visitDate, String diagnosis) {
        this.patient = patient;
        this.doctor = doctor;
        this.visit = visit;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
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
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
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
                "diagnosisId=" + diagnosisId +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", visitDate=" + visitDate +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis1 = (Diagnosis) o;
        return diagnosisId == diagnosis1.diagnosisId &&
                patient == diagnosis1.patient &&
                doctor == diagnosis1.doctor &&
                visit == diagnosis1.visit &&
                Objects.equals(visitDate, diagnosis1.visitDate) &&
                Objects.equals(diagnosis, diagnosis1.diagnosis);
    }

    @Override
    public int hashCode() {

        return Objects.hash(diagnosisId, patient, doctor, visit, visitDate, diagnosis);
    }
}
