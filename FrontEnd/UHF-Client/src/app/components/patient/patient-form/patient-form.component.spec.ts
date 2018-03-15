import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientFormComponent } from './patient-form.component';
import { FormsModule, FormControl, FormGroup, NgForm } from '@angular/forms';

describe('PatientFormComponent', () => {
  let component: PatientFormComponent;
  let fixture: ComponentFixture<PatientFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientFormComponent ],
      imports: [ FormsModule ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should submit', () => {
    let ngf: NgForm;

    component.onSubmit(ngf);
    expect(component.submitted).toBeTruthy();
  });
  it('should reset form', () => {
    component.cancel();
    expect(component.reset).toBeTruthy();
  });
  it('should update form field', () => {
    expect(component.checkDuplicated()).toBeFalsy();
  });

});
