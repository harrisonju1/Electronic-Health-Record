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

    @OneToMany
    @JoinColumn(name="doctor_id")
    private int doctorId;

    @OneToMany
    @JoinColumn(name="patient_id")
    private int patientId;

    @Column(name="treatment")
    private String treatment;

    @OneToMany
    @JoinColumn(name="visit_id")
    private int visitId;

    @OneToMany
    @JoinColumn(name="visit_date")
    private Date vistDate;

    public Treatments() {
    }

    public Treatments(int doctorId, int patientId, String treatment, int visitId, Date vistDate) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.treatment = treatment;
        this.visitId = visitId;
        this.vistDate = vistDate;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
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
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", treatment='" + treatment + '\'' +
                ", visitId=" + visitId +
                ", vistDate=" + vistDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatments that = (Treatments) o;
        return treatmentId == that.treatmentId &&
                doctorId == that.doctorId &&
                patientId == that.patientId &&
                visitId == that.visitId &&
                Objects.equals(treatment, that.treatment) &&
                Objects.equals(vistDate, that.vistDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(treatmentId, doctorId, patientId, treatment, visitId, vistDate);
    }
}

