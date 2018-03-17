import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { FormService } from '../../../services/form.service';
import { Router } from '@angular/router';
import { ApptRecord } from '../../../domain/ApptRecord';
import { AuthorizationService } from '../../../services/authorization.service';

@Component({
  selector: 'app-appt-record-form',
  templateUrl: './appt-record-form.component.html',
  styleUrls: ['./appt-record-form.component.css']
})
export class ApptRecordFormComponent implements OnInit {

  submitted:boolean=false;
  reset:boolean=false;
  validForm:boolean=false;

  apptRecord:ApptRecord = new ApptRecord(0, null , 0, 0, "");

  constructor(
    private formService:FormService,
    private authService: AuthorizationService,
    private router:Router
  ) { }

  ngOnInit() {
    if (this.apptRecord.doctorId == 0 || this.apptRecord.visitDate == null || this.apptRecord.patientId == 0 || this.apptRecord.visitReason == ""){
      this.validForm = false;
    }
  }

  ngDoCheck(){
    if (this.validForm == false){
      if (this.apptRecord.doctorId != null && this.apptRecord.visitDate != null && this.apptRecord.doctorId != 0 && this.apptRecord.visitDate != null && this.apptRecord.visitReason != null && this.apptRecord.visitReason != ""){
        // remember to validate patient id: && this.apptRecord.patientId != 0 
        this.validForm = true;
      }
    }
    if (this.validForm == true){
      if (this.apptRecord.doctorId == 0 || this.apptRecord.visitDate == null || this.apptRecord.visitReason == ""){
        // remember to validate patient id: this.apptRecord.patientId == 0 
        this.validForm = false;
      }
    }
  }

  onSubmit(){
    if (this.apptRecord.doctorId != null && this.apptRecord.doctorId != 0 && this.apptRecord.visitDate != null && this.apptRecord.visitReason != null && this.apptRecord.patientId != 0 && this.apptRecord.visitReason != ""){
      this.submitted = true;
      console.log(this.apptRecord.doctorId);
      console.log(this.apptRecord.visitDate);
      console.log(this.apptRecord.visitReason);

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
    this.reset = true;
    this.router.navigate(['/home']);
  }
}
