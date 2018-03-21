import { Component, OnInit } from '@angular/core';
import { FormService } from '../../../services/form.service';
import { AuthorizationService } from '../../../services/authorization.service';
import { PatientProfile } from '../../../domain/PatientProfile';
import { Doctor } from '../../../domain/Doctor';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ApptRecord } from '../../../domain/ApptRecord';

@Component({
  selector: 'app-patient-profile',
  templateUrl: './patient-profile.component.html',
  styleUrls: ['./patient-profile.component.css']
})
export class PatientProfileComponent implements OnInit {

  patient: PatientProfile;
  apptRecords: ApptRecord[] = [];
  doctor: Doctor;
  doctor_id: number;
  updating:boolean=false;
  validForm:boolean=true;
  
  zipIsFIVE: boolean = false;
  phoneIsTEN: boolean = false;

  canCheck: boolean = false;

  searchVID: number;
  searchVDate: string;
  searchDoctorID: number;

  constructor(
    private formService: FormService,
    private authService: AuthorizationService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.formService.getPatientById(id).subscribe(p => {
      this.patient = p;
      this.doctor_id = p.doctor_id;
      this.formService.getDoctor(this.doctor_id).subscribe(p=> {
        this.doctor = p;
        console.log(this.doctor);
        this.validForm = true;
        this.canCheck = true;
      });
<<<<<<< HEAD
      this.formService.getAllApptRecords(id).subscribe(r =>{
        this.apptRecords = r;
        console.log(this.apptRecords);
      }) 
=======
      this.formService.getAllApptRecords(id).subscribe(r => this.apptRecords = r);
>>>>>>> 730dbb21cc08b657633cd91ae1a711e52d1ca06a
    });



    // DUMMY DATA
    // let doc = new Doctor();
    // doc.doctor_id=10;
    // doc.first_name="Flynn";
    // doc.last_name="Tan";

    // let p1: PatientProfile = new PatientProfile(1, 0,'Calvin','Zheng',123121234,new Date(1995,7,23), 1231231234,'cal@gmail.com',
    //   'single','male','asian','developer','1234 Main St','Reston','VA',11234,'United Health',12341234);
    // this.patient = p1;

<<<<<<< HEAD
    // DUMMY DATA FOR APPT RECORDS
=======
    // // DUMMY DATA FOR APPT RECORDS
>>>>>>> 730dbb21cc08b657633cd91ae1a711e52d1ca06a
    // let a1:ApptRecord = new ApptRecord(1, new Date(2018, 3, 2), 76, 5, "I'm on fire. Send help LOL");
    // let a2:ApptRecord = new ApptRecord(2, new Date(2018, 3,17), 76, 5, "I dropped too many chilis in my food. Send help LOL");
    // this.apptRecords.push(a1);
    // this.apptRecords.push(a2);

    // console.log(this.apptRecords);

  }

  ngDoCheck(){
    if (this.canCheck){
      if (this.patient.zipcode > 10000 &&  // Ths constantly checks if the ZIP input is 5 digits
        this.patient.zipcode < 99999){
          this.zipIsFIVE = true;
        }
        else {
          this.zipIsFIVE = false;
          this.validForm = false;
        }

      if (this.patient.phone_number > 1000000000 && this.patient.phone_number < 9999999999) {
        this.phoneIsTEN = true;
      }
      else {
        this.phoneIsTEN = false;
        this.validForm = false;
      }

      if (this.validForm == false){
          if (this.patient.address != "" &&
            this.patient.city != "" &&
            this.patient.doctor_id != null &&
            this.patient.email != null &&
            this.patient.ethnicity != "" &&
            this.patient.first_name != "" &&
            this.patient.last_name != "" &&
            this.patient.gender != "" &&
            this.patient.occupation != "" &&
            this.patient.marital_status != "" &&
            this.patient.phone_number != null &&
            this.patient.state != "" &&
            this.patient.zipcode != null &&
            this.patient.zipcode > 10000 &&
            this.patient.zipcode < 99999 &&
            this.patient.insurance_id != null &&
            this.patient.insurance_provider != ""
          ) {
          this.validForm = true;
        }
      }

      if(this.validForm == true){
        if (this.patient.address == "" ||
            this.patient.city == "" ||
            this.patient.doctor_id == null ||
            this.patient.email == null ||
            this.patient.ethnicity == "" ||
            this.patient.first_name == "" ||
            this.patient.last_name == "" ||
            this.patient.gender == "" ||
            this.patient.occupation == "" ||
            this.patient.marital_status == "" ||
            this.patient.phone_number == null ||
            this.patient.state == "" ||
            this.patient.zipcode == null ||
            this.patient.insurance_id == null ||
            this.patient.insurance_provider == ""
          ) {
          this.validForm = false;
        }
      }
    }
  }

  activateUpdate(){
    // switches form view
    this.updating = true;
  }

  updateForm(){
    // submit form update

    if (this.patient.address != "" &&
      this.patient.city != "" &&
      this.patient.doctor_id != null &&
      this.patient.email != null &&
      this.patient.ethnicity != "" &&
      this.patient.first_name != "" &&
      this.patient.last_name != "" &&
      this.patient.gender != "" &&
      this.patient.occupation != "" &&
      this.patient.marital_status != "" &&
      this.patient.phone_number != null &&
      this.patient.state != "" &&
      this.patient.zipcode != null &&
      this.patient.insurance_id != null &&
      this.patient.insurance_provider != ""){

      this.formService.updatePatientProfile(this.patient);
      console.log(this.patient);

      // after you finish updating the form, set it back to false
      this.updating = false;
      window.location.reload();
    }
  }

  cancel(){
    this.updating = false;
  }

}
