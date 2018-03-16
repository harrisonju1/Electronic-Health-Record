package com.ex.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

//declare which table this bean is for
@Entity
@Table(name="patientprofile")
public class PatientProfile {
    //set up primary key which is patient_id
    @Id
    @Column(name="patient_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int patientId;
    //set up rest of columns
    //unsure what to do with reference key for now
    //initialize all columns with database column name to match
    @Column(name="user_id")
    private int user_id;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="ssn")
    private int ssn;
    @Column(name="dob")
    private Date dob;
    @Column(name="phone_number")
    private String phone_number;
    @Column(name="email")
    private String email;
    @Column(name="marital_status")
    private String marital_status;
    @Column(name="gender")
    private String gender;
    @Column(name="ethnicity")
    private String ethnicity;
    @Column(name="occupation")
    private String occupation;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="zipcode")
    private int zipcode;
    @Column(name="insurance_provider")
    private String insurance_provider;
    @Column(name="insurance_id")
    private int insurance_id;

    public PatientProfile(){
    }

    public PatientProfile(int user_id, Doctor doctor, String first_name, String last_name, int ssn, Date dob, String phone_number, String email, String marital_status, String gender, String ethnicity, String occupation, String address, String city, String state, int zipcode, String insurance_provider, int insurance_id) {
        this.user_id = user_id;
        this.doctor = doctor;
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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctorId(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
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

    public String getEmail() { return email; }

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

    public int getInsuranceId() {
        return insurance_id;
    }

    public void setInsuranceId(int insuranceId) {
        this.insurance_id = insuranceId;
    }


    @Override
    public String toString() {
        return "PatientProfile{" +
                "patientId=" + patientId +
                ", user_id=" + user_id +
                ", doctor=" + doctor +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", ssn=" + ssn +
                ", dob=" + dob +
                ", phone_number=" + phone_number +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientProfile that = (PatientProfile) o;
        return patientId == that.patientId &&
                user_id == that.user_id &&
                doctor == that.doctor &&
                ssn == that.ssn &&
                phone_number == that.phone_number &&
                zipcode == that.zipcode &&
                insurance_id == that.insurance_id &&
                Objects.equals(first_name, that.first_name) &&
                Objects.equals(last_name, that.last_name) &&
                Objects.equals(dob, that.dob) &&
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

        return Objects.hash(patientId, user_id, doctor, first_name, last_name, ssn, dob, phone_number, email, marital_status, gender, ethnicity, occupation, address, city, state, zipcode, insurance_provider, insurance_id);
    }
}
