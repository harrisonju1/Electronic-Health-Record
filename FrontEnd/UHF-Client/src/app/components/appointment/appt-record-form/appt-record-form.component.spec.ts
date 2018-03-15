import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApptRecordFormComponent } from './appt-record-form.component';

describe('ApptRecordFormComponent', () => {
  let component: ApptRecordFormComponent;
  let fixture: ComponentFixture<ApptRecordFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApptRecordFormComponent ]
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
});
