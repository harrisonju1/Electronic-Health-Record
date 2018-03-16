import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../../../services/authorization.service';
import { UserRole } from '../../../domain/User';

@Component({
  selector: 'app-med-history-form',
  templateUrl: './med-history-form.component.html',
  styleUrls: ['./med-history-form.component.css']
})
export class MedHistoryFormComponent implements OnInit {

  constructor(private authService:AuthorizationService) { 
    authService.authorizePage(UserRole.DOCTOR);
  }
  ngOnInit() {
  }

}
