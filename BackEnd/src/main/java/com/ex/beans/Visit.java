package com.ex.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="visits")
public class Visit {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitId;

    @Column(name="visit_date")
    private Date visitDate;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private int patientId;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @Column(name="visit_reason")
    private String visitReason;

    public Visit() {
    }

    public Visit(Date visitDate, int patientId, Doctor doctor, String visitReason) {
        this.visitDate = visitDate;
        this.patientId = patientId;
        this.doctor = doctor;
        this.visitReason = visitReason;
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

    public String getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visitId=" + visitId +
                ", visitDate=" + visitDate +
                ", patientId=" + patientId +
                ", doctor=" + doctor +
                ", visitReason='" + visitReason + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return visitId == visit.visitId &&
                patientId == visit.patientId &&
                doctor == visit.doctor &&
                Objects.equals(visitDate, visit.visitDate) &&
                Objects.equals(visitReason, visit.visitReason);
    }

    @Override
    public int hashCode() {

        return Objects.hash(visitId, visitDate, patientId, doctor, visitReason);
    }
}
