import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedHistoryComponent } from './med-history.component';

describe('MedHistoryComponent', () => {
  let component: MedHistoryComponent;
  let fixture: ComponentFixture<MedHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
