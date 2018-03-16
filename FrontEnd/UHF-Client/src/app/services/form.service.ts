import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PatientProfile } from '../domain/PatientProfile';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization':'Basic '+btoa('username'+':'+'password')})
}

@Injectable()
export class FormService {

  private patientUrl = 'http://localhost:8080/api/form/patient';
  private medUrl = 'http://localhost:8080/api/form/medical';
  private visitUrl = 'http://localhost:8080/api/form/visit';

  patientProfileList: PatientProfile[];
  currentPatientProfile: PatientProfile;

  constructor(
    private http: HttpClient
  ) { }

  
  createPatientProfile(form: PatientProfile){
    this.http.post(this.patientUrl, form, httpOptions);
    console.log(form);
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

}
