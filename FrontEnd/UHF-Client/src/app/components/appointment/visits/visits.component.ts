import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../../../services/authorization.service';
import { VisitDetails } from '../../../domain/VisitDetails';
import { ApptRecord } from '../../../domain/ApptRecord';
import { ActivatedRoute } from '@angular/router';
import { FormService } from '../../../services/form.service';
import { Doctor } from '../../../domain/Doctor';

@Component({
  selector: 'app-visits',
  templateUrl: './visits.component.html',
  styleUrls: ['./visits.component.css']
})
export class VisitsComponent implements OnInit {

  pID: number;
  visit_id: number = 1;
  currentVisit: VisitDetails;
  currentAppt: ApptRecord;
  currentDoctor: Doctor;
  isDoctor:boolean; // check if current user role is doctor
  userRole:string;

  canCheck: boolean = false;

  constructor(
    private authService: AuthorizationService,
    private formService: FormService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    // get the current user
    this.userRole = this.authService.getUserRole();
    console.log(this.userRole);

    if (this.userRole == "DOCTOR"){
      this.isDoctor = true;
    }

    // get patientID
    this.pID = +this.route.snapshot.paramMap.get('patient_id');

    // get visit details
    // const visID = +this.route.snapshot.paramMap.get('visit_id');
    // this.formService.getVisitDetailsByID(visID).subscribe(a => {
    //   this.currentVisit = a;
    // });

    // VISIT DETAILS DUMMY DATA
    this.currentVisit = new VisitDetails(1, 5, this.pID, ["You're on fire.", "Make a dragon wanna retire, man."], ["Very high temperatures.", "Fire.", "Burn baby burn."], ["Ice water.", "Burn cream.", "Sleep."], ["Ice Bath"], ["None"]);

    // get doctor information
    this.formService.getDoctor(this.currentVisit.doctor_id).subscribe(d => {
      this.currentDoctor = d;
      this.canCheck = true;
    });
  }

}
