package com.ex.beans;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="allergies")
public class Allergies {
    @Id
    @Column(name="allergy_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int allergyId;

    @Column(name="patient_id")
    private int patientId;

    @Column(name="allergy")
    private String allergy;

    public Allergies() {
    }

    public Allergies(int patientId, String allergy) {
        this.patientId = patientId;
        this.allergy = allergy;
    }

    public int getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(int allergyId) {
        this.allergyId = allergyId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    @Override
    public String toString() {
        return "Allergies{" +
                "allergyId=" + allergyId +
                ", patientId=" + patientId +
                ", allergy='" + allergy + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergies allergies = (Allergies) o;
        return allergyId == allergies.allergyId &&
                patientId == allergies.patientId &&
                Objects.equals(allergy, allergies.allergy);
    }

    @Override
    public int hashCode() {

        return Objects.hash(allergyId, patientId, allergy);
    }
}
