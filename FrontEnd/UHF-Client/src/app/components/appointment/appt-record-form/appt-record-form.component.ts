import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { FormService } from '../../../services/form.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ApptRecord } from '../../../domain/ApptRecord';
import { AuthorizationService } from '../../../services/authorization.service';
import { PatientProfile } from '../../../domain/PatientProfile';

@Component({
  selector: 'app-appt-record-form',
  templateUrl: './appt-record-form.component.html',
  styleUrls: ['./appt-record-form.component.css']
})
export class ApptRecordFormComponent implements OnInit {

  patient_id: number;
  submitted:boolean=false;
  validForm:boolean=false;
  isPositive: boolean=false;

  apptRecord:ApptRecord = new ApptRecord(0, null , 0, 0, "");

  constructor(
    private formService:FormService,
    private authService: AuthorizationService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.patient_id = +this.route.snapshot.paramMap.get('id');
    if (this.apptRecord.doctor_id <= 0 || this.apptRecord.doctor_id == null || this.apptRecord.visit_date == null || this.apptRecord.patient_id == 0 || this.apptRecord.visit_reason == ""){
      this.validForm = false;
    }
    
  }

  ngDoCheck(){

    if (this.apptRecord.doctor_id > 0){
        console.log(this.apptRecord.doctor_id);
        this.isPositive = true;
        console.log(this.isPositive);
      }
    else if (this.apptRecord.doctor_id <= 0 || this.apptRecord.doctor_id == null) {
        this.isPositive = false;
        this.validForm = false;
        console.log(this.isPositive);
      }

    if (this.validForm == false){
      if (this.apptRecord.visit_date != null && this.apptRecord.visit_date != null && this.apptRecord.visit_reason != null && this.apptRecord.visit_reason != ""){
        // remember to validate patient id: && this.apptRecord.patientId != 0 
        this.validForm = true;
      }
    }
    if (this.validForm == true){
      if (!this.apptRecord.visit_date || this.apptRecord.visit_reason == "" || this.isPositive == false){
        // remember to validate patient id: this.apptRecord.patientId == 0 
        this.validForm = false;
      }
    }
  }

  onSubmit(){
    if (this.apptRecord.doctor_id != null && this.apptRecord.doctor_id > 0 && this.apptRecord.visit_date != null && this.apptRecord.visit_reason != null && this.apptRecord.patient_id != 0 && this.apptRecord.visit_reason != ""){
      this.submitted = true;
      console.log(this.apptRecord.doctor_id);
      console.log(this.apptRecord.visit_date);
      console.log(this.apptRecord.visit_reason);

      this.apptRecord.patient_id = this.patient_id;
      this.formService.createApptRecord(this.apptRecord);
    }

  }
  
  // onSubmit(form:NgForm){
  //   // appt record form to be submitted from inside patient profile - already includes patient ID
  //   this.submitted = true;

  //   this.apptRecord.patientId; // grab from patient profile
  //   this.apptRecord.visitDate = form.value['visitDate'];
  //   // this.apptRecord.doctorId = form.value['doctorID'];
  //   this.apptRecord.doctorId = this.apptRecord.doctorId;
  //   this.apptRecord.visitReason = form.value['visitReason'];

  //   this.formService.createApptRecord(this.apptRecord);
    
  // }

  cancel(){
    this.router.navigate(['/patient/' + this.patient_id]);
  }
}
