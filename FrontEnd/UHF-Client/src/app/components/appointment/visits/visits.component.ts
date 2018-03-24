import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../../../services/authorization.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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
  isDoctor: boolean; // check if current user role is doctor
  userRole: string;
  updating: boolean = false; //check if page is in update mode

  canCheck: boolean = false;
  error1: boolean = false;
  error2: boolean = false;
  error3: boolean = false;
  error4: boolean = false;
  error5: boolean = false;

  //ngModel binding for new details
  diagnosis: string;
  symptom: string;
  prescription: string;
  treatment: string;
  test_result: string;

  constructor(
    private authService: AuthorizationService,
    private formService: FormService,
    private route: ActivatedRoute,
    private http: HttpClient,
  ) { }

  ngOnInit() {
    // get the current user
    this.userRole = this.authService.getUserRole();
    console.log(this.userRole);

    if (this.userRole == "DOCTOR") {
      this.isDoctor = true;
    }
    
    // get patientID
    this.pID = +this.route.snapshot.paramMap.get('patient_id');

    // get visit details
    const visID = +this.route.snapshot.paramMap.get('visit_id');
    this.formService.getVisitDetailsByID(visID).subscribe(a => {
      this.currentVisit = a;

      //   // get doctor information
      this.formService.getDoctor(this.currentVisit.doctor_id).subscribe(d => {
        this.currentDoctor = d;
        this.canCheck = true;
      });
    });

    // VISIT DETAILS DUMMY DATA
    // this.currentVisit = new VisitDetails(1, 5, this.pID, ["You're on fire.", "Make a dragon wanna retire, man."], ["Very high temperatures.", "Fire.", "Burn baby burn."], ["Ice water.", "Burn cream.", "Sleep."], ["Ice Bath"], ["None"]);
    // get doctor information
    // this.formService.getDoctor(this.currentVisit.doctor_id).subscribe(d => {
    //   this.currentDoctor = d;
    //   this.canCheck = true;
    // });
  }

  ngDoCheck() {
  }

  // ------------------------ Download PDF ------------------------------------
  downloadAdPDF() {
    // todo
    // FileSaver.saveas(new Blob(), 'visitdetails.pdf');
    const fileUrl = this.formService.baseUrl + 'pdf/visitdetails';
    var data = {};
    console.log('Saving '+data+'.');
    let headers = {headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Accept': 'application/pdf' })};
    this.http.post(fileUrl, data, headers).subscribe((pdfFile)=>{
      console.log('got response '+pdfFile+'.');
      const blob = new Blob(pdfFile, { type: 'application/pdf' });
      const url = window.URL.createObjectURL(blob);
      window.open(url);
    });
  }

  // ------------------------ UPDATING/REMOVING DIAGNOSES ----------------------

  addDiagnosis() {
    if (this.diagnosis) {
      this.currentVisit.diagnosis.push(this.diagnosis);
      this.diagnosis = "";
      this.error1 = false;
    }
    else {
      this.error1 = true;
    }
  }

  removeDiagnosis(d: string) {
    let diagnoses = this.currentVisit.diagnosis;
    let index = diagnoses.indexOf(this.diagnosis);
    diagnoses.splice(index, 1);
  }

  // ------------------------ UPDATING/REMOVING SYMPTOMS -----------------------
  addSymptom() {
    if (this.symptom) {
      this.currentVisit.symptoms.push(this.symptom);
      this.symptom = "";
      this.error2 = false;
    }
    else {
      this.error2 = true;
    }
  }

  removeSymptom(s: string) {
    let symptoms = this.currentVisit.symptoms;
    let index = symptoms.indexOf(s);
    symptoms.splice(index, 1);
  }

  // ----------------------- UPDATING/REMOVING PRESCRIPTIONS ----------------------
  addPrescription() {
    if (this.prescription) {
      this.currentVisit.prescriptions.push(this.prescription);
      this.prescription = "";
      this.error3 = false;
    }
    else {
      this.error3 = true;
    }
  }

  removePrescription(p: string) {
    let pscrip = this.currentVisit.prescriptions;
    let index = pscrip.indexOf(p);
    pscrip.splice(index, 1);
  }

  // ------------------------ UPDATING/REMOVING TREATMENTS ----------------------
  addTreatment() {
    if (this.treatment) {
      this.currentVisit.treatments.push(this.treatment);
      this.treatment = "";
      this.error4 = false;
    }
    else {
      this.error4 = true;
    }
  }

  removeTreatment(t: string) {
    let treatments = this.currentVisit.treatments;
    let index = treatments.indexOf(t);
    treatments.splice(index, 1);
  }

  // ----------------------- UPDATING/REMOVING TEST RESULTS ---------------------
  addTestResult() {
    if (this.test_result) {
      this.currentVisit.tests.push(this.test_result);
      this.test_result = "";
      this.error5 = false;
    }
    else {
      this.error5 = true;
    }
  }

  removeTestResult(t: string) {
    let tests = this.currentVisit.tests;
    let index = tests.indexOf(t);
    tests.splice(index, 1);
  }

  // ---------------------- TOGGLING UPDATE MODE ------------------------------
  activateUpdate() {
    this.updating = true;
  }

  finishUpdate() {
    console.log("finish update was reached");
    this.formService.updateVisitDetails(this.currentVisit);
    this.updating = false;
  }

  logout() {
    this.authService.logout();
  }
}
