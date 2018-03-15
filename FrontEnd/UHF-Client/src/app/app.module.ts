import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
// import { HttpModule } from '@angular/http';


import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { AuthorizationService } from './services/authorization.service';
import { AppRoutingModule } from './app-routing.module';

import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';

import { AuthGuard } from './guard/auth.guard';
import { SearchPatientComponent } from './components/search-patient/search-patient.component';
import { PatientProfileComponent } from './components/patient/patient-profile/patient-profile.component';
import { MedHistoryComponent } from './components/med/med-history/med-history.component';
import { MedInfoComponent } from './components/med/med-info/med-info.component';
import { PatientFormComponent } from './components/patient/patient-form/patient-form.component';
import { ApptRecordFormComponent } from './components/appointment/appt-record-form/appt-record-form.component';
import { ApptRecordComponent } from './components/appointment/appt-record/appt-record.component';
import { MedHistoryRecordComponent } from './components/med/med-history-record/med-history-record.component';
import { MedHistoryFormComponent } from './components/med/med-history-form/med-history-form.component';
import { FormService } from './services/form.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SearchPatientComponent,
    PatientProfileComponent,
    MedHistoryComponent,
    MedInfoComponent,
    PatientFormComponent,
    ApptRecordFormComponent,
    ApptRecordComponent,
    MedHistoryRecordComponent,
    MedHistoryFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
    // and returns simulated server responses.
    // Remove it when a real server is ready to receive requests.
    // HttpClientInMemoryWebApiModule.forRoot(
    //   InMemoryDataService, { dataEncapsulation: false }
    // )
  ],
  providers: [
    AuthorizationService,
    FormService,
    AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
