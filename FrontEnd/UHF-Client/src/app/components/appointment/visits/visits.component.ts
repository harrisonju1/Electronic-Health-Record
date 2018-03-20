import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from '../../../services/authorization.service';
import { VisitDetails } from '../../../domain/VisitDetails';

@Component({
  selector: 'app-visits',
  templateUrl: './visits.component.html',
  styleUrls: ['./visits.component.css']
})
export class VisitsComponent implements OnInit {

  visit_id: number = 1;
  currentVisit: VisitDetails;

  constructor(
    private authService: AuthorizationService
  ) { }

  ngOnInit() {
    // this.currentVisit = new VisitDetails()
  }

}
