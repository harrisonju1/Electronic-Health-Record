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

    @Column(name="visit_date")
    private Date visit_date;

    @Column(name="drugs")
    private String drugs;

    public Prescriptions() {
    }

    public Prescriptions(PatientProfile patient, Doctor doctor, Visit visit, Date visit_date, String drugs) {
        this.patient = patient;
        this.doctor = doctor;
        this.visit = visit;
        this.visit_date = visit_date;
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
        return visit_date;
    }

    public void setVisitDate(Date visitDate) {
        this.visit_date = visitDate;
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
                "prescriptionId=" + prescription_id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", visitDate=" + visit_date +
                ", drugs='" + drugs + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescriptions that = (Prescriptions) o;
        return prescription_id == that.prescription_id &&
                patient == that.patient &&
                doctor == that.doctor &&
                visit == that.visit &&
                Objects.equals(visit_date, that.visit_date) &&
                Objects.equals(drugs, that.drugs);
    }

    @Override
    public int hashCode() {

        return Objects.hash(prescription_id, patient, doctor, visit, visit_date, drugs);
    }
}
