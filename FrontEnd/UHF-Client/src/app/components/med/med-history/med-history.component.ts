import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../../../services/authorization.service';

@Component({
  selector: 'app-med-history',
  templateUrl: './med-history.component.html',
  styleUrls: ['./med-history.component.css']
})
export class MedHistoryComponent implements OnInit {

  constructor(
    private authService: AuthorizationService
  ) { }

  ngOnInit() {
  }

}
