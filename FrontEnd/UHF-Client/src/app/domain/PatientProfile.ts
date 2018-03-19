import { Doctor } from "./Doctor";

export class PatientProfile {
    patient_id: number;
    // user_id: number;
    doctor: Doctor;
    first_name: string;
    last_name: string;
    ssn: number;
    dob: Date;
    phone_number: number;
    email: string;
    marital_status: string;
    gender: string;
    ethnicity: string;
    occupation: string;
    address: string;
    city: string;
    state: string;
    zipcode: number;
    insurance_provider: string;
    insurance_id: number;

    constructor(
        patient_id: number,
        // user_id: number,
        doctor: Doctor,
        first_name: string,
        last_name: string,
        ssn: number,
        dob: Date,
        phone_number: number,
        email: string,
        marital_status: string,
        gender: string,
        ethnicity: string,
        occupation: string,
        address: string,
        city: string,
        state: string,
        zipcode: number,
        insurance_provider: string,
        insurance_id: number
    ){
        this.patient_id = patient_id;
        // this.user_id = user_id;
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
}
