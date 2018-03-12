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
    expect(service).toBeTruthy();
  })));

  
});
