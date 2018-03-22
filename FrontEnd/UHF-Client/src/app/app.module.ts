import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, FormBuilder } from '@angular/forms';
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
import { PatientFormComponent } from './components/patient/patient-form/patient-form.component';
import { ApptRecordFormComponent } from './components/appointment/appt-record-form/appt-record-form.component';
import { FormService } from './services/form.service';
import { FilterPipe } from './pipes/filter.pipe';
import { IdfilterPipe } from './pipes/idfilter.pipe';
import { DatefilterPipe } from './pipes/datefilter.pipe';
import { VisitsComponent } from './components/appointment/visits/visits.component';
import { VidfilterPipe } from './pipes/vidfilter.pipe';
import { DocidfilterPipe } from './pipes/docidfilter.pipe';
import { VdatefilterPipe } from './pipes/vdatefilter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SearchPatientComponent,
    PatientProfileComponent,
    PatientFormComponent,
    ApptRecordFormComponent,
    FilterPipe,
    IdfilterPipe,
    DatefilterPipe,
    VisitsComponent,
    VidfilterPipe,
    DocidfilterPipe,
    VdatefilterPipe
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
