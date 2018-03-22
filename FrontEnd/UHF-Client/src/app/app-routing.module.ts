import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'; 
import { CommonModule } from '@angular/common';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SearchPatientComponent } from './components/search-patient/search-patient.component';
import { PatientProfileComponent } from './components/patient/patient-profile/patient-profile.component';
import { PatientFormComponent } from './components/patient/patient-form/patient-form.component';
import { ApptRecordFormComponent } from './components/appointment/appt-record-form/appt-record-form.component';
import { AuthGuard } from './guard/auth.guard';
import { VisitsComponent } from './components/appointment/visits/visits.component';


// add AuthGuard to protected routes
const routes : Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'search', component: SearchPatientComponent, canActivate:[AuthGuard]},
  { path: 'patient/:id', component: PatientProfileComponent, canActivate: [AuthGuard]},
  { path: 'patient/:patient_id/visit/:visit_id', component: VisitsComponent, canActivate: [AuthGuard]},
  { path: 'form/patient', component: PatientFormComponent, canActivate: [AuthGuard]},
  { path: 'form/appointment/:id', component: ApptRecordFormComponent, canActivate: [AuthGuard]},
  { path: '', redirectTo: '/home', pathMatch: 'full' }
]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ],
  declarations: []
})
export class AppRoutingModule { }
