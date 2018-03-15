import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApptRecordComponent } from './appt-record.component';

describe('ApptRecordComponent', () => {
  let component: ApptRecordComponent;
  let fixture: ComponentFixture<ApptRecordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApptRecordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApptRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
