import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PatientProfile } from '../domain/PatientProfile';
import { Observable } from 'rxjs/Observable';
import { ApptRecord } from '../domain/ApptRecord';
import { VisitDetails } from '../domain/VisitDetails';
import { User } from "../domain/User";
import { Doctor } from "../domain/Doctor";
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class FormService {

  private baseUrl = 'http://localhost:8080/api/';
  private authorizeUrl = this.baseUrl + 'authorize';

  private patientUrl = this.baseUrl + 'form/patient';
  private medUrl = this.baseUrl + 'form/medical';
  private visitUrl = this.baseUrl + 'form/visit';
  private doctorUrl = this.baseUrl + 'form/doctor';

  patientProfileList: PatientProfile[];
  currentPatientProfile: PatientProfile;
  apptRecord: ApptRecord;
  apptRecordsList: ApptRecord[];



  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  /* PATIENT FORM SERVICES ------------------------------------------------------------------------------- */

  createPatientProfile(form: PatientProfile) {
    console.log(form);
    this.http.post(this.patientUrl, form, httpOptions).subscribe();

    // console.log("here")

    // let data = "string";
    // console.log(data);
    // let obs = this.http.post<User>(this.authorizeUrl, data, httpOptions);
    // return obs;
    this.router.navigate(['/home']);
  }

  getDoctor(doctor_id: number): Observable<Doctor> {
    return this.http.get<Doctor>(this.doctorUrl + `?doctor_id=${doctor_id}`);
  }

  getAllPatientProfiles(): Observable<PatientProfile[]> {
    let ppl = this.http.get<PatientProfile[]>(this.patientUrl + "/all");
    ppl.subscribe(p => { this.patientProfileList = p });

    return ppl;
  }

  getPatientById(patient_id: number): Observable<PatientProfile> {
    let pp = this.http.get<PatientProfile>(this.patientUrl + `?patient_id=${patient_id}`);
    pp.subscribe(p => this.currentPatientProfile = p);
    return pp;
  }

  updatePatientProfile(profile: PatientProfile) {
    this.http.post(this.patientUrl + "/update", profile, httpOptions).subscribe();
    console.log(profile);
  }

  /* APPT RECORD FORM SERVICES ------------------------------------------------------------------------------- */
  createApptRecord(form: ApptRecord) {
    console.log("from createappt record:" + form.visit_date);
    this.http.post(this.visitUrl, form, httpOptions).subscribe();
    this.router.navigate(['/patient/' + form.patient_id]);
  }

  getAllApptRecords(patient_id: number): Observable<ApptRecord[]> {
    let records = this.http.get<ApptRecord[]>(this.visitUrl + `?patient_id=${patient_id}`);
    records.subscribe(r => this.apptRecordsList = r);
    return records;
  }

  getVisitDetailsByID(visit_id: number): Observable<VisitDetails> {
    // will need to have a VisitDetails class populated by Diagnosis, Symptoms, Treatment, Tests, and Prescription
    return this.http.get<VisitDetails>(this.visitUrl + '/details' + `?visit_id=${visit_id}`);
  }

  updateVisitDetails(visitDetails: VisitDetails) {
    console.log("updatevisit details was reached")
    this.http.post(this.visitUrl + "/update", visitDetails, httpOptions).subscribe();
  }
}
