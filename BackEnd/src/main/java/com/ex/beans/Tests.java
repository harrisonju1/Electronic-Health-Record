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
    @JoinColumn
    private Date visitDate;

    @Column(name="test")
    private String test;

    public Tests() {
    }

    public Tests(int patientId, int doctorId, int visitId, Date visitDate, String test) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitId = visitId;
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
                ", doctorId=" + doctorId +
                ", visitId=" + visitId +
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
                doctorId == tests.doctorId &&
                visitId == tests.visitId &&
                Objects.equals(visitDate, tests.visitDate) &&
                Objects.equals(test, tests.test);
    }

    @Override
    public int hashCode() {

        return Objects.hash(testId, patientId, doctorId, visitId, visitDate, test);
    }
}
