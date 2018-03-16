package com.ex.beans;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="tests")
public class Tests {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int test_id;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private PatientProfile patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="visit_id")
    private Visit visit;

    @Column
    private Date visit_date;

    @Column(name="test")
    private String test;

    public Tests() {
    }

    public Tests(PatientProfile patient, Doctor doctor, Visit visit, Date visit_date, String test) {
        this.patient = patient;
        this.doctor = doctor;
        this.visit = visit;
        this.visit_date = visit_date;
        this.test = test;
    }

    public int getTestId() {
        return test_id;
    }

    public void setTestId(int testId) {
        this.test_id = testId;
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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Tests{" +
                "test_id=" + test_id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", visit_date=" + visit_date +
                ", test='" + test + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tests tests = (Tests) o;
        return test_id == tests.test_id &&
                patient == tests.patient &&
                doctor == tests.doctor &&
                visit == tests.visit &&
                Objects.equals(visit_date, tests.visit_date) &&
                Objects.equals(test, tests.test);
    }

    @Override
    public int hashCode() {

        return Objects.hash(test_id, patient, doctor, visit, visit_date, test);
    }
}
