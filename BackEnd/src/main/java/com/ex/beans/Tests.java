package com.ex.beans;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Column(name="test")
    private String test;

    public Tests() {
    }

    public Tests(PatientProfile patient, Doctor doctor, Visit visit, String test) {
        this.patient = patient;
        this.doctor = doctor;
        this.visit = visit;
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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tests tests = (Tests) o;
        return test_id == tests.test_id &&
                Objects.equals(patient, tests.patient) &&
                Objects.equals(doctor, tests.doctor) &&
                Objects.equals(visit, tests.visit) &&
                Objects.equals(test, tests.test);
    }

    @Override
    public int hashCode() {

        return Objects.hash(test_id, patient, doctor, visit, test);
    }

    @Override
    public String

    toString() {
        return "Tests{" +
                "test_id=" + test_id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", visit=" + visit +
                ", test='" + test + '\'' +
                '}';
    }
}
