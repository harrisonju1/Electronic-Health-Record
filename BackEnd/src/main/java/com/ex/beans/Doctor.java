package com.ex.beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorsId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="field")
    private String field;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, String field) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.field = field;
    }

    public int getDoctorsId() {
        return doctorsId;
    }

    public void setDoctorsId(int doctorsId) {
        this.doctorsId = doctorsId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorsId=" + doctorsId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", field='" + field + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctors = (Doctor) o;
        return doctorsId == doctors.doctorsId &&
                Objects.equals(firstName, doctors.firstName) &&
                Objects.equals(lastName, doctors.lastName) &&
                Objects.equals(field, doctors.field);
    }

    @Override
    public int hashCode() {

        return Objects.hash(doctorsId, firstName, lastName, field);
    }
}
