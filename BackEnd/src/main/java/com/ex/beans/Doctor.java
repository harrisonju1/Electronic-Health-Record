package com.ex.beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @Column
    private int doctor_id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="field")
    private String field;

    public Doctor() {
    }

    public Doctor(int doctor_id){
        this.doctor_id = doctor_id;
    }

    public Doctor(String first_name, String last_name, String field) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.field = field;
    }

    public Doctor(int doctor_id, String first_name, String last_name, String field){
        this.doctor_id = doctor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.field = field;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastName) {
        this.last_name = lastName;
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
                "doctor_id=" + doctor_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", field='" + field + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctors = (Doctor) o;
        return doctor_id == doctors.doctor_id &&
                Objects.equals(first_name, doctors.first_name) &&
                Objects.equals(last_name, doctors.last_name) &&
                Objects.equals(field, doctors.field);
    }

    @Override
    public int hashCode() {

        return Objects.hash(doctor_id, first_name, last_name, field);
    }
}
