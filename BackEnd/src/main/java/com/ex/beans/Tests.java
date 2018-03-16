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
    private int testId;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private int patientId;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="visit_id")
    private Visit visit;

    @Column
    private Date visitDate;

    @Column(name="test")
    private String test;

    public Tests() {
    }

    public Tests(int patientId, Doctor doctor, Visit visit, Date visitDate, String test) {
        this.patientId = patientId;
        this.doctor = doctor;
        this.visit = visit;
        this.visitDate = visitDate;
        this.test = test;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Tests{" +
                "testId=" + testId +
                ", patientId=" + patientId +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", visitDate=" + visitDate +
                ", test='" + test + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tests tests = (Tests) o;
        return testId == tests.testId &&
                patientId == tests.patientId &&
                doctor == tests.doctor &&
                visit == tests.visit &&
                Objects.equals(visitDate, tests.visitDate) &&
                Objects.equals(test, tests.test);
    }

    @Override
    public int hashCode() {

        return Objects.hash(testId, patientId, doctor, visit, visitDate, test);
    }
}
