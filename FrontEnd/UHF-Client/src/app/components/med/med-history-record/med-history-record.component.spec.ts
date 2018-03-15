import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedHistoryRecordComponent } from './med-history-record.component';

describe('MedHistoryRecordComponent', () => {
  let component: MedHistoryRecordComponent;
  let fixture: ComponentFixture<MedHistoryRecordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedHistoryRecordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedHistoryRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
