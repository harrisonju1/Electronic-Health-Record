package com.ex.beans;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="treatments")
public class Treatments {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int treatment_id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="patient_id")
    private PatientProfile patient;

    @Column(name="treatment")
    private String treatment;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="visit_id")
    private Visit visit;

    public Treatments() {
    }

    public Treatments(Doctor doctor, PatientProfile patient, String treatment, Visit visit) {
        this.doctor = doctor;
        this.patient = patient;
        this.treatment = treatment;
        this.visit = visit;
    }

    public int getTreatmentId() {
        return treatment_id;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatment_id = treatmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctorId(Doctor doctor) {
        this.doctor = doctor;
    }

    public PatientProfile getPatient() {
        return patient;
    }

    public void setPatient(PatientProfile patient) {
        this.patient = patient;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisitId(Visit visit) {
        this.visit = visit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatments that = (Treatments) o;
        return treatment_id == that.treatment_id &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(treatment, that.treatment) &&
                Objects.equals(visit, that.visit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(treatment_id, doctor, patient, treatment, visit);
    }

    @Override
    public String toString() {
        return "Treatments{" +
                "treatment_id=" + treatment_id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", treatment='" + treatment + '\'' +
                ", visit=" + visit +
                '}';
    }
}

