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

    @OneToMany
    @JoinColumn(name="patient_id")
    private int patientId;

    @OneToMany
    @JoinColumn(name="doctor_id")
    private int doctorId;

    @OneToMany
    @JoinColumn(name="visit_id")
    private int visitId;

    @OneToMany
    @JoinColumn(name="visit_date")
    private Date visitDate;

    @Column(name="drugs")
    private String drugs;

    public Prescriptions() {
    }

    public Prescriptions(int patientId, int doctorId, int visitId, Date visitDate, String drugs) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitId = visitId;
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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
                ", doctorId=" + doctorId +
                ", visitId=" + visitId +
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
                doctorId == that.doctorId &&
                visitId == that.visitId &&
                Objects.equals(visitDate, that.visitDate) &&
                Objects.equals(drugs, that.drugs);
    }

    @Override
    public int hashCode() {

        return Objects.hash(prescriptionId, patientId, doctorId, visitId, visitDate, drugs);
    }
}
