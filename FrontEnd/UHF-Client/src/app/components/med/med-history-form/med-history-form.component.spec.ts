import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedHistoryFormComponent } from './med-history-form.component';

describe('MedHistoryFormComponent', () => {
  let component: MedHistoryFormComponent;
  let fixture: ComponentFixture<MedHistoryFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedHistoryFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedHistoryFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
