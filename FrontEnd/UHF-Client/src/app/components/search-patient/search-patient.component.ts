import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../../services/authorization.service';
import { FormService } from '../../services/form.service';
import { PatientProfile } from '../../domain/PatientProfile';
import { Doctor } from '../../domain/Doctor';

@Component({
  selector: 'app-search-patient',
  templateUrl: './search-patient.component.html',
  styleUrls: ['./search-patient.component.css']
})
export class SearchPatientComponent implements OnInit {

  patients: PatientProfile[] = [];

  constructor(
    private authService: AuthorizationService,
    private formService: FormService
  ) { }

  ngOnInit() {
    // this.formService.getAllPatientProfiles().subscribe(plist => this.patients = plist);
    let doc = new Doctor();
    let p: PatientProfile = new PatientProfile(2,1,doc,'Kalvin','Zheng',123121234,new Date(2018,0,1), 1231231234,'cal@gmail.com',
      'single','male','asian','developer','1234 Main St','Reston','VA',11234,'United Health',12341234);
    let p1: PatientProfile = new PatientProfile(1,1,doc,'Calvin','Zheng',123121234,new Date(1995,7,23), 1231231234,'cal@gmail.com',
      'single','male','asian','developer','1234 Main St','Reston','VA',11234,'United Health',12341234);
    this.patients.push(p);
    this.patients.push(p1);
  }

}
