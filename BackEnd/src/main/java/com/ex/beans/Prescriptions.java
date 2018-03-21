package com.ex.beans;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="prescriptions")
public class Prescriptions {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescription_id;

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

    @Column(name="drug")
    private String drugs;

    public Prescriptions() {
    }

    public Prescriptions(PatientProfile patient, Doctor doctor, Visit visit, String drugs) {
        this.patient = patient;
        this.doctor = doctor;
        this.visit = visit;
        this.drugs = drugs;
    }

    public int getPrescriptionId() {
        return prescription_id;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescription_id = prescriptionId;
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

    public void setDoctor(int doctor_id) {
        this.doctor = doctor;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisitId(Visit visit) {
        this.visit = visit;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescriptions that = (Prescriptions) o;
        return prescription_id == that.prescription_id &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(visit, that.visit) &&
                Objects.equals(drugs, that.drugs);
    }

    @Override
    public int hashCode() {

        return Objects.hash(prescription_id, patient, doctor, visit, drugs);
    }

    @Override
    public String toString() {
        return "Prescriptions{" +
                "prescription_id=" + prescription_id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", drugs='" + drugs + '\'' +
                '}';
    }
}
