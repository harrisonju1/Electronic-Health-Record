package com.ex.beans;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="patient_id")
    private PatientProfile patient;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(int visitId) {
        this.visit_id = visitId;
    }

    public Date getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(Date visit_date) {
        this.visit_date = visit_date;
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

    public String getVisit_reason() {
        return visit_reason;
    }

    public void setVisit_reason(String visit_reason) {
        this.visit_reason = visit_reason;
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
