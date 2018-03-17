import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApptRecordFormComponent } from './appt-record-form.component';

import { FormsModule, FormControl, FormGroup, NgForm } from '@angular/forms';

describe('ApptRecordFormComponent', () => {
  let component: ApptRecordFormComponent;
  let fixture: ComponentFixture<ApptRecordFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApptRecordFormComponent ],
      imports: [ FormsModule ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApptRecordFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should submit', () => {
    let ngf: NgForm;

    component.onSubmit();
    expect(component.submitted).toBeTruthy();
  });
  it('should reset form', () => {
    component.cancel();
    expect(component.reset).toBeTruthy();
  });
});
