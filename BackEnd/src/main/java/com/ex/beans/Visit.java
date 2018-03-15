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

    @Id
    @Column(name="visit_date")
    private Date visitDate;


    @OneToMany
    @JoinColumn(name="patient_id")
    private int patientId;

    @OneToMany
    @JoinColumn(name="doctor_id")
    private int doctorId;

    @Column(name="visit_reason")
    private String visitReason;

    public Visit() {
    }

    public Visit(Date visitDate, int patientId, int doctorId, String visitReason) {
        this.visitDate = visitDate;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitReason = visitReason;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visitId=" + visitId +
                ", visitDate=" + visitDate +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
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
                doctorId == visit.doctorId &&
                Objects.equals(visitDate, visit.visitDate) &&
                Objects.equals(visitReason, visit.visitReason);
    }

    @Override
    public int hashCode() {

        return Objects.hash(visitId, visitDate, patientId, doctorId, visitReason);
    }
}
