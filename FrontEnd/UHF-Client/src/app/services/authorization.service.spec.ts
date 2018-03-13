import { TestBed, async, inject } from '@angular/core/testing';

import { AuthorizationService } from './authorization.service';

import { HttpClientModule, HttpClient } from '@angular/common/http';

describe('AuthorizationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule],
      providers: [ AuthorizationService ]
    });
  });

  it('should be created', async(inject([AuthorizationService], (service: AuthorizationService) => {
    expect (service).toBeTruthy();
  })));

  it('should be not null', async(inject([AuthorizationService], (service: AuthorizationService) => {
    let username = "TB9999";
    let password = "tbell123";

    expect (service.login(username, password)).toBeTruthy();
  })));

  it('should be null/undefined/falsy', async(inject([AuthorizationService], (service: AuthorizationService) => {
    let username = "invalid";
    let password = "invalid";

    expect (service.login(username, password)).toBeUndefined();
  })));
});
