import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FormService } from '../../../services/form.service';
import { Router } from '@angular/router';
import { ApptRecord } from '../../../domain/ApptRecord';

@Component({
  selector: 'app-appt-record-form',
  templateUrl: './appt-record-form.component.html',
  styleUrls: ['./appt-record-form.component.css']
})
export class ApptRecordFormComponent implements OnInit {

  submitted:boolean=false;
  reset:boolean=false;

  apptRecord:ApptRecord;

  constructor(
    private formService:FormService,
    private router:Router
  ) { }

  ngOnInit() {
  }

  onSubmit(form:NgForm){
    // appt record form to be submitted from inside patient profile - already includes patient ID
    this.submitted = true;

    this.apptRecord.patientId; // grab from patient profile
    this.apptRecord.visitDate = form.value['visitDate'];
    this.apptRecord.doctorId = form.value['doctorID'];
    this.apptRecord.visitReason = form.value['visitReason'];

    this.formService.createApptRecord(this.apptRecord);

  }

  cancel(){
    this.reset = true;
    this.router.navigate(['/home']);
  }
}
