package com.ex.beans;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="symptoms")
public class Symptoms {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int symptom_id;

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

    @Column(name="visit_date")
    private Date visit_date;

    @Column(name="symptoms")
    private String symptoms;

    public Symptoms() {
    }

    public Symptoms(PatientProfile patient, Doctor doctor, Visit visit, Date visit_date, String symptoms) {
        this.patient = patient;
        this.doctor = doctor;
        this.visit = visit;
        this.visit_date = visit_date;
        this.symptoms = symptoms;
    }

    public int getSymptomId() {
        return symptom_id;
    }

    public void setSymptomId(int symptomId) {
        this.symptom_id = symptomId;
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
        return visit_date;
    }

    public void setVisitDate(Date visitDate) {
        this.visit_date = visitDate;
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
                "symptomId=" + symptom_id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", visitDate=" + visit_date +
                ", symptoms='" + symptoms + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptoms symptoms1 = (Symptoms) o;
        return symptom_id == symptoms1.symptom_id &&
                patient == symptoms1.patient &&
                doctor == symptoms1.doctor &&
                visit == symptoms1.visit &&
                Objects.equals(visit_date, symptoms1.visit_date) &&
                Objects.equals(symptoms, symptoms1.symptoms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(symptom_id, patient, doctor, visit, visit_date, symptoms);
    }
}
