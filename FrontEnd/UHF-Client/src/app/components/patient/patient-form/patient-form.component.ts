import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PatientProfile } from '../../../domain/PatientProfile';
import { FormService } from '../../../services/form.service';
import { Router } from '@angular/router';
import { Doctor } from '../../../domain/Doctor';
import { AuthorizationService } from '../../../services/authorization.service';

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css']
})
export class PatientFormComponent implements OnInit {

  submitted: boolean = false;
  reset: boolean = false;
  validForm: boolean = false;

  ssnIsNINE: boolean = false;
  zipIsFIVE: boolean = false;
  phoneIsTEN: boolean = false;

  patientProfile: PatientProfile = new PatientProfile(null, null, "", "", null, null, null, null, "", "", "", "", "", "", "", null, "", null);


  constructor(
    private formService: FormService,
    private authService: AuthorizationService,
    private router: Router
  ) { }

  ngOnInit() {
    if (this.patientProfile.address == "" ||
      this.patientProfile.city == "" ||
      this.patientProfile.dob == null ||
      this.patientProfile.doctor_id == null ||
      this.patientProfile.email == null ||
      this.patientProfile.ethnicity == "" ||
      this.patientProfile.first_name == "" ||
      this.patientProfile.last_name == "" ||
      this.patientProfile.gender == "" ||
      this.patientProfile.ssn == null ||
      this.patientProfile.occupation == "" ||
      this.patientProfile.marital_status == "" ||
      this.patientProfile.phone_number == null ||
      this.patientProfile.state == "" ||
      this.patientProfile.zipcode == null &&
      this.patientProfile.insurance_id == null ||
      this.patientProfile.insurance_provider == ""
    ) {
      this.validForm = false;
    }
  }

  ngDoCheck() {
    if (this.patientProfile.ssn < 999999999 &&  // This constantly checks if the SSN input is 9 digits
      this.patientProfile.ssn > 100000000) {
      this.ssnIsNINE = true;
    }
    else {
      this.ssnIsNINE = false;
      this.validForm = false;
    }

    if (this.patientProfile.zipcode > 10000 &&  // Ths constantly checks if the ZIP input is 5 digits
      this.patientProfile.zipcode < 99999) {
      this.zipIsFIVE = true;
    }
    else {
      this.zipIsFIVE = false;
      this.validForm = false;
    }

    if (this.patientProfile.phone_number > 1000000000 && this.patientProfile.phone_number < 9999999999) {
      this.phoneIsTEN = true;
    }
    else {
      this.phoneIsTEN = false;
      this.validForm = false;
    }

    if (this.validForm == false) {
      if (this.patientProfile.address != "" &&
        this.patientProfile.city != "" &&
        this.patientProfile.dob != null &&
        this.patientProfile.doctor_id != null &&
        this.patientProfile.email != null &&
        this.patientProfile.ethnicity != "" &&
        this.patientProfile.first_name != "" &&
        this.patientProfile.last_name != "" &&
        this.patientProfile.gender != "" &&
        this.patientProfile.ssn != null &&
        this.patientProfile.ssn < 999999999 &&
        this.patientProfile.ssn > 100000000 &&
        this.patientProfile.occupation != "" &&
        this.patientProfile.marital_status != "" &&
        this.patientProfile.phone_number != null &&
        this.patientProfile.state != "" &&
        this.patientProfile.zipcode != null &&
        this.patientProfile.zipcode > 10000 &&
        this.patientProfile.zipcode < 99999 &&
        this.patientProfile.insurance_id != null &&
        this.patientProfile.insurance_provider != ""
      ) {
        this.validForm = true;
      }
    }

    if (this.validForm == true) {
      if (this.patientProfile.address == "" ||
        this.patientProfile.city == "" ||
        !this.patientProfile.dob ||
        this.patientProfile.doctor_id == null ||
        this.patientProfile.email == "" ||
        this.patientProfile.ethnicity == "" ||
        this.patientProfile.first_name == "" ||
        this.patientProfile.last_name == "" ||
        this.patientProfile.gender == "" ||
        this.patientProfile.ssn == null ||
        this.patientProfile.occupation == "" ||
        this.patientProfile.marital_status == "" ||
        this.patientProfile.phone_number == null ||
        this.patientProfile.state == "" ||
        this.patientProfile.zipcode == null ||
        this.patientProfile.insurance_id == null ||
        this.patientProfile.insurance_provider == ""
      ) {
        this.validForm = false;
      }
    }
  }

  onSubmit() {

    if (this.patientProfile.address != "" &&
      this.patientProfile.city != "" &&
      this.patientProfile.dob != null &&
      this.patientProfile.doctor_id != null &&
      this.patientProfile.email != null &&
      this.patientProfile.ethnicity != "" &&
      this.patientProfile.first_name != "" &&
      this.patientProfile.last_name != "" &&
      this.patientProfile.gender != "" &&
      this.patientProfile.ssn != null &&
      this.patientProfile.occupation != "" &&
      this.patientProfile.marital_status != "" &&
      this.patientProfile.phone_number != null &&
      this.patientProfile.state != "" &&
      this.patientProfile.zipcode != null &&
      this.patientProfile.insurance_id != null &&
      this.patientProfile.insurance_provider != "") {

      this.submitted = true;

      // send patient profile to server
      this.formService.createPatientProfile(this.patientProfile);
    }
  }


  cancel() {
    this.reset = true;
    this.router.navigate(['/home']);
  }

  logout() {
    this.authService.logout();
  }

}
