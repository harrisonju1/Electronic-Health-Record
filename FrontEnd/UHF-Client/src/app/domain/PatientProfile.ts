import { zip } from "rxjs/operators";

export class PatientProfile {
    patient_id: number;
    user_id: number;
    doctor_id: number;
    firstname: string;
    lastname: string;
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
        user_id: number,
        doctor_id: number,
        firstname: string,
        lastname: string,
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
        this.user_id = user_id;
        this.doctor_id = doctor_id;
        this.firstname = firstname;
        this.lastname = lastname;
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