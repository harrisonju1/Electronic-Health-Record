import { Component, OnInit } from '@angular/core';
import { FormService } from '../../../services/form.service';
import { AuthorizationService } from '../../../services/authorization.service';
import { PatientProfile } from '../../../domain/PatientProfile';
import { Doctor } from '../../../domain/Doctor';
import { ActivatedRoute } from '@angular/router';
import { NgForm, FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-patient-profile',
  templateUrl: './patient-profile.component.html',
  styleUrls: ['./patient-profile.component.css']
})
export class PatientProfileComponent implements OnInit {

  patient: PatientProfile;
  updating:boolean=false;
  validForm:boolean=true;

  constructor(
    private formService: FormService,
    private authService: AuthorizationService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    // const id = +this.route.snapshot.paramMap.get('id');
    // this.formService.getPatientById(id).subscribe(p => this.patient = p);
    this.validForm = true;

    // DUMMY DATA
    let doc = new Doctor();
    doc.doctor_id=10;
    doc.firstname="Flynn";
    doc.lastname="Tan";

    let p1: PatientProfile = new PatientProfile(1,1,doc,'Calvin','Zheng',123121234,new Date(1995,7,23), 1231231234,'cal@gmail.com',
      'single','male','asian','developer','1234 Main St','Reston','VA',11234,'United Health',12341234);
    this.patient = p1;

  }

  ngDoCheck(){

    if (this.validForm == false){
        if (this.patient.address != "" &&
          this.patient.city != "" &&
          this.patient.doctor != null &&
          this.patient.email != null &&
          this.patient.ethnicity != "" &&
          this.patient.firstname != "" &&
          this.patient.lastname != "" &&
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
      if (this.patient.address == "" &&
          this.patient.city == "" &&
          this.patient.doctor == null &&
          this.patient.email == null &&
          this.patient.ethnicity == "" &&
          this.patient.firstname == "" &&
          this.patient.lastname == "" &&
          this.patient.gender == "" &&
          this.patient.occupation == "" &&
          this.patient.marital_status == "" &&
          this.patient.phone_number == null &&
          this.patient.state == "" &&
          this.patient.zipcode == null &&
          this.patient.zipcode < 10000 &&
          this.patient.zipcode > 99999 &&
          this.patient.insurance_id == null &&
          this.patient.insurance_provider == ""
        ) {
        this.validForm = false;
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
      this.patient.doctor != null &&
      this.patient.email != null &&
      this.patient.ethnicity != "" &&
      this.patient.firstname != "" &&
      this.patient.lastname != "" &&
      this.patient.gender != "" &&
      this.patient.occupation != "" &&
      this.patient.marital_status != "" &&
      this.patient.phone_number != null &&
      this.patient.state != "" &&
      this.patient.zipcode != null &&
      this.patient.insurance_id != null &&
      this.patient.insurance_provider != ""){

      this.formService.updatePatientProfile(this.patient);

      // after you finish updating the form, set it back to false
      this.updating = false;
    }
  }
}
