import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PatientProfile } from '../../../domain/PatientProfile';
import { FormService } from '../../../services/form.service';

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css']
})
export class PatientFormComponent implements OnInit {

  submitted: boolean = false;
  reset: boolean = false;
  patientProfile: PatientProfile;

  constructor(
    private formService: FormService
  ) { }

  ngOnInit() {
  }

  onSubmit(form:NgForm){
    this.submitted = true;

    this.patientProfile.doctor_id = form.value.doctor_id;
    this.patientProfile.firstname = form.value.firstname;
    this.patientProfile.lastname = form.value.lastname;
    this.patientProfile.ssn = form.value.ssn;
    this.patientProfile.dob = form.value.dob;
    this.patientProfile.phone_number = form.value.phone_number;
    this.patientProfile.email = form.value.email;
    this.patientProfile.marital_status = form.value.marital_status;
    this.patientProfile.gender = form.value.gender;
    this.patientProfile.ethnicity = form.value.ethnicity;
    this.patientProfile.occupation = form.value.occupation;
    this.patientProfile.address = form.value.address;
    this.patientProfile.city = form.value.city;
    this.patientProfile.state = form.value.state;
    this.patientProfile.zipcode = form.value.zipcode;
    this.patientProfile.insurance_provider = form.value.insurance_provider;
    this.patientProfile.insurance_id = form.value.insurance_id;
  }

  cancel(){
    this.reset = true;
  }

}
