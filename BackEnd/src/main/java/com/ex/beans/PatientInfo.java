package com.ex.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

public class PatientInfo {
    public int doctor_id;
    public int patient_id;
    public Doctor doctor;
    public String first_name;
    public String last_name;
    public int ssn;
    public Date dob;
    public String phone_number;
    public String email;
    public String marital_status;
    public String gender;
    public String ethnicity;
    public String occupation;
    public String address;
    public String city;
    public String state;
    public int zipcode;
    public String insurance_provider;
    public int insurance_id;

    public PatientInfo() {
    }

    public PatientInfo(int patient_id, int doctor_id, String first_name, String last_name, int ssn, Date dob, String phone_number, String email, String marital_status, String gender, String ethnicity, String occupation, String address, String city, String state, int zipcode, String insurance_provider, int insurance_id) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.ssn = ssn;
        this.dob = dob;
        this.phone_number = phone_number;
        this.email = email;
        this.marital_status = marital_status;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.occupation = occupation;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.insurance_provider = insurance_provider;
        this.insurance_id = insurance_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getInsurance_provider() {
        return insurance_provider;
    }

    public void setInsurance_provider(String insurance_provider) {
        this.insurance_provider = insurance_provider;
    }

    public int getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(int insurance_id) {
        this.insurance_id = insurance_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientInfo that = (PatientInfo) o;
        return doctor_id == that.doctor_id &&
                patient_id == that.patient_id &&
                ssn == that.ssn &&
                zipcode == that.zipcode &&
                insurance_id == that.insurance_id &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(first_name, that.first_name) &&
                Objects.equals(last_name, that.last_name) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(phone_number, that.phone_number) &&
                Objects.equals(email, that.email) &&
                Objects.equals(marital_status, that.marital_status) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(ethnicity, that.ethnicity) &&
                Objects.equals(occupation, that.occupation) &&
                Objects.equals(address, that.address) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(insurance_provider, that.insurance_provider);
    }

    @Override
    public int hashCode() {

        return Objects.hash(doctor_id, patient_id, doctor, first_name, last_name, ssn, dob, phone_number, email, marital_status, gender, ethnicity, occupation, address, city, state, zipcode, insurance_provider, insurance_id);
    }

    @Override
    public String toString() {
        return "PatientInfo{" +
                "doctor_id=" + doctor_id +
                ", patient_id=" + patient_id +
                ", doctor=" + doctor +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", ssn=" + ssn +
                ", dob=" + dob +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", marital_status='" + marital_status + '\'' +
                ", gender='" + gender + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", occupation='" + occupation + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", insurance_provider='" + insurance_provider + '\'' +
                ", insurance_id=" + insurance_id +
                '}';
    }
}
