package com.ex.beans;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="treatments")
public class Treatments {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int treatmentId;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private int patientId;

    @Column(name="treatment")
    private String treatment;

    @ManyToOne
    @JoinColumn(name="visit_id")
    private Visit visit;

    @Column(name="visit_date")
    private Date vistDate;

    public Treatments() {
    }

    public Treatments(Doctor doctor, int patientId, String treatment, Visit visit, Date vistDate) {
        this.doctor = doctor;
        this.patientId = patientId;
        this.treatment = treatment;
        this.visit = visit;
        this.vistDate = vistDate;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctorId(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public Date getVistDate() {
        return vistDate;
    }

    public void setVistDate(Date vistDate) {
        this.vistDate = vistDate;
    }

    @Override
    public String toString() {
        return "Treatments{" +
                "treatmentId=" + treatmentId +
                ", doctor=" + doctor +
                ", patientId=" + patientId +
                ", treatment='" + treatment + '\'' +
                ", visit=" + visit +
                ", vistDate=" + vistDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatments that = (Treatments) o;
        return treatmentId == that.treatmentId &&
                doctor == that.doctor &&
                patientId == that.patientId &&
                visit == that.visit &&
                Objects.equals(treatment, that.treatment) &&
                Objects.equals(vistDate, that.vistDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(treatmentId, doctor, patientId, treatment, visit, vistDate);
    }
}

