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
    private int userId;
    @Column(name="doctor_id")
    private int doctorId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="ssn")
    private int ssn;
    @Column(name="dob")
    private Date dob;
    @Column(name="phone_number")
    private int phone_number;
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
    private int insuranceId;

    public PatientProfile(){
    }

    public PatientProfile(int userId, int doctorId, String firstName, String lastName, int ssn, Date dob, int phone_number, String email, String marital_status, String gender, String ethnicity, String occupation, String address, String city, String state, int zipcode, String insurance_provider, int insuranceId) {
        this.userId = userId;
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
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
        this.insuranceId = insuranceId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
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

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }


    @Override
    public String toString() {
        return "PatientProfile{" +
                "patientId=" + patientId +
                ", userId=" + userId +
                ", doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
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
                ", insuranceId=" + insuranceId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientProfile that = (PatientProfile) o;
        return patientId == that.patientId &&
                userId == that.userId &&
                doctorId == that.doctorId &&
                ssn == that.ssn &&
                phone_number == that.phone_number &&
                zipcode == that.zipcode &&
                insuranceId == that.insuranceId &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
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

        return Objects.hash(patientId, userId, doctorId, firstName, lastName, ssn, dob, phone_number, email, marital_status, gender, ethnicity, occupation, address, city, state, zipcode, insurance_provider, insuranceId);
    }
}
