package com.ex.beans;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="symptoms")
public class Symptoms {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int symptomId;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private int patientId;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="visit_id")
    private Visit visit;

    @Column(name="visit_date")
    private Date visitDate;

    @Column(name="symptoms")
    private String symptoms;

    public Symptoms() {
    }

    public Symptoms(int patientId, Doctor doctor, Visit visit, Date visitDate, String symptoms) {
        this.patientId = patientId;
        this.doctor = doctor;
        this.visit = visit;
        this.visitDate = visitDate;
        this.symptoms = symptoms;
    }

    public int getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(int symptomId) {
        this.symptomId = symptomId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctorId(Doctor doctor) {
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

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String toString() {
        return "Symptoms{" +
                "symptomId=" + symptomId +
                ", patientId=" + patientId +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", visitDate=" + visitDate +
                ", symptoms='" + symptoms + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptoms symptoms1 = (Symptoms) o;
        return symptomId == symptoms1.symptomId &&
                patientId == symptoms1.patientId &&
                doctor == symptoms1.doctor &&
                visit == symptoms1.visit &&
                Objects.equals(visitDate, symptoms1.visitDate) &&
                Objects.equals(symptoms, symptoms1.symptoms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(symptomId, patientId, doctor, visit, visitDate, symptoms);
    }
}
