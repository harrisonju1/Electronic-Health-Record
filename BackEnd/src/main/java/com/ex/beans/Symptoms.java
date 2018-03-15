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

    @OneToMany
    @JoinColumn(name="patient_id")
    private int patientId;

    @OneToMany
    @JoinColumn(name="doctor_id")
    private int doctorId;

    @OneToMany
    @JoinColumn(name="visit_id")
    private int visitId;

    @OneToMany
    @JoinColumn(name="visit_date")
    private Date visitDate;

    @Column(name="symptoms")
    private String symptoms;

    public Symptoms() {
    }

    public Symptoms(int patientId, int doctorId, int visitId, Date visitDate, String symptoms) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitId = visitId;
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
                ", doctorId=" + doctorId +
                ", visitId=" + visitId +
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
                doctorId == symptoms1.doctorId &&
                visitId == symptoms1.visitId &&
                Objects.equals(visitDate, symptoms1.visitDate) &&
                Objects.equals(symptoms, symptoms1.symptoms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(symptomId, patientId, doctorId, visitId, visitDate, symptoms);
    }
}
