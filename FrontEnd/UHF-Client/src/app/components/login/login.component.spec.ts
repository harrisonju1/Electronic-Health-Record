import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { FormsModule } from '@angular/forms';
import { AuthorizationService } from '../../services/authorization.service';
import { HttpClientModule } from '@angular/common/http';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [ FormsModule, HttpClientModule ],
      providers: [ AuthorizationService ]
      
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create the login component", async(() => {
    expect(component).toBeTruthy();
  }));

  it("should get test username", async(() => {
    expect(component.username).toBeTruthy();
  }));

  it("should get valid username", async(() => {
    let username = "RC0110";
    let password = "rcorona123";

    expect(component.login(username, password)).toBeTruthy();
  }));

});
