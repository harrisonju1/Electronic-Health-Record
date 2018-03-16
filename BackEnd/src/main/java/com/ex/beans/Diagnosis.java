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
    private int patientId;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private int doctorId;

    @ManyToOne
    @JoinColumn(name="visit_id")
    private int visitId;

    @ManyToOne
    @JoinColumn
    private Date visitDate;

    @Column(name="diagnosis")
    private String diagnosis;

    public Diagnosis() {
    }

    public Diagnosis(int patientId, int doctorId, int visitId, Date visitDate, String diagnosis) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
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

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
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
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", visitId=" + visitId +
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
                patientId == diagnosis1.patientId &&
                doctorId == diagnosis1.doctorId &&
                visitId == diagnosis1.visitId &&
                Objects.equals(visitDate, diagnosis1.visitDate) &&
                Objects.equals(diagnosis, diagnosis1.diagnosis);
    }

    @Override
    public int hashCode() {

        return Objects.hash(diagnosisId, patientId, doctorId, visitId, visitDate, diagnosis);
    }
}
