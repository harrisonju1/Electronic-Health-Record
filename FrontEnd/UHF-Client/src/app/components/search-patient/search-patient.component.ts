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
  filtered: boolean = false;
  searchText: string;
  searchID: number;
  searchDate: string;

  constructor(
    private authService: AuthorizationService,
    private formService: FormService
  ) { }

  ngOnInit() {
    // this.formService.getAllPatientProfiles().subscribe(plist => this.patients = plist);
    let doc = new Doctor();
    let p: PatientProfile = new PatientProfile(2,doc,'Kalvin','Aheng',123121234,new Date(2018,0,1), 1231231234,'cal@gmail.com',
      'single','male','asian','developer','1234 Main St','Reston','VA',11234,'United Health',12341234);
    let p1: PatientProfile = new PatientProfile(1,doc,'Calvin','Zheng',123121234,new Date(1995,7,23), 1231231234,'cal@gmail.com',
      'single','male','asian','developer','1234 Main St','Reston','VA',11234,'United Health',12341234);
    let p2: PatientProfile = new PatientProfile(4 ,doc, 'Kelvin', 'Dheng', 123121234,new Date(1992,3,4), 1231231234, 'cal@gmail.com',
    'single','male','asian','developer','1234 Main St','Reston','VA',11234,'United Health',12341234);
    let p3: PatientProfile = new PatientProfile(3 ,doc, 'Kalven', 'Rheng', 123121234,new Date(1993,3 ,4), 1231231234, 'cal@gmail.com',
    'single','male','asian','developer','1234 Main St','Reston','VA',11234,'United Health',12341234);
    let p4: PatientProfile = new PatientProfile(5 ,doc, 'Kelven', 'Hheng', 123121234,new Date(1980,3,4), 1231231234, 'cal@gmail.com',
    'single','male','asian','developer','1234 Main St','Reston','VA',11234,'United Health',12341234);

    this.patients.push(p);
    this.patients.push(p1);
    this.patients.push(p2);
    this.patients.push(p3);
    this.patients.push(p4);

    this.sort(0);
    this.filtered = false;
  }

  ngDoCheck(){
    this.touchedSearch();
  }

  sort(sortType: number) {
    /* SortTypes
        0 - ID
        1 - first_name
        2 - last_name
        3 - Date of Birth
    */
    // console.log(sortType);

    this.filtered = true;

    if (sortType == 0){

      this.patients.sort(function(obj1, obj2) {
        return obj1.patient_id - obj2.patient_id;
      })
    }
    else if(sortType == 1) {

      this.patients.sort(function(obj1,obj2) {
        if (obj1.first_name < obj2.first_name) return -1;
        if (obj1.first_name > obj2.first_name) return 1;
        return 0;
      })
    }
    else if(sortType == 2) {

      this.patients.sort(function(obj1, obj2) {
        if (obj1.last_name < obj2.last_name) return -1;
        if (obj1.last_name > obj2.last_name) return 1;
        return 0;
      })
    }
    else if (sortType == 3) {

      this.patients.sort(function(obj1, obj2) {
        if (obj1.dob < obj2.dob) return -1;
        if (obj1.dob > obj2.dob) return 1;
        return 0;
      })
    }
  }

  touchedSearch(){
    if (this.searchDate || this.searchID || this.searchText) {
      this.filtered = true;
    }
    else{
      this.filtered = false;
    }
  }

}
