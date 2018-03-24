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

    @Column(name="symptom")
    private String symptoms;

    public Symptoms() {
    }

    public Symptoms(PatientProfile patient, Doctor doctor, Visit visit, String symptoms) {
        this.patient = patient;
        this.doctor = doctor;
        this.visit = visit;
        this.symptoms = symptoms;
    }

    public int getSymptom_id() {
        return symptom_id;
    }

    public void setSymptom_id(int symptom_id) {
        this.symptom_id = symptom_id;
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

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptoms symptoms1 = (Symptoms) o;
        return symptom_id == symptoms1.symptom_id &&
                Objects.equals(patient, symptoms1.patient) &&
                Objects.equals(doctor, symptoms1.doctor) &&
                Objects.equals(visit, symptoms1.visit) &&
                Objects.equals(symptoms, symptoms1.symptoms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(symptom_id, patient, doctor, visit, symptoms);
    }

    @Override
    public String toString() {
        return "Symptoms{" +
                "symptom_id=" + symptom_id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", symptoms='" + symptoms + '\'' +
                '}';
    }
}
