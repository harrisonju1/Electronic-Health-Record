import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PatientProfile } from '../domain/PatientProfile';
import { Observable } from 'rxjs/Observable';
import { ApptRecord } from '../domain/ApptRecord';
import { VisitDetails } from '../domain/VisitDetails';
import {User} from "../domain/User";

const httpOptions = {
  // headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization':'Basic '+btoa('username'+':'+'password')})
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
}

@Injectable()
export class FormService {

  private authorizeUrl = 'http://localhost:8080/api/authorize';

  private patientUrl = 'http://localhost:8080/api/form/patient';
  private medUrl = 'http://localhost:8080/api/form/medical';
  private visitUrl = 'http://localhost:8080/api/form/visit';

  patientProfileList: PatientProfile[];
  currentPatientProfile: PatientProfile;
  apptRecordsList: ApptRecord[];

  constructor(
    private http: HttpClient
  ) { }

  /* PATIENT FORM SERVICES ------------------------------------------------------------------------------- */

  createPatientProfile(form: PatientProfile){
    console.log(form);
    this.http.post(this.patientUrl, form, httpOptions).subscribe();

    // console.log("here")

    // let data = "string";
    // console.log(data);
    // let obs = this.http.post<User>(this.authorizeUrl, data, httpOptions);
    // return obs;
  }

  getAllPatientProfiles(): Observable<PatientProfile[]> {
    let ppl = this.http.get<PatientProfile[]>(this.patientUrl + "/all");
    ppl.subscribe(p => this.patientProfileList = p);
    return ppl;
  }

  getPatientById(patient_id: number): Observable<PatientProfile> {
    let pp = this.http.get<PatientProfile>(this.patientUrl + `${patient_id}`);
    pp.subscribe(p => this.currentPatientProfile = p);
    return pp;
  }

  updatePatientProfile(profile: PatientProfile){
    this.http.put(this.patientUrl+"/update", profile, httpOptions);
  }

  /* APPT RECORD FORM SERVICES ------------------------------------------------------------------------------- */
  createApptRecord(form:ApptRecord){
    this.http.post(this.visitUrl, form, httpOptions);
  }

  getAllApptRecords():Observable<ApptRecord[]>{
    let records = this.http.get<ApptRecord[]>(this.visitUrl + "/all");
    records.subscribe(r => this.apptRecordsList = r);
    return records;
  }

  getVisitDetailsByID(id:number):Observable<VisitDetails>{
    // will need to have a VisitDetails class populated by Diagnosis, Symptoms, Treatment, Tests, and Prescription
    return this.http.get<VisitDetails>(this.visitUrl + `${id}`);
  }
}
