import { Component, OnInit } from '@angular/core';
import { User, UserRole } from '../../domain/User';
import { AuthorizationService } from '../../services/authorization.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentUser: User;
  loggedIn:boolean = false;

  constructor(
    private authService:AuthorizationService
  ) { 
    authService.authorizePage(UserRole.NONE);
  }

  ngOnInit() {
    this.currentUser = this.authService.getCurrentUser();

    if (this.currentUser != null) {
      this.loggedIn = true;
    }
  }

  ngDoCheck(){
    if(this.authService.currentUser != null){
      this.currentUser = this.authService.currentUser;
        this.loggedIn = true;
    }
  }

  logout(){
    this.currentUser = null;
    this.loggedIn = false;
    this.authService.logout();
  }

}
