package com.ex.beans;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="allergies")
public class Allergies {
    @Id
    @Column(name="allergy_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int allergy_id;

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
        return allergy_id;
    }

    public void setAllergyId(int allergy_id) {
        this.allergy_id = allergy_id;
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
                "allergy_id=" + allergy_id +
                ", patient=" + patient +
                ", allergy='" + allergy + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergies allergies = (Allergies) o;
        return allergy_id == allergies.allergy_id &&
                patient == allergies.patient &&
                Objects.equals(allergy, allergies.allergy);
    }

    @Override
    public int hashCode() {

        return Objects.hash(allergy_id, patient, allergy);
    }
}
