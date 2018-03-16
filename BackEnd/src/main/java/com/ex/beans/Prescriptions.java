package com.ex.beans;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="prescriptions")
public class Prescriptions {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionId;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private int patientId;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="visit_id")
    private Visit visit;

    @Column(name="visit_date")
    private Date visitDate;

    @Column(name="drugs")
    private String drugs;

    public Prescriptions() {
    }

    public Prescriptions(int patientId, Doctor doctor, Visit visit, Date visitDate, String drugs) {
        this.patientId = patientId;
        this.doctor = doctor;
        this.visit = visit;
        this.visitDate = visitDate;
        this.drugs = drugs;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
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

    public Visit getVisit() {
        return visit;
    }

    public void setVisitId(Visit visit) {
        this.visit = visit;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    @Override
    public String toString() {
        return "Prescriptions{" +
                "prescriptionId=" + prescriptionId +
                ", patientId=" + patientId +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", visitDate=" + visitDate +
                ", drugs='" + drugs + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescriptions that = (Prescriptions) o;
        return prescriptionId == that.prescriptionId &&
                patientId == that.patientId &&
                doctor == that.doctor &&
                visit == that.visit &&
                Objects.equals(visitDate, that.visitDate) &&
                Objects.equals(drugs, that.drugs);
    }

    @Override
    public int hashCode() {

        return Objects.hash(prescriptionId, patientId, doctor, visit, visitDate, drugs);
    }
}
