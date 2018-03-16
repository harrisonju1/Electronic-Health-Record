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
    private int visit_id;

    @Column(name="visit_date")
    private Date visit_date;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private PatientProfile patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @Column(name="visit_reason")
    private String visit_reason;

    public Visit() {
    }

    public Visit(Date visitDate, PatientProfile patient, Doctor doctor, String visitReason) {
        this.visit_date = visitDate;
        this.patient = patient;
        this.doctor = doctor;
        this.visit_reason = visitReason;
    }

    public int getVisitId() {
        return visit_id;
    }

    public void setVisitId(int visitId) {
        this.visit_id = visitId;
    }

    public Date getVisitDate() {
        return visit_date;
    }

    public void setVisitDate(Date visitDate) {
        this.visit_date = visitDate;
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

    public String getVisitReason() {
        return visit_reason;
    }

    public void setVisitReason(String visitReason) {
        this.visit_reason = visitReason;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visitId=" + visit_id +
                ", visitDate=" + visit_date +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", visitReason='" + visit_reason + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return visit_id == visit.visit_id &&
                patient == visit.patient &&
                doctor == visit.doctor &&
                Objects.equals(visit_date, visit.visit_date) &&
                Objects.equals(visit_reason, visit.visit_reason);
    }

    @Override
    public int hashCode() {

        return Objects.hash(visit_id, visit_date, patient, doctor, visit_reason);
    }
}
