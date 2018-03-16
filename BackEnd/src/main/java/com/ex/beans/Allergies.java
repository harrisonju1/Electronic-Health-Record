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

    @ManyToOne
    @JoinColumn(name="patient_id")
    private PatientProfile patient;

    @Column(name="allergy")
    private String allergy;

    public Allergies() {
    }

    public Allergies(PatientProfile patient, String allergy) {
        this.patient = patient;
        this.allergy = allergy;
    }

    public int getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(int allergyId) {
        this.allergyId = allergyId;
    }

    public PatientProfile getPatient() {
        return patient;
    }

    public void setPatient(PatientProfile patient) {
        this.patient = patient;
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
                ", patient=" + patient +
                ", allergy='" + allergy + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergies allergies = (Allergies) o;
        return allergyId == allergies.allergyId &&
                patient == allergies.patient &&
                Objects.equals(allergy, allergies.allergy);
    }

    @Override
    public int hashCode() {

        return Objects.hash(allergyId, patient, allergy);
    }
}
